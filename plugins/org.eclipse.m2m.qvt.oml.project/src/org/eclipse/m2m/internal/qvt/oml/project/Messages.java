/*******************************************************************************
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.project;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	
    private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.project.messages"; //$NON-NLS-1$		
	
    private Messages() {
    }

    public static String InvalidSourceContainer;
    

    static {
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }
}
