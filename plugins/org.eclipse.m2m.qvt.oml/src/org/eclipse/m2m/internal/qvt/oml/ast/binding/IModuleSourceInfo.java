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
package org.eclipse.m2m.internal.qvt.oml.ast.binding;

import org.eclipse.m2m.internal.qvt.oml.common.util.LineNumberProvider;

/**
 * Interface allows adapting of a compiled Module to its source information.
 */
public interface IModuleSourceInfo {
	/**
	 * Gets the name of the module source file.
	 * @return the name string
	 */
	String getFileName();
	
	/**
	 * Gets the contents the module source file
	 */
	String getContents();
	
	/**
	 * Gets the line number provider operating on the module source contents.
	 * @return the provider instance
	 */
	LineNumberProvider getLineNumberProvider();
}