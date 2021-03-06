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
package org.eclipse.m2m.internal.qvt.oml.common.io;

import java.io.IOException;

import org.eclipse.core.filesystem.IFileStore;

public interface CResource {
	IFileStore getFileStore() throws IOException;
	String getName();
    String getExtension();
	String getFullPath();
	boolean exists();
	CFolder getParent();
	void delete() throws IOException;
    void refresh() throws IOException;
}
