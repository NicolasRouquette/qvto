/*******************************************************************************
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.collectors;

import lpg.lpgjavaruntime.IToken;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtOpLPGParsersym;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionData;

/**
 * @author Aleksandr Igdalov
 * Created on Jul 4, 2007
 */

public abstract class AbstractMetamodelCollector extends AbstractCollector {
    @Override
    protected boolean isApplicableInternal(QvtCompletionData data) {
		IToken leftToken = data.getLeftToken();
		return ((leftToken.getKind() == QvtOpLPGParsersym.TK_uses) || 
				(leftToken.getKind() == QvtOpLPGParsersym.TK_metamodel));
	}


	protected static final String getProposalString(QvtCompletionData data, EPackage pack) {
		String nsUriLiteral = '\'' + pack.getNsURI() + '\'';
		String proposalString;
		if ((data.getLeftToken().getKind() == QvtOpLPGParsersym.TK_uses)
				&& (pack.getName() != null)
				&& (pack.getName().trim().length() != 0)) {
			proposalString = pack.getName() + '(' + nsUriLiteral + ")"; //$NON-NLS-1$
		} else {
			proposalString = nsUriLiteral;
		}
		return proposalString;
	}
}