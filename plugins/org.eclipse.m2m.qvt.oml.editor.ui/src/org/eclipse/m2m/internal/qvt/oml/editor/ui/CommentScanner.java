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
package org.eclipse.m2m.internal.qvt.oml.editor.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.rules.BufferedRuleBasedScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWhitespaceDetector;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.colorer.IQVTColors;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.colorer.QVTColorManager;

class CommentScanner extends BufferedRuleBasedScanner {

	private static class DefaultKeywordDetector implements IWordDetector {
		public boolean isWordPart(char character) {
			return Character.isJavaIdentifierPart(character);
		}

		public boolean isWordStart(char character) {
			return Character.isJavaIdentifierStart(character);
		}
	}

	private static class WhitespaceDetector implements IWhitespaceDetector {
		public boolean isWhitespace(char character) {
			return Character.isWhitespace(character);
		}
	}	

	public CommentScanner(QVTColorManager manager, String colorId) {
		IToken keyWord = manager.getColor(IQVTColors.TASK_TAG).createToken();
		IToken defaultToken = manager.getColor(colorId).createToken();

		List<IRule> rules = new ArrayList<IRule>();
		rules.add(new WhitespaceRule(new WhitespaceDetector()));

		WordRule wordRule = new WordRule(new DefaultKeywordDetector(), defaultToken);
		addKeywords(wordRule, keyWord);
		rules.add(wordRule);

		setRules(rules.toArray(new IRule[rules.size()]));
		setDefaultReturnToken(defaultToken);
	}
	
	private void addKeywords(WordRule wordRule, IToken keyWord) {
		wordRule.addWord("TODO", keyWord); //$NON-NLS-1$
		wordRule.addWord("FIXME", keyWord); // //$NON-NLS-1$
	}
}
