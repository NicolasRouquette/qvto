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

import java.io.File;
import java.io.IOException;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

public class IOResource implements CResource {
	public IOResource(File file) {
		myFile = file.getAbsoluteFile();
	}
	
	public IFileStore getFileStore() throws IOException {
		try {
			return EFS.getStore(myFile.toURI());
		} catch (CoreException e) {
			IOException io = new IOException();
			io.initCause(e);
			throw io;
		}
	}
	
	public String getName() {
		return myFile.getName();
	}
    
    public String getExtension() {
        return getExtension(getName());
    }
    
    public static String getExtension(String name) {
        int lastDot = name.lastIndexOf('.');
        if(lastDot == -1 || lastDot == name.length()-1) {
            return ""; //$NON-NLS-1$
        }
        else {
            return name.substring(lastDot+1);
        }
    }

	public String getFullPath() {
		return myFile.getAbsolutePath();
	}
	
	public boolean exists() {
		return myFile.exists();
	}
	
	public CFolder getParent() {
		return new IOFolder(myFile.getParentFile());
	}
	
	@Override
	public boolean equals(Object other) {
		return other instanceof IOResource && 
			((IOResource)other).myFile.equals(myFile);
	}
	
	@Override
	public int hashCode() {
		return myFile.hashCode(); 
	}
	
	@Override
	public String toString() {
		return String.valueOf(myFile);
	}

    public void delete() throws IOException {
        FileUtil.delete(myFile);
    }

    public void refresh() {
    }
    
    public static String getWorkspaceCharset() {
		return ResourcesPlugin.getEncoding();
    }
    
	protected final File myFile;
}
