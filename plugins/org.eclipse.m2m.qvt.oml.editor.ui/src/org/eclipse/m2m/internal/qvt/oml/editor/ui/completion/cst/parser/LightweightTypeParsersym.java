/**
* <copyright>
*
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
* </copyright>
*
* $Id: LightweightTypeParsersym.java,v 1.1 2008/04/06 08:59:39 sboyko Exp $
*/
/**
* <copyright>
*
* Copyright (c) 2006, 2007 Borland Inc.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   Borland - Initial API and implementation
*
* </copyright>
*
* $Id: LightweightTypeParsersym.java,v 1.1 2008/04/06 08:59:39 sboyko Exp $
*/

package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.cst.parser;

public interface LightweightTypeParsersym {
    public final static int
      TK_NUMERIC_OPERATION = 65,
      TK_STRING_LITERAL = 66,
      TK_INTEGER_LITERAL = 67,
      TK_REAL_LITERAL = 68,
      TK_PLUS = 34,
      TK_MINUS = 35,
      TK_MULTIPLY = 25,
      TK_DIVIDE = 26,
      TK_GREATER = 20,
      TK_LESS = 21,
      TK_EQUAL = 5,
      TK_GREATER_EQUAL = 22,
      TK_LESS_EQUAL = 23,
      TK_NOT_EQUAL = 24,
      TK_LPAREN = 1,
      TK_RPAREN = 3,
      TK_LBRACE = 84,
      TK_RBRACE = 87,
      TK_LBRACKET = 92,
      TK_RBRACKET = 98,
      TK_ARROW = 107,
      TK_BAR = 88,
      TK_COMMA = 85,
      TK_COLON = 89,
      TK_COLONCOLON = 90,
      TK_SEMICOLON = 86,
      TK_DOT = 108,
      TK_DOTDOT = 109,
      TK_ATPRE = 99,
      TK_CARET = 110,
      TK_CARETCARET = 111,
      TK_QUESTIONMARK = 100,
      TK_QUOTE_STRING_LITERAL = 126,
      TK_ADD_ASSIGN = 102,
      TK_RESET_ASSIGN = 91,
      TK_AT_SIGN = 115,
      TK_EXCLAMATION_MARK = 101,
      TK_NOT_EQUAL_EXEQ = 94,
      TK_self = 27,
      TK_inv = 127,
      TK_pre = 128,
      TK_post = 129,
      TK_endpackage = 130,
      TK_def = 131,
      TK_if = 69,
      TK_then = 112,
      TK_else = 103,
      TK_endif = 104,
      TK_and = 29,
      TK_or = 30,
      TK_xor = 31,
      TK_not = 53,
      TK_implies = 113,
      TK_let = 75,
      TK_in = 105,
      TK_true = 70,
      TK_false = 71,
      TK_body = 36,
      TK_derive = 37,
      TK_init = 38,
      TK_null = 39,
      TK_attr = 132,
      TK_oper = 133,
      TK_Set = 15,
      TK_Bag = 16,
      TK_Sequence = 17,
      TK_Collection = 18,
      TK_OrderedSet = 19,
      TK_iterate = 40,
      TK_forAll = 41,
      TK_exists = 42,
      TK_isUnique = 43,
      TK_any = 44,
      TK_one = 45,
      TK_collect = 46,
      TK_select = 47,
      TK_reject = 48,
      TK_collectNested = 49,
      TK_sortedBy = 50,
      TK_closure = 51,
      TK_oclIsKindOf = 54,
      TK_oclIsTypeOf = 55,
      TK_oclAsType = 56,
      TK_oclIsNew = 57,
      TK_oclIsUndefined = 58,
      TK_oclIsInvalid = 59,
      TK_oclIsInState = 60,
      TK_allInstances = 52,
      TK_String = 6,
      TK_Integer = 7,
      TK_UnlimitedNatural = 8,
      TK_Real = 9,
      TK_Boolean = 10,
      TK_Tuple = 32,
      TK_OclAny = 11,
      TK_OclVoid = 12,
      TK_Invalid = 13,
      TK_OclMessage = 14,
      TK_OclInvalid = 72,
      TK_end = 134,
      TK_while = 73,
      TK_out = 135,
      TK_object = 74,
      TK_transformation = 136,
      TK_import = 137,
      TK_library = 138,
      TK_metamodel = 139,
      TK_mapping = 140,
      TK_query = 141,
      TK_helper = 142,
      TK_inout = 143,
      TK_when = 116,
      TK_var = 95,
      TK_configuration = 144,
      TK_property = 145,
      TK_population = 146,
      TK_map = 61,
      TK_xmap = 62,
      TK_late = 63,
      TK_log = 93,
      TK_assert = 96,
      TK_with = 117,
      TK_resolve = 76,
      TK_resolveone = 77,
      TK_resolveIn = 78,
      TK_resolveoneIn = 79,
      TK_invresolve = 80,
      TK_invresolveone = 81,
      TK_invresolveIn = 82,
      TK_invresolveoneIn = 83,
      TK_modeltype = 147,
      TK_uses = 148,
      TK_where = 149,
      TK_refines = 150,
      TK_enforcing = 151,
      TK_access = 152,
      TK_extends = 153,
      TK_blackbox = 154,
      TK_abstract = 155,
      TK_static = 156,
      TK_result = 28,
      TK_main = 118,
      TK_this = 33,
      TK_switch = 64,
      TK_case = 114,
      TK_xselect = 119,
      TK_xcollect = 120,
      TK_selectOne = 121,
      TK_collectOne = 122,
      TK_collectselect = 123,
      TK_collectselectOne = 124,
      TK_return = 97,
      TK_rename = 157,
      TK_inherits = 158,
      TK_merges = 159,
      TK_disjuncts = 160,
      TK_IDENTIFIER = 2,
      TK_ERROR_TOKEN = 4,
      TK_INTEGER_RANGE_START = 106,
      TK_EOF_TOKEN = 125;

