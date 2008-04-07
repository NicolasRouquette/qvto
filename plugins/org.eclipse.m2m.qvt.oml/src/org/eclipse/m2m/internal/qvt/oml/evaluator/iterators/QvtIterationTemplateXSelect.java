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
package org.eclipse.m2m.internal.qvt.oml.evaluator.iterators;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;

/**
 * @author aigdalov
 * Created on Jan 31, 2008
 */
public class QvtIterationTemplateXSelect<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
extends QvtIterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> {
    private QvtIterationTemplateXSelect(EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> v) {
        super(v);
    }

    public static<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
    QvtIterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> getInstance(
            EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> v) {
        return new QvtIterationTemplateXSelect<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>(v);
    }

    @Override
    protected Object evaluateResult(List<Variable<C, PM>> iterators, String resultName, OCLExpression<EClassifier> condition, Object body, boolean isOne) {
        // should be exactly one iterator
        String iterName = iterators.get(0).getName();
        Object currObj = getEvalEnvironment().getValueOf(iterName);
        
        if (currObj == null) {
            return getEvalEnvironment().getValueOf(resultName);
        }
        Boolean conditionOk = isConditionOk(condition, currObj);
        if (conditionOk == null) {
            return getOclInvalid();
        }
        if (!conditionOk) {
            return getEvalEnvironment().getValueOf(resultName);
        }
        return returnCheckedEvaluationResult(currObj, isOne, resultName);
    }
}