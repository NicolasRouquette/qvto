/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.evaluator;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.m2m.internal.qvt.oml.ast.env.InternalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.ModelExtentContents;
import org.eclipse.m2m.internal.qvt.oml.ast.env.ModelParameterExtent;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtEvaluationResult;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.internal.qvt.oml.library.Context;
import org.eclipse.m2m.internal.qvt.oml.stdlib.DictionaryImpl;
import org.eclipse.m2m.internal.qvt.oml.stdlib.MutableListImpl;
import org.eclipse.m2m.internal.qvt.oml.stdlib.model.ExceptionInstance;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.DictionaryType;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ListType;
import org.eclipse.m2m.qvt.oml.util.Dictionary;
import org.eclipse.m2m.qvt.oml.util.IContext;
import org.eclipse.m2m.qvt.oml.util.ISessionData;
import org.eclipse.m2m.qvt.oml.util.MutableList;
import org.eclipse.m2m.qvt.oml.util.Utils;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.util.CollectionUtil;

/**
 * @author dvorak
 */
public class EvaluationUtil {
	
	private EvaluationUtil() {
		super();
	}

	/**
	 * - Creates list of output resources (model extents) for each 'inout' and 'out' parameters of
	 *   transformation. For non-changed 'inout' model parameter corresponding resource is empty.
	 * @return ordered list of model extents
	 */
	public static QvtEvaluationResult createEvaluationResult(QvtOperationalEvaluationEnv mainEvalEnv) {
		TransformationInstance transfInstance = (TransformationInstance)mainEvalEnv.getValueOf(QvtOperationalEnv.THIS);		
		
		List<ModelExtentContents> extents = new ArrayList<ModelExtentContents>();		
		OperationalTransformation transformation = transfInstance.getTransformation();
		
		for(ModelParameter modelParam : transformation.getModelParameter()) {
			ModelInstance model = transfInstance.getModel(modelParam);
			ModelExtentContents contents = model.getExtent().getContents();
			if (modelParam.getKind() != DirectionKind.IN 
					&& modelParam.getEAnnotation(QvtOperationalParserUtil.QVT_AUTOGEN_MODELPARAM_EXPRESSION_URI) == null) {
	        	extents.add(contents);
			}			
		}
		
        List<Object> outParamValues = makeOutParamValues(mainEvalEnv);
		
		ModelParameterExtent unboundExtent = mainEvalEnv.getAdapter(InternalEvaluationEnv.class).getUnboundExtent();
		return new QvtEvaluationResult(extents, unboundExtent.getRootObjects(), outParamValues);
	}
	
	private static List<Object> makeOutParamValues(QvtOperationalEvaluationEnv mainEvalEnv) {
		ImperativeOperation entryPoint = (ImperativeOperation) mainEvalEnv.getOperation();		
		List<Object> outParamValues = new ArrayList<Object>();
		
		for (EParameter param : mainEvalEnv.getOperation().getEParameters()) {
			MappingParameter mappingParam  = (MappingParameter) param;
// originally we took all non-IN?? why?			
			if (mappingParam.getKind() != DirectionKind.OUT) {
				continue;
			}
			Object valueOf = mainEvalEnv.getValueOf(mappingParam.getName());
			if (valueOf != null) {
				outParamValues.add(valueOf);
			}
		}
		for (VarParameter param : entryPoint.getResult()) {
			MappingParameter mappingParam  = (MappingParameter) param;
			if (mappingParam.getKind() == DirectionKind.IN) {
				continue;
			}
			
			Object valueOf = mainEvalEnv.getValueOf(mappingParam.getName());
			if (valueOf != null) {
				outParamValues.add(valueOf);
			}
		}
		return outParamValues;
	}

    static void mapOperationOutAndResultParams(QvtOperationalEvaluationEnv sourceEnv, QvtOperationalEvaluationEnv targetEnv) {
    	ImperativeOperation sourceOper = (ImperativeOperation)sourceEnv.getOperation();
    	ImperativeOperation targetOper = (ImperativeOperation)targetEnv.getOperation();
    	EList<? extends EParameter> sourceParams = sourceOper.getResult();
    	EList<? extends EParameter> targetParams = targetOper.getResult();
    	
    	if(sourceParams.size() != targetParams.size()) {
    		throw new IllegalArgumentException("Source/Target environment operations have incompatible signatures"); //$NON-NLS-1$
    	}

    	for (int i = 0; i < sourceParams.size(); i++) {
    		EParameter sourceParam = sourceParams.get(i);
    		EParameter targetParam = targetParams.get(i);
    		targetEnv.copyVariableValueFrom(sourceEnv, sourceParam.getName(), targetParam.getName());
		}
    	
    	if(sourceParams.size() > 1) {
    		// copy result variable explicitly as in case of many result parameters, there is no 'name=result' parameter 
    		targetEnv.copyVariableValueFrom(sourceEnv, Environment.RESULT_VARIABLE_NAME, Environment.RESULT_VARIABLE_NAME);
    	}

    	sourceParams = sourceOper.getEParameters();
    	targetParams = targetOper.getEParameters();
    	if(sourceParams.size() != targetParams.size()) {
    		throw new IllegalArgumentException("Source/Target environment operations have incompatible signatures"); //$NON-NLS-1$
    	}
    	
    	for (int i = 0; i < sourceParams.size(); i++) {
    		VarParameter sourceParam = (VarParameter) sourceParams.get(i);
    		if(sourceParam.getKind() == DirectionKind.OUT) {
    			EParameter targetParam = targetParams.get(i);
    			targetEnv.copyVariableValueFrom(sourceEnv, sourceParam.getName(), targetParam.getName());    			
    		}
		}
    }
    
    static Object formatLoggedElement(Object element) {
    	if(element instanceof ExceptionInstance) {
    		ExceptionInstance exception = (ExceptionInstance) element;    		
    		
    		StringWriter contents = new StringWriter();
			PrintWriter pw = new PrintWriter(contents);
			pw.println(exception);
			QvtRuntimeException.printQvtStackTrace(pw, exception.getStackElements());
			
			return contents.toString(); 
    	}
    	
    	return element;
    }
    
    static void checkCurrentStackDepth(QvtOperationalEvaluationEnv env) throws QvtStackOverFlowError {
		int depth = env.getDepth();
		if(depth >= QvtOperationalEvaluationEnv.MAX_STACK_DEPTH) {
			InternalEvaluationEnv iternEnv = env.getAdapter(InternalEvaluationEnv.class);
			iternEnv.throwQVTException(new QvtStackOverFlowError("Stack depth: " + depth)); //$NON-NLS-1$
		}    	
    }
    
	static List<ModelInstance> getTransfromationModelArguments(QvtOperationalEvaluationEnv rootEnvironment, OperationalTransformation transformation) throws IllegalArgumentException {
		List<Object> args = rootEnvironment.getOperationArgs();
		List<ModelInstance> transformArgs = new ArrayList<ModelInstance>(args.size());
		for (Object nextArg : args) {
			if(nextArg instanceof ModelInstance) {
				transformArgs.add((ModelInstance) nextArg);
			} else {
				throw new IllegalArgumentException(
					"transformation requires arguments of ModelInstance type"); //$NON-NLS-1$
			}
		}
		
		return transformArgs;
	}
	
	// TODO - this is a temp solution, consider this reference going into internal environment 
	static final ISessionData.Entry<QvtOperationalEvaluationEnv> AGGREGATING_ROOT_ENV = new ISessionData.SimpleEntry<QvtOperationalEvaluationEnv>(); 
	
	static Context createAggregatedContext(QvtOperationalEvaluationEnv evalEnv) {
		final IContext parentContext = evalEnv.getContext();
		
		Context nestedContext = new Context() {
			@Override
			protected ISessionData createSessionData() {
				return copySessionData();
			}
		};

		nestedContext.setLog(parentContext.getLog());
		nestedContext.setMonitor(parentContext.getMonitor());
		nestedContext.getSessionData().setValue(AGGREGATING_ROOT_ENV, evalEnv);

		return nestedContext;
	}
		
	public static QvtOperationalEvaluationEnv getAggregatingContext(QvtOperationalEvaluationEnv evalEnv) {
		return evalEnv.getContext().getSessionData().getValue(AGGREGATING_ROOT_ENV);
	}

	static ImperativeOperation getOverridingOperation(QvtOperationalEvaluationEnv evalEnv, ImperativeOperation operation) {
        InternalEvaluationEnv internEvalEnv = evalEnv.getAdapter(InternalEvaluationEnv.class);
        assert internEvalEnv != null : "must adapt to internal env"; //$NON-NLS-1$
        
        ModuleInstance currentInternModule = internEvalEnv.getCurrentModule();
        // check if executed from transformation context (main() stack frame exists)
        if(currentInternModule != null) {
        	return currentInternModule.getAdapter(ModuleInstance.Internal.class).getOverridingOperation(operation);
        }
        
        return null;
	}
	
    public static <E> Collection<E> createNewCollectionOfSameKind(Collection<E> c) {
    	Collection<E> result;
    	
    	if (c instanceof MutableList<?>) {
    		result = new MutableListImpl<E>();
    	} else if (c instanceof Dictionary<?, ?>) {
    		result = new DictionaryImpl<Object, E>();
    	} else {
    		result = CollectionUtil.createNewCollectionOfSameKind(c);
    	}
    	
    	return result;
    }	
    
	public static <E> Collection<E> createNewCollection(CollectionType<EClassifier, EOperation> collectionType) {
		Collection<E> result = null;
		
		if (collectionType instanceof ListType) {
			result = Utils.createList();
		}
		else if (collectionType instanceof DictionaryType) {
			result = Utils.createDictionary();
		}
		else {
			CollectionKind kind = collectionType.getKind();
			if (kind != null && kind != CollectionKind.COLLECTION_LITERAL) {
				result = CollectionUtil.createNewCollection(collectionType.getKind());
			}
		}
		
		return result;
	}	
    
}
