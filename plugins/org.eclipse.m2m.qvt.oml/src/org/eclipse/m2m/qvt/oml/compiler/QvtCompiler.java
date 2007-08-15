/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.compiler;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.qvt.oml.QvtMessage;
import org.eclipse.m2m.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEnv;
import org.eclipse.m2m.qvt.oml.ast.parser.QvtOperationalParser;
import org.eclipse.m2m.qvt.oml.common.Logger;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.common.io.CFile;
import org.eclipse.m2m.qvt.oml.common.io.CFileUtil;
import org.eclipse.m2m.qvt.oml.common.io.CFolder;
import org.eclipse.m2m.qvt.oml.common.io.eclipse.WorkspaceMetamodelRegistryProvider;
import org.eclipse.m2m.qvt.oml.emf.util.mmregistry.IMetamodelRegistryProvider;
import org.eclipse.m2m.qvt.oml.expressions.ExpressionsFactory;
import org.eclipse.m2m.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.internal.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory;
import org.eclipse.m2m.qvt.oml.internal.cst.ImportCS;
import org.eclipse.m2m.qvt.oml.internal.cst.LibraryImportCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS;
import org.eclipse.m2m.qvt.oml.library.QvtLibraryCreator;
import org.eclipse.m2m.qvt.oml.ocl.completion.CompletionData;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.internal.cst.PathNameCS;
import org.eclipse.osgi.util.NLS;


/**
 * @author pkobiakov
 */
public class QvtCompiler {

    public static final String PROBLEM_MARKER = "org.eclipse.m2m.qvt.oml.qvtProblem"; //$NON-NLS-1$

	public QvtCompiler(IImportResolver importResolver, IMetamodelRegistryProvider metamodelRegistryProvider) {
	    mySyntaxModules = new LinkedHashMap<CFile, ParsedModuleCS>();
	    myCompilationResults = new IdentityHashMap<ParsedModuleCS, QvtCompilationResult>();
        mySyntaxToSemanticMap = new HashMap<MappingModuleCS, Module>();
        myImportResolver = importResolver;
        
        this.metamodelRegistryProvider = metamodelRegistryProvider;
        this.resourceSet = (metamodelRegistryProvider instanceof WorkspaceMetamodelRegistryProvider) ?
        		((WorkspaceMetamodelRegistryProvider) metamodelRegistryProvider).getResolutionResourceSet() : 
        			new ResourceSetImpl();
    }
	
	public QvtCompiler(IImportResolver importResolver) {
		this(importResolver, new WorkspaceMetamodelRegistryProvider());
    }	
	
	public IMetamodelRegistryProvider getMetamodelRegistryProvider() {
		return metamodelRegistryProvider;
	}
	
	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	/**
	 * Convenience method for compile(CFile[] sources, QvtCompilerOptions options, IProgressMonitor monitor)
	 */
    public QvtCompilationResult compile(CFile source, QvtCompilerOptions options, IProgressMonitor monitor) throws MdaException {
        return compile(new CFile[] {source}, options, monitor)[0];
    }

    /**
     * The main compilation method - the common entry point to the compilation 
     */
	public QvtCompilationResult[] compile(CFile[] sources, QvtCompilerOptions options, IProgressMonitor monitor) throws MdaException {
        if (monitor == null) {
            monitor = new NullProgressMonitor();
        }
             
        List<ParsedModuleCS> mmaList = new ArrayList<ParsedModuleCS>(sources.length);
        for (CFile source : sources) {
        	try {
				mmaList.add(parse(source));
			} 
			catch (IOException e) {
				Throwable cause = e.getCause() != null ? e.getCause() : e;
				throw new MdaException(cause.getMessage(), cause);
			}
        }
        
        Map<ParsedModuleCS, List<ParsedModuleCS>> removedImportCycles =
        	new IdentityHashMap<ParsedModuleCS, List<ParsedModuleCS>>();
        for (ParsedModuleCS parsed : mmaList) {
            checkRemoveCycles(parsed, removedImportCycles);
        }

        ImportCompiler importCompiler = new ImportCompiler(removedImportCycles, options);
        List<QvtCompilationResult> resultList = new ArrayList<QvtCompilationResult>(); 
        for (ParsedModuleCS parsed : mmaList) {
        	QvtCompilationResult qvtCompilationResult = analyse(parsed, options);
            resultList.add(qvtCompilationResult);
        	importCompiler.compileImports(qvtCompilationResult.getModule(), parsed);
        }
        
        return resultList.toArray(new QvtCompilationResult[resultList.size()]);
    }
    
    private void checkRemoveCycles(ParsedModuleCS module, Map<ParsedModuleCS, List<ParsedModuleCS>> removedCycles) {
    	for (;;) {
        	Object[] cycle = SyntaxUtil.findFirstImportCycle(module);
        	if (cycle == null) {
        		break;
        	}
        	
        	ParsedModuleCS from = (ParsedModuleCS) cycle[0];
        	ParsedModuleCS to = (ParsedModuleCS) cycle[1];
    		
    		String fromIdentifier = from.getStringName(); 
    		String toIdentifier = to.getStringName(); 
    		from.addMessage(new QvtMessage(NLS.bind(CompilerMessages.cyclicImportError, toIdentifier,
    				fromIdentifier), from.getModuleCS().getHeaderCS().getPathNameCS()));
    		if (to != from) {
    			to.addMessage(new QvtMessage(NLS.bind(CompilerMessages.cyclicImportError, fromIdentifier,
    					toIdentifier), to.getModuleCS().getHeaderCS().getPathNameCS()));
    		}
    		
    		boolean removed = false;
    		for (Iterator<ParsedModuleCS> impIt = from.getParsedImports().iterator(); impIt.hasNext(); ) {
    			ParsedModuleCS imported = impIt.next();
    			if (imported == to) {
    				impIt.remove();
    				removed = true;
    				
    				if (!removedCycles.containsKey(from)) {
    					removedCycles.put(from, new ArrayList<ParsedModuleCS>(3));
    				}
    				removedCycles.get(from).add(imported);
    			}
    		}
    		assert removed : "False cycle: " + Arrays.asList(cycle); //$NON-NLS-1$    		
        }
    }

    private ParsedModuleCS parse(final CFile source) throws IOException {
    	ParsedModuleCS result = mySyntaxModules.get(source);        
    	if (result != null) {
        	return result;
        }

        Reader is = CFileUtil.getReader(source);
        QvtOperationalParser qvtParser = new QvtOperationalParser();
        MappingModuleCS moduleCS = null;
        try {
        	moduleCS = qvtParser.parse(is, source.getName());
        } finally {
            try { 
            	is.close(); 
            } catch (IOException e) {
            }
        }

        if (moduleCS == null) {
        	moduleCS = CSTFactory.eINSTANCE.createMappingModuleCS();
        }

        result = new ParsedModuleCS(moduleCS, source);
        result.addMessages(qvtParser.getErrorsList());
        result.addMessages(qvtParser.getWarningsList());
        
        mySyntaxModules.put(source, result);
    	parseImportedModules(result);

        return result;
    }
    
    private void parseImportedModules(ParsedModuleCS module) {
    	Set<String> importedModules = new HashSet<String>();
    	for (ImportCS importCS : module.getModuleCS().getImports()) {
			if (importCS instanceof LibraryImportCS) {
				continue;
			}
			PathNameCS importQName = importCS.getPathNameCS();
            if (importQName == null) {
                module.addMessage(new QvtMessage(CompilerMessages.emptyImport));
                continue;
            }

            String importString = QvtOperationalParserUtil.getStringRepresentation(importQName, "."); //$NON-NLS-1$
        	if (importedModules.contains(importString)) {
        		module.addMessage(new QvtMessage(NLS.bind(CompilerMessages.moduleAlreadyImported, importString),
        				QvtMessage.SEVERITY_WARNING, importQName));
        	} else {
            	ParsedModuleCS impResult = getImportedModule(module.getSource(), importString);
                if (impResult == null) {
                	module.addMessage(new QvtMessage(NLS.bind(CompilerMessages.importedModuleNotFound,
                			importString), importQName)); //$NON-NLS-1$
                } else {                	
//                	if (importCS instanceof ModuleImportCS) {
//                		((ModuleImportCS) importCS).setParsedModule(impResult);
//                	}
                    module.addParsedImport(impResult, importQName);
                    importedModules.add(importString);
                }
        	}
        }    	
    }    

    public QvtCompilationResult analyse(final ParsedModuleCS mma, QvtCompilerOptions options) {
    	return analyse(mma, options, null);
    }
    
    public QvtCompilationResult analyse(final ParsedModuleCS mma, QvtCompilerOptions options,
    		QvtOperationalEnv env) {
        QvtCompilationResult result = myCompilationResults.get(mma);
        if (result != null && result.getModule() != null) {
            return result;
        }
        
        Module module = null;
        Map syntaxToSemanticMap = new IdentityHashMap();
        Map syntaxToEnvironmentMap = new IdentityHashMap();
        Map semanticToEnvironmentMap = new IdentityHashMap();
        List<QvtMessage> allMessages = new ArrayList<QvtMessage>();
        Collections.addAll(allMessages, mma.getMessages());
        
        if (mma.getStringName() != null) {
            // add new operations here as otherwise types instantiated during resolveTypeDecls() will not see them
            new QvtLibraryCreator().registerNativeOperations();
            
            PrintStream out = System.out;
            System.setOut(new PrintStream(new OutputStream() { @Override
			public void write(int b) {} }));
            try {
                QvtOperationalParser parser = new QvtOperationalParser();
                module = parser.analyze(mma, this, env, options);
                if (options.isGenerateCompletionData()) {
					// Remark: added just for the support of basic metamodel navigability from the QVT editor
					//    - Consider using EMF Adapters instead of various maps to keep such additional info
					syntaxToEnvironmentMap.put(mma.getModuleCS(), parser.getEnvironment());
                }
                
                allMessages.addAll(parser.getWarningsList());
                allMessages.addAll(parser.getErrorsList());
                
            } finally {
                System.setOut(out);
            }
        }
        
        if (module == null) {
            module = createModule(mma.getModuleCS(), options, env, mma);
            module.setName(""); //$NON-NLS-1$
        }
        
        CompiledModule compModule = new CompiledModule(module, mma, mma.getSource(), allMessages);

        result = new QvtCompilationResult(compModule,
        		new CompletionData(syntaxToSemanticMap, syntaxToEnvironmentMap, semanticToEnvironmentMap));
        
        myCompilationResults.put(mma, result);
        
        return result;
    }    
    
    private ParsedModuleCS getImportedModule(final CFile source, final String qualifiedName) {
    	CFile importSource = myImportResolver.resolveImport(qualifiedName);
    	if(importSource == null) {
    		return null;
    	}
        try {
            ParsedModuleCS parsed = parse(importSource);
            return parsed;
        } catch(IOException e) {
        	Logger.getLogger().log(Logger.SEVERE, "Failed to get module for " + source, e); //$NON-NLS-1$
            return null;
        }
    }
    
    public String getExpectedPackageName(CFolder folder) {
        String packageName = myImportResolver.getPackageName(folder);
        return packageName;
    }

    public boolean isClass(EClassifier oclType) {
		return oclType instanceof EClass;
	}
		
    public Module getModule(MappingModuleCS mmas) {
        return mySyntaxToSemanticMap.get(mmas);
    }
    
    public Module createModule(MappingModuleCS mmas, QvtCompilerOptions options, 
    		EcoreEnvironment env, ParsedModuleCS parsedModuleCS) {
		Module module = ExpressionsFactory.eINSTANCE.createModule();
        mySyntaxToSemanticMap.put(mmas, module);

        // AST binding
        if(options.isGenerateCompletionData()) {
        	ASTBindingHelper.createModuleBinding(mmas, module, env, parsedModuleCS.getSource());
        }
		//		
        
        return module;
    } 
    
    
    private class ImportCompiler {
    	private final Map<ParsedModuleCS, List<ParsedModuleCS>> myRemovedCycles;    	
    	private final QvtCompilerOptions myCompilerOptions;    	
    	private final List<ParsedModuleCS> myProcessedImporters = new ArrayList<ParsedModuleCS>();
    	
		ImportCompiler(Map<ParsedModuleCS, List<ParsedModuleCS>> removedCycles, QvtCompilerOptions options) {
			this.myRemovedCycles = removedCycles;
			this.myCompilerOptions = options;
		}
    	
	    void compileImports(final CompiledModule compiledModule, final ParsedModuleCS importingModule) {
	    	if (myProcessedImporters.contains(importingModule)) {
	    		return;
	    	}
	    	myProcessedImporters.add(importingModule);
	    	
	    	Collection<ParsedModuleCS> importedModules = importingModule.getParsedImports();
	    	List<ParsedModuleCS> removedImports = myRemovedCycles.containsKey(importingModule) ?
	    			myRemovedCycles.get(importingModule) : Collections.<ParsedModuleCS>emptyList();    	
	    	if(myRemovedCycles.containsKey(importingModule)) {
	    		importedModules = new ArrayList<ParsedModuleCS>(importedModules.size() + removedImports.size());
	    		importedModules.addAll(importingModule.getParsedImports());
	    		importedModules.addAll(removedImports);
	    	}
	
	    	for (ParsedModuleCS importedModule : importedModules) {	
	    		String importedModuleId = importedModule.getStringName();
	    		CompiledModule analyzedModule = null;
	        	if (!importingModule.getStringName().equals(importedModuleId)) {
	            	analyzedModule = analyse(importedModule, myCompilerOptions).getModule();
	            	if (analyzedModule.getErrors().length > 0 && importedModule != importingModule) { 
		        		// find moduleImport syntax element
		        		ImportCS targetImportCS = null;
		        		for (ImportCS importCS : importingModule.getModuleCS().getImports()) {
		        			if (importedModuleId.equals(QvtOperationalParserUtil.getStringRepresentation(importCS.getPathNameCS(), "."))) { //$NON-NLS-1$
		        				targetImportCS = importCS;
		        				break;
		        			}
						}
		        		if (targetImportCS != null) {
		        			analyse(importingModule, myCompilerOptions).getModule().addMessage(
		        				new QvtMessage(NLS.bind(CompilerMessages.importHasCompilationError, importedModuleId), targetImportCS));
		        		}
	            	}
		        	compiledModule.getCompiledImports().add(analyzedModule);
	        	}
	        	
	        	if (!removedImports.contains(importedModule)) {
	        		compileImports(analyzedModule != null ? analyzedModule : compiledModule, importedModule);
	        	}
	    	}
	    }
    }

    
    private final Map<MappingModuleCS, Module> mySyntaxToSemanticMap;
    
    private final Map<CFile, ParsedModuleCS> mySyntaxModules;
    private final Map<ParsedModuleCS, QvtCompilationResult> myCompilationResults;
    
	private final IImportResolver myImportResolver;
	private final IMetamodelRegistryProvider metamodelRegistryProvider;
	private final ResourceSet resourceSet;    
}