      public final static String orderedTerminalSymbols[] = {
                 "",
                 "LPAREN",
                 "IDENTIFIER",
                 "RPAREN",
                 "ERROR_TOKEN",
                 "EQUAL",
                 "String",
                 "Integer",
                 "UnlimitedNatural",
                 "Real",
                 "Boolean",
                 "OclAny",
                 "OclVoid",
                 "Invalid",
                 "OclMessage",
                 "Set",
                 "Bag",
                 "Sequence",
                 "Collection",
                 "OrderedSet",
                 "GREATER",
                 "LESS",
                 "GREATER_EQUAL",
                 "LESS_EQUAL",
                 "NOT_EQUAL",
                 "MULTIPLY",
                 "DIVIDE",
                 "self",
                 "result",
                 "and",
                 "or",
                 "xor",
                 "Tuple",
                 "this",
                 "PLUS",
                 "MINUS",
                 "body",
                 "derive",
                 "init",
                 "null",
                 "iterate",
                 "forAll",
                 "exists",
                 "isUnique",
                 "any",
                 "one",
                 "collect",
                 "select",
                 "reject",
                 "collectNested",
                 "sortedBy",
                 "closure",
                 "allInstances",
                 "not",
                 "oclIsKindOf",
                 "oclIsTypeOf",
                 "oclAsType",
                 "oclIsNew",
                 "oclIsUndefined",
                 "oclIsInvalid",
                 "oclIsInState",
                 "map",
                 "xmap",
                 "late",
                 "switch",
                 "NUMERIC_OPERATION",
                 "STRING_LITERAL",
                 "INTEGER_LITERAL",
                 "REAL_LITERAL",
                 "if",
                 "true",
                 "false",
                 "OclInvalid",
                 "while",
                 "object",
                 "let",
                 "resolve",
                 "resolveone",
                 "resolveIn",
                 "resolveoneIn",
                 "invresolve",
                 "invresolveone",
                 "invresolveIn",
                 "invresolveoneIn",
                 "LBRACE",
                 "COMMA",
                 "SEMICOLON",
                 "RBRACE",
                 "BAR",
                 "COLON",
                 "COLONCOLON",
                 "RESET_ASSIGN",
                 "LBRACKET",
                 "log",
                 "NOT_EQUAL_EXEQ",
                 "var",
                 "assert",
                 "return",
                 "RBRACKET",
                 "ATPRE",
                 "QUESTIONMARK",
                 "EXCLAMATION_MARK",
                 "ADD_ASSIGN",
                 "else",
                 "endif",
                 "in",
                 "INTEGER_RANGE_START",
                 "ARROW",
                 "DOT",
                 "DOTDOT",
                 "CARET",
                 "CARETCARET",
                 "then",
                 "implies",
                 "case",
                 "AT_SIGN",
                 "when",
                 "with",
                 "main",
                 "xselect",
                 "xcollect",
                 "selectOne",
                 "collectOne",
                 "collectselect",
                 "collectselectOne",
                 "EOF_TOKEN",
                 "QUOTE_STRING_LITERAL",
                 "inv",
                 "pre",
                 "post",
                 "endpackage",
                 "def",
                 "attr",
                 "oper",
                 "end",
                 "out",
                 "transformation",
                 "import",
                 "library",
                 "metamodel",
                 "mapping",
                 "query",
                 "helper",
                 "inout",
                 "configuration",
                 "property",
                 "population",
                 "modeltype",
                 "uses",
                 "where",
                 "refines",
                 "enforcing",
                 "access",
                 "extends",
                 "blackbox",
                 "abstract",
                 "static",
                 "rename",
                 "inherits",
                 "merges",
                 "disjuncts"
             };

    public final static boolean isValidForParser = true;
}