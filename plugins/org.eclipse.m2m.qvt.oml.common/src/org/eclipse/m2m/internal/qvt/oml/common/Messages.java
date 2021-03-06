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
package org.eclipse.m2m.internal.qvt.oml.common;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.common.messages"; //$NON-NLS-1$

    private Messages() {
    }

    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }
    
    public static String FileUtil_CannotDelete;
    public static String ShallowProcess_Label;
    public static String ShallowProcess_InvalidState;
    
    public static String TransformationRegistry_MissingMetamodelAttr;
    public static String TransformationRegistry_MissingMetaclassAttr;
    public static String TransformationRegistry_UnknownMetamodel;
    public static String TransformationRegistry_NoElements;
    
    public static String InvalidFilePath;    
}
