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
package org.eclipse.m2m.qvt.oml.editor.ui.hyperlinks;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.ocl.internal.cst.CSTNode;
import org.eclipse.ocl.internal.cst.SimpleNameCS;
import org.eclipse.ocl.utilities.ASTNode;


/**
 * @author vrepeshko
 */
public class HyperlinkUtil {

	public static boolean isValidElement(CSTNode element) {
		if (element == null) {
			return false;
		}
		return element.getStartOffset() >= 0 && element.getEndOffset() >= element.getStartOffset();
	}
	
	public static boolean isValidElement(ASTNode element) {
		if (element == null) {
			return false;
		}
		return element.getStartPosition() >= 0 && element.getEndPosition() >= element.getStartPosition();
	}
	
	public static IRegion createRegion(CSTNode element) {
		return new Region(element.getStartOffset(), element.getEndOffset() - element.getStartOffset() + 1);
	}
}
