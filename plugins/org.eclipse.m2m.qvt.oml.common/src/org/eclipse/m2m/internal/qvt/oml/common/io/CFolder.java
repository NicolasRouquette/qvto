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

public interface CFolder extends CResource {
	CFile getFile(String name);
	void create() throws IOException;
	CFolder getFolder(String name);
	CResource[] members() throws IOException;
	String getDefaultCharset() throws IOException;
}
