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
package org.eclipse.m2m.internal.qvt.oml.evaluator;

import org.eclipse.m2m.internal.qvt.oml.expressions.AssignExp;

/**
 * This interface is intended to be used to recieve notifications on deferred assignments
 */
public interface DeferredAssignmentListener {

	/**
	 * Notification call after the given assignment is executed at deferred
	 * time.
	 * 
	 * @param assignExp
	 *            the target assignment
	 * @param assignLeftValue
	 *            the late evaluated assignemnt left value
	 */
    void notifyAfterDeferredAssign(final AssignExp assignExp, Object lateLeftValue);
}