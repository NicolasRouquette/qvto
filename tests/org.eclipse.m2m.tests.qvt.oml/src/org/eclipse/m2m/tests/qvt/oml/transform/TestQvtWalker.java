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
package org.eclipse.m2m.tests.qvt.oml.transform;

import java.util.Arrays;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalAstWalker;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.project.QvtEngine;
import org.eclipse.ocl.utilities.Visitable;

public class TestQvtWalker extends TestTransformation {
	
	private static final String PREFIX = "walker_"; //$NON-NLS-1$
	
	public TestQvtWalker(String testName) {
		this(TestDataMapper.getTestDataByTestNameWithPrefix(PREFIX, testName));
	}
	
	public TestQvtWalker(ModelTestData data) {
        super(data);        
		setName(PREFIX + data.getName()); //$NON-NLS-1$
    }

    @Override
	public void runTest() throws Exception {
		checkTransformation(new IChecker() {
            public void check(ModelTestData data, IProject project) throws Exception {
                IFile transformation = getIFile(data.getTransformation(project));
                
                QvtEngine engine = QvtEngine.getInstance(transformation);
                CompiledUnit unit = engine.compileUnit(transformation, null);
                if(unit.getErrors().size() > 0) {
                    throw new MdaException("Failed to parse " + transformation + ": " + Arrays.asList(unit.getErrors())); //$NON-NLS-1$ //$NON-NLS-2$
                }
                
                final int[] nodeCount = new int[1];
                QvtOperationalAstWalker.NodeProcessor nodeProcessor = new QvtOperationalAstWalker.NodeProcessor() {
                    public void process(Visitable e, Visitable parent) {
                        nodeCount[0]++;
                    }
                };
                
                QvtOperationalAstWalker v = new QvtOperationalAstWalker(nodeProcessor);
                for (Module module : unit.getModules()) {
                    ((Visitable) module).accept(v);					
				}
                
                assertTrue("No nodes", nodeCount[0] > 0); //$NON-NLS-1$
            }
        });
	}
}
