/**
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 * 
 * 
 *
 * $Id: ImportCS.java,v 1.1 2008/03/12 11:48:03 sboyko Exp $
 */
package org.eclipse.m2m.qvt.oml.internal.cst;

import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.PathNameCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.ImportCS#getPathNameCS <em>Path Name CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage#getImportCS()
 * @model abstract="true"
 * @generated
 */
public interface ImportCS extends CSTNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Path Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path Name CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path Name CS</em>' containment reference.
	 * @see #setPathNameCS(PathNameCS)
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage#getImportCS_PathNameCS()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getPathNameCS();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.internal.cst.ImportCS#getPathNameCS <em>Path Name CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path Name CS</em>' containment reference.
	 * @see #getPathNameCS()
	 * @generated
	 */
	void setPathNameCS(PathNameCS value);

} // ImportCS