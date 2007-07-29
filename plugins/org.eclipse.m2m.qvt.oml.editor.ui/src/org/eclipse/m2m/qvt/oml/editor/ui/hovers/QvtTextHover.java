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
package org.eclipse.m2m.qvt.oml.editor.ui.hovers;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.m2m.qvt.oml.compiler.CompiledModule;
import org.eclipse.m2m.qvt.oml.editor.ui.CSTHelper;
import org.eclipse.m2m.qvt.oml.editor.ui.QvtDocumentProvider;
import org.eclipse.m2m.qvt.oml.ocl.completion.CompletionData;
import org.eclipse.ocl.internal.cst.CSTNode;


public class QvtTextHover implements ITextHover {
	
    private final QvtDocumentProvider myDocumentProvider;
    private final IElementInfoProvider[] myElementInfoProviders;	
	
    public QvtTextHover(final QvtDocumentProvider documentProvider) {
        myDocumentProvider = documentProvider;
        myElementInfoProviders = new IElementInfoProvider[] {
        		new OperationCallInfoProvider(),
        		new PropertyCallInfoProvider(),
        		new VariableExpressionInfoProvider(),
        		new PatternPropertyExpressionInfoProvider()
        };
    }

    public IRegion getHoverRegion(final ITextViewer textViewer, final int offset) {
        return new Region(offset, 0);
    }
        
    public String getHoverInfo(final ITextViewer textViewer, final IRegion hoverRegion) {
        if (checkCompiledModule(myDocumentProvider.getCompiledModule()) && 
        	textViewer != null && textViewer.getDocument() != null) {
	        
	        Annotation annotation = getAnnotation(textViewer, hoverRegion.getOffset());
        	if (annotation != null) {
        		return annotation.getText();
        	}
        	
        	CSTNode rootCS = myDocumentProvider.getCompiledModule().getSyntaxElement().getModuleCS();
        	List<CSTNode> elements = CSTHelper.selectTargetedElements(rootCS, hoverRegion);
        	if(!elements.isEmpty()) {
        		return getElementsInfo(elements, textViewer);
        	}
        }
       
        return ""; //$NON-NLS-1$
    }
    
    public Annotation getAnnotation(final ITextViewer textViewer, final int offset) {
    	if (textViewer instanceof ISourceViewer) {
 			final IAnnotationModel annotationModel = ((ISourceViewer) textViewer).getAnnotationModel();
 			if (annotationModel == null) {
 				return null;
 			}
 			ArrayList<Annotation> annotations = new ArrayList<Annotation>();
 			for (Iterator<?> iter = annotationModel.getAnnotationIterator(); iter.hasNext();) {
 				Annotation annotation = (Annotation)iter.next();
 				if (annotation.isPersistent() && !annotation.isMarkedDeleted()) {
	 				Position position = annotationModel.getPosition(annotation);
	 				if (position != null && position.includes(offset)) {
	 					annotations.add(annotation);
	 				}
 				}
 			}
 			if (!annotations.isEmpty()) { 
	 			Collections.sort(annotations, new Comparator<Annotation>() {
					public int compare(final Annotation o1, final Annotation o2) {
						Position p1 = annotationModel.getPosition(o1);
						Position p2 = annotationModel.getPosition(o2);
						return p1.getLength() - p2.getLength();
					}
	 			});
	 			return (Annotation) annotations.get(0);
 			}
 		}
    	return null;
    }

    
    private String getElementsInfo(final List<CSTNode> elements, ITextViewer textViewer) {
    	for (CSTNode nextElement : elements) {
        	for (int i = 0; i < myElementInfoProviders.length; i++) {
    			IElementInfoProvider provider = myElementInfoProviders[i];
    			try {
    				String info = provider.getElementInfo(nextElement, textViewer);
    				if (info != null && info.length() > 0) {
    					return info;
    				}
    			} catch (NullPointerException e) {
    				// ignore
    			}
    		}    		
		}
    	return ""; //$NON-NLS-1$
    }
    
    private boolean checkCompiledModule(final CompiledModule compiledModule) {
        return compiledModule != null && compiledModule.getSyntaxElement() != null;
    }    
}
