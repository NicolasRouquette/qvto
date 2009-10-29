--/**
-- * <copyright>
-- *
-- * Copyright (c) 2006-2008 Borland Inc.
-- * All rights reserved.   This program and the accompanying materials
-- * are made available under the terms of the Eclipse Public License v1.0
-- * which accompanies this distribution, and is available at
-- * http://www.eclipse.org/legal/epl-v10.html
-- *
-- * Contributors:
-- *   Borland - Initial API and implementation
-- *
-- * </copyright>
-- *
-- * $Id: miscellaneous.g,v 1.31.4.2 2009/10/29 08:50:31 sboyko Exp $ 
-- */
--
-- The QVT Operational Parser
--
$Import
	EssentialOCL.g

$DropRules
		
	-- Dropped due to 13.2 (OCL spec) and 6.4 (QVT spec). These rules conflict with imperative iterator shorthands
	AssociationClassCallExpCS ::= notReservedSimpleNameCS '[' argumentsCS ']' isMarkedPreCSopt
	PropertyCallExpCS ::= primaryExpCS '.' pathNameCS '[' argumentsCS ']' isMarkedPreCSopt

$DropSymbols
	
$End

$Define
	-- Definition of macros used in the parser template
	--
	$prs_stream_class /.AbstractQVTParser./
	$lex_stream_class /.QvtOpLexer./

	$EMPTY_ELIST /.ourEmptyEList./

	-- copied from OCLLPGParser.g
	-- modified to include throwing exceptions
	$parserCore
	/.
		public class $action_class extends $prs_stream_class implements RuleAction$additional_interfaces {
		protected static ParseTable prs = new $prs_type();
		private BacktrackingParser dtParser;
		// (to be uncommented for use in DEBUG mode)
		//private static Map<Integer, String> ruleTexts;

		public $action_class($lex_stream_class lexer) {
			super(lexer);

			try {
				super.remapTerminalSymbols(orderedTerminalSymbols(), $prs_type.EOFT_SYMBOL);
			}
			catch(NullExportedSymbolsException e) {
				throw new RuntimeException(e.getLocalizedMessage());
			}
			catch(NullTerminalSymbolsException e) {
				throw new RuntimeException(e.getLocalizedMessage());
			}
			catch(UnimplementedTerminalsException e) {
				java.util.ArrayList<?> unimplemented_symbols = e.getSymbols();
				String error = "The Lexer will not scan the following token(s):"; //$NON-NLS-1$
				for (int i = 0; i < unimplemented_symbols.size(); i++) {
					Integer id = (Integer) unimplemented_symbols.get(i);
					error += "\t" + $sym_type.orderedTerminalSymbols[id.intValue()]; //$NON-NLS-1$			   
				}
				throw new RuntimeException(error + "\n"); //$NON-NLS-1$
			}
			catch(UndefinedEofSymbolException e) {
				throw new RuntimeException("The Lexer does not implement the Eof symbol " + //$NON-NLS-1$
					 $sym_type.orderedTerminalSymbols[$prs_type.EOFT_SYMBOL]);
			} 
		}
		 
 		@Override
		public String[] orderedTerminalSymbols() { return $sym_type.orderedTerminalSymbols; }
		@Override		
		public String getTokenKindName(int kind) { return $sym_type.orderedTerminalSymbols[kind]; }			
		public int getEOFTokenKind() { return $prs_type.EOFT_SYMBOL; }
		public PrsStream getParseStream() { return this; }

		protected $ast_type parser() throws ParserException {
			return parseTokensToCST(null, 0);
		}
			
		protected $ast_type parser(Monitor monitor) throws ParserException {
			return parseTokensToCST(monitor, 0);
		}
			
		protected $ast_type parser(int error_repair_count) throws ParserException {
			return parseTokensToCST(null, error_repair_count);
		}
			
		@Override
		public $ast_type parseTokensToCST(Monitor monitor, int error_repair_count) {
			ParseTable prsTable = new $prs_type();

			try {
				dtParser = new BacktrackingParser(monitor, this, prsTable, this);
			}
			catch (NotBacktrackParseTableException e) {
				throw new RuntimeException("****Error: Regenerate $prs_type.java with -NOBACKTRACK option"); //$NON-NLS-1$
			}
			catch (BadParseSymFileException e) {
				throw new RuntimeException("****Error: Bad Parser Symbol File -- $sym_type.java. Regenerate $prs_type.java"); //$NON-NLS-1$
			}

			try {
			    workaroundEOFErrors();
				return ($ast_type) dtParser.parse(error_repair_count);
			}
			catch (BadParseException e) {
				OnParseError(e);

				reset(e.error_token); // point to error token
				DiagnoseParser diagnoseParser = new DiagnoseParser(this, prsTable);
				diagnoseParser.diagnose(e.error_token);
			}

			return null;
		}

	    private void workaroundEOFErrors() {
    	    IToken lastT = (IToken) getTokens().get((getTokens().size() - 1));
        	int trailingEOFsAmount = 100;
        	int someHugeOffset = 100000;
        	for (int i  = 0; i < trailingEOFsAmount; i++) {
	            makeToken(lastT.getEndOffset() + i + someHugeOffset, lastT.getEndOffset() + i + someHugeOffset + 1, $sym_type.TK_EOF_TOKEN);
        	}
    	}

		protected void OnParseError(BadParseException e) {
			System.err.println(getFileName());
			java.util.ArrayList<?> tokens = getTokens();
			String result = getName(e.error_token) + " ~~ "; //$NON-NLS-1$
			for (int i = Math.max(0, e.error_token-5), n = Math.min(tokens.size(), e.error_token+5); i < n; ++i) {
				result += tokens.get(i).toString();
				result += " "; //$NON-NLS-1$
			}
			System.err.println(result);
		}
	./

	----- QVTO Debugging facility (start) -----
	$DebugMode /../

	-- (to be uncommented for use in DEBUG mode)
	--$DebugMode /.private static final boolean DEBUG = true;
	--		static {
	--			if (DEBUG) {
	--				ruleTexts = Collections.synchronizedMap(new HashMap<Integer, String>());
	--				try {
	--					InputStream inputStream = FileLocator.openStream(QvtPlugin.getDefault().getBundle(),
	--									new Path("cst/QvtOpLPGParser.l"), false); //$NON-NLS-1$
	--					BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	--					String line;
	--					while ((line = reader.readLine()) != null) {
	--						if ("Rules:".equals(line)) {
	--							reader.readLine();
	--							break;
	--						}
	--					}
	--					while ((line = reader.readLine()) != null) {
	--						if (line.trim().length() == 0) {
	--							break;
	--						}
	--						int wsIndex = line.indexOf(' ');
	--						String ruleNumberText = line.substring(0, wsIndex);
	--						Integer ruleNumber = new Integer(ruleNumberText);
	--						String ruleText = line.substring(wsIndex).trim();
	--						ruleTexts.put(ruleNumber, ruleText);
	--					}
	--				} catch (IOException e) {
	--					throw new RuntimeException(e);
	--				}
	--			}
	--		}
	--
	--./
	--
	--$BeginActions    
	--/.
	--	@SuppressWarnings("unchecked")	
        --public void ruleAction(int ruleNumber)
        --{
        --    if (DEBUG) {
        --       System.out.println("RULE[" + ruleNumber + "]:   " + ruleTexts.get(ruleNumber)); //$NON-NLS-1$
        --    }
        --    switch(ruleNumber)
        --    {./
	----- QVTO Debugging facility (end) -----

$End

$Globals
	/.	
	./
$End

$Terminals

	ADD_ASSIGN    ::= '+='
	RESET_ASSIGN  ::= ':='
	AT            ::= '@'
	EXCLAMATION_MARK ::= '!'
	NOT_EQUAL_EXEQ   ::= '!='

        class
        composes
        constructor
        datatype
        default
        derived
        do
        elif
        enum
        except
        exception
        from
        literal
        ordered
        primitive
        raise
        readonly
        references
        tag
        try
        typedef
        unlimited
        invalid
$End

$Notice
	/./**
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
 * $Id: miscellaneous.g,v 1.31.4.2 2009/10/29 08:50:31 sboyko Exp $
 */
	./
$End

$Headers
	/.
		/**
		 * 
		 * QVT Operational specific part
		 *
		 */
		$DebugMode
		
		@SuppressWarnings("unchecked")
		private static final EList ourEmptyEList = new BasicEList.UnmodifiableEList(0, new Object[0]);								
								
		
		private void diagnozeErrorToken(int token_index) {
			IToken token = getIToken(token_index);
			if (token instanceof lpg.lpgjavaruntime.ErrorToken) {
				token = ((lpg.lpgjavaruntime.ErrorToken) token).getErrorToken();
			}
			
			reportError(lpg.lpgjavaruntime.ParseErrorCodes.MISPLACED_CODE, "", token.getTokenIndex(), token.getTokenIndex(), //$NON-NLS-1$ 
					"'" + token.toString() + "'"); //$NON-NLS-1$ //$NON-NLS-2$
			reset(token.getTokenIndex()); // point to error token
			DiagnoseParser diagnoseParser = new DiagnoseParser(this, prs);
			diagnoseParser.diagnose(token.getTokenIndex());
			$setResult(null);
		}
	./
$End

$Rules
	--=== // general purpose grammar rules (start) ===--
	simpleNameCS -> notReservedSimpleNameCS
	simpleNameCS -> reservedKeywordCS

	qualifierList ::= $empty
		/.$EmptyListAction./
	qualifierList ::= qualifierList qualifier
		/.$BeginJava
					EList result = (EList) $getSym(1);
					result.add($getSym(2));
					$setResult(result);
		  $EndJava
		./		
		
	qualifier ::= blackbox
		/.$NewCase./
	qualifier ::= abstract
		/.$NewCase./
	qualifier ::= static
		/.$BeginJava
					CSTNode result = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getTokenText(dtParser.getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	colon_param_listOpt ::= $empty	 
		/.$EmptyListAction./
	colon_param_listOpt ::= ':' param_list
		/.$BeginJava
					$setResult($getSym(2));
		  $EndJava
		./

	complete_signature ::= simple_signature colon_param_listOpt
		/.$BeginJava
					SimpleSignatureCS simpleSignatureCS = (SimpleSignatureCS)$getSym(1);
					EList<ParameterDeclarationCS> resultList = (EList<ParameterDeclarationCS>)$getSym(2);
					CSTNode result = createCompleteSignatureCS(simpleSignatureCS, resultList);
					result.setStartOffset(simpleSignatureCS.getStartOffset());
					result.setEndOffset(getEndOffset(simpleSignatureCS.getEndOffset(), resultList));
					$setResult(result);
		  $EndJava
		./

	simple_signatureOpt ::= $empty
		/.$NullAction./
	simple_signatureOpt -> simple_signature

	simple_signature ::= '(' param_listOpt ')' 
		/.$BeginJava
					CSTNode result = createSimpleSignatureCS((EList<ParameterDeclarationCS>)$getSym(2));
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./

	param_listOpt ::= $empty
		/.$EmptyListAction./
	param_listOpt -> param_list

	param_list ::= param_list ',' param
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./
	param_list ::= param_list ',' qvtErrorToken
		/.$BeginJava
					EList result = (EList)$getSym(1);
					$setResult(result);
		  $EndJava
		./
	param_list ::= param
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	param_list ::= qvtErrorToken
		/.$BeginJava
					EList result = new BasicEList();
					$setResult(result);
		  $EndJava
		./

	param ::= param_directionOpt IDENTIFIER ':' typespec
		/.$BeginJava
					DirectionKindCS paramDirectionCS = (DirectionKindCS) $getSym(1);
					CSTNode result = createParameterDeclarationCS(
							paramDirectionCS,
							getIToken($getToken(2)),
							(TypeSpecCS)$getSym(4)
						);
					
					result.setStartOffset(paramDirectionCS != null ? paramDirectionCS.getStartOffset() : getIToken($getToken(2)).getStartOffset());
					result.setEndOffset(((CSTNode)$getSym(4)).getEndOffset());
					
					$setResult(result);
		  $EndJava
		./
		
	param ::= param_directionOpt typespec
		/.$BeginJava
					DirectionKindCS paramDirectionCS = (DirectionKindCS) $getSym(1);
					TypeSpecCS paramTypeCS = (TypeSpecCS) $getSym(2);
					CSTNode result = createParameterDeclarationCS(
							paramDirectionCS,
							null,
							paramTypeCS
						);

					result.setStartOffset(paramDirectionCS != null ? paramDirectionCS.getStartOffset() : paramTypeCS.getStartOffset());
					result.setEndOffset(paramTypeCS.getEndOffset());
					
					$setResult(result);
		  $EndJava
		./

	param_directionOpt ::= $empty
		/.$NullAction./
	param_directionOpt -> param_direction
	
	param_direction ::= in
		/.$BeginJava
					CSTNode result = createDirectionKindCS(
							DirectionKindEnum.IN
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	param_direction ::= out
		/.$BeginJava
					CSTNode result = createDirectionKindCS(
							DirectionKindEnum.OUT
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	
	param_direction ::= inout
		/.$BeginJava
					CSTNode result = createDirectionKindCS(
							DirectionKindEnum.INOUT
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	declarator -> declarator1
	declarator -> declarator2

	declarator1 ::= IDENTIFIER ':' typeCS
		/.$BeginJava
					CSTNode result = createVariableCS(
							getTokenText($getToken(1)),
							(TypeCS)$getSym(3),
							null
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./
	
	declarator1 ::= IDENTIFIER ':' typeCS '=' OclExpressionCS
		/.$BeginJava
					CSTNode result = createVariableCS(
							getTokenText($getToken(1)),
							(TypeCS)$getSym(3),
							(OCLExpressionCS)$getSym(5)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(5));
					$setResult(result);
		  $EndJava
		./

	declarator1 ::= IDENTIFIER ':' typeCS ':=' OclExpressionCS
		/.$BeginJava
					CSTNode result = createVariableCS(
							getTokenText($getToken(1)),
							(TypeCS)$getSym(3),
							(OCLExpressionCS)$getSym(5)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(5));
					$setResult(result);
		  $EndJava
		./
		
	declarator2 ::= IDENTIFIER ':=' OclExpressionCS
		/.$BeginJava
					CSTNode result = createVariableCS(
							getTokenText($getToken(1)),
							null,
							(OCLExpressionCS)$getSym(3)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./

	typespec ::= typeCS
		/.$BeginJava
					CSTNode result = createTypeSpecCS(
						(TypeCS)$getSym(1),
						null
						);
					$setResult(result);
		  $EndJava
		./
	
	typespec ::= typeCS '@' IDENTIFIER
		/.$BeginJava
					CSTNode result = createTypeSpecCS(
						(TypeCS)$getSym(1),
						getIToken($getToken(3))
						);
					$setResult(result);
		  $EndJava
		./

	typeCS2 -> primitiveTypeCS
	typeCS2 -> tupleTypeCS
	typeCS2 -> collectionTypeCS
	
	scoped_identifier ::= typeCS2 '::' IDENTIFIER
		/.$BeginJava
					ScopedNameCS result = createScopedNameCS((TypeCS)$getSym(1), getTokenText($getToken(3)));		
					setOffsets(result, (CSTNode) $getSym(1), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	scoped_identifier ::= typeCS2 '::' qvtErrorToken
		/.$BeginJava
					ScopedNameCS result = createScopedNameCS((TypeCS)$getSym(1), ""); //$NON-NLS-1$		
					setOffsets(result, (CSTNode) $getSym(1), getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
	scoped_identifier ::= scoped_identifier2
		/.$BeginJava
					PathNameCS pathNameCS = (PathNameCS)$getSym(1);
					String name = pathNameCS.getSimpleNames().remove(pathNameCS.getSimpleNames().size() - 1).getValue();
					TypeCS typeCS = pathNameCS.getSimpleNames().isEmpty() ? null : pathNameCS;

					ScopedNameCS result = createScopedNameCS(typeCS, name);		

					setOffsets(result, pathNameCS);

                                        // reduce the region by the removed name element
					pathNameCS.setEndOffset(pathNameCS.getEndOffset() - (name != null ? name.length() : 0) - 2);
					
					$setResult(result);
		  $EndJava
		./
	scoped_identifier2 ::= IDENTIFIER
		/.$BeginJava
					CSTNode result = createPathNameCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	scoped_identifier2 ::= main
		/.$BeginJava
					CSTNode result = createPathNameCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	scoped_identifier2 ::= scoped_identifier2 '::' IDENTIFIER
		/.$BeginJava
					PathNameCS result = (PathNameCS)$getSym(1);
					result = extendPathNameCS(result, getTokenText($getToken(3)));
					setOffsets(result, result, getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	scoped_identifier2 ::= scoped_identifier2 '::' qvtErrorToken
		/.$BeginJava
					PathNameCS result = (PathNameCS)$getSym(1);
					result = extendPathNameCS(result, ""); //$NON-NLS-1$
					setOffsets(result, result, getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
	scoped_identifier_list ::= scoped_identifier
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	scoped_identifier_list ::= scoped_identifier_list ',' scoped_identifier
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./
	scoped_identifier_list ::= scoped_identifier_list qvtErrorToken
		/.$BeginJava
					EList result = (EList)$getSym(1);
					$setResult(result);
		  $EndJava
		./

	semicolonOpt -> ';'
	semicolonOpt -> $empty

	expression_listOpt ::= $empty
		/.$EmptyListAction./
	expression_listOpt -> expression_list

	expression_list -> expression_semi_list semicolonOpt

	expression_semi_list_element -> OclExpressionCS
	expression_semi_list ::= expression_semi_list_element
		/.$BeginJava
					EList result = new BasicEList();
					Object element = $getSym(1);
					if (element instanceof EList) {
						result.addAll((EList) element);
					} else {
						result.add(element);
					}
					$setResult(result);
		  $EndJava
		./
	expression_semi_list ::= expression_semi_list ';' expression_semi_list_element 
		/.$BeginJava
					EList result = (EList)$getSym(1);
					Object element = $getSym(3);
					if (element instanceof EList) {
						result.addAll((EList) element);
					} else {
						result.add(element);
					}
					$setResult(result);
		  $EndJava
		./
	expression_semi_list ::= expression_semi_list qvtErrorToken 
		/.$BeginJava
					EList result = (EList)$getSym(1);
					$setResult(result);
		  $EndJava
		./

	expression_block ::= '{' expression_listOpt '}'
		/.$BeginJava
				EList bodyList = (EList) dtParser.getSym(2);
				CSTNode result = createBlockExpCS(
					bodyList
				);
				
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				$setResult(result);
	          $EndJava
		./

	expression_block ::= '{' qvtErrorToken
		/.$BeginJava
				CSTNode result = createBlockExpCS(
					$EMPTY_ELIST
				);
				
				setOffsets(result, getIToken(dtParser.getToken(1)));
				$setResult(result);
	          $EndJava
		./

	expression_statement -> OclExpressionCS ';'
	expression_statement -> expression_block semicolonOpt
	
	qualifiedNameCS ::= qvtIdentifierCS
		/.$BeginJava
					CSTNode result = createPathNameCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	qualifiedNameCS ::= qualifiedNameCS '.' qvtIdentifierCS
		/.$BeginJava
					PathNameCS result = (PathNameCS)$getSym(1);
					result = extendPathNameCS(result, getTokenText($getToken(3)));
					setOffsets(result, result, getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	qualifiedNameCS ::= qualifiedNameCS '.' qvtErrorToken
		/.$BeginJava
					PathNameCS result = (PathNameCS)$getSym(1);
					result = extendPathNameCS(result, ""); //$NON-NLS-1$
					setOffsets(result, result, getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
	qualifiedNameCS ::= qualifiedNameCS qvtErrorToken
		/.$BeginJava
					PathNameCS result = (PathNameCS)$getSym(1);
					$setResult(result);
		  $EndJava	
		./	
	--=== // general purpose grammar rules (end) ===--
	
	--=== // Expressions (start) ===--
	oclExpressionCSOpt -> OclExpressionCS 
	oclExpressionCSOpt ::= $empty
		/.$NullAction./

	-- 'let' extension in QVT
	-- in OCL variable has to define type
	letExpSubCS3 ::= variableNameCS '=' OclExpressionCS
		/.$BeginJava
					SimpleNameCS name = (SimpleNameCS)$getSym(1);
					OCLExpressionCS initExpression = (OCLExpressionCS)$getSym(3);
					VariableCS variableCS = createVariableCS(name, null, initExpression);
					setOffsets(variableCS, name, initExpression);

					EList result = new BasicEList();
					result.add(variableCS);
					$setResult(result);
		  $EndJava
		./

	letExpSubCS3 ::= letExpSubCS3 ',' TupleLiteralPartCS 
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./
			
	LetExpCS ::= let letExpSubCS3 in OclExpressionCS
		/.$BeginJava
					EList variables = (EList)$getSym(2);
					CSTNode result = createLetExpCS(
							variables,
							(OCLExpressionCS)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(4));
					$setResult(result);
		  $EndJava
		./
	--LetExpCS ::= let letExpSubCS3 in qvtErrorToken
	--	/.$BeginJava
	--				EList variables = (EList)$getSym(2);
	--				CSTNode result = createLetExpCS(
	--						variables,
	--						createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, "") //$NON-NLS-1$
	--					);
	--				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
	--				$setResult(result);
	--	  $EndJava
	--	./

	--=== // Expressions (end) ===--
		
	--=== OCL grammar error recovery extensions (start) ===--
	--iterContents ::= VariableDeclarationCS '|' qvtErrorToken
	--	/.$BeginJava
	--				CSTNode fakeCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, ""); //$NON-NLS-1$
	--				setOffsets(fakeCS, getIToken($getToken(3)));
	--				$setResult(new Object[] {
	--						$getSym(1),
	--						null,
	--						fakeCS
	--					});
	--	  $EndJava
	--	./
	CallExpCS ::= '.' qvtErrorToken
		/.$BeginJava
					CallExpCS result = TempFactory.eINSTANCE.createErrorCallExpCS();
		 			result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	CallExpCS ::= '->' qvtErrorToken
		/.$BeginJava
					CallExpCS result = TempFactory.eINSTANCE.createErrorCallExpCS();
		 			result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	argumentsCS ::= qvtErrorToken
		/.$EmptyListAction./	
	argumentsCS -> argumentsCS ',' qvtErrorToken


	iteratorExpCSToken -> forAll
	iteratorExpCSToken -> exists
	iteratorExpCSToken -> isUnique
	iteratorExpCSToken -> one
	iteratorExpCSToken -> any
	iteratorExpCSToken -> collect
	iteratorExpCSToken -> select
	iteratorExpCSToken -> reject
	iteratorExpCSToken -> collectNested
	iteratorExpCSToken -> sortedBy
	iteratorExpCSToken -> closure

	--IteratorExpCS ::= iteratorExpCSToken '(' qvtErrorToken
	--	/.$BeginJava
	--				SimpleNameCS simpleNameCS = createSimpleNameCS(
	--							SimpleTypeEnum.KEYWORD_LITERAL,
	--							getTokenText($getToken(1))
	--						);
	--				setOffsets(simpleNameCS, getIToken($getToken(1)));
	--				CSTNode result = createIteratorExpCS(
	--						simpleNameCS,
	--						null,
	--						null,
	--						null
	--					);
	--				setOffsets(result, getIToken($getToken(1)), getIToken($getToken(2)));
	--				$setResult(result);
	--	  $EndJava
	--	./
	--=== OCL grammar error recovery extensions (end) ===--

		
	--=== Miscellaneous QVTO grammar rules (start) ===--
	qvtIdentifierCS -> simpleNameCS
	--qvtIdentifierCS -> CollectionTypeIdentifierCS
	
	qvtErrorToken ::= ERROR_TOKEN
		/.$BeginJava
					diagnozeErrorToken($getToken(1));
		  $EndJava
		./


        ----- '!=' - a synonym of '<>' (start) -----
	equalityExpCS ::= equalityExpCS '!=' relationalExpCS
		/.$NewCase./
	equalityLetCS ::= equalityExpCS '!=' relationalLetCS
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.STRING_LITERAL,
								OCLStandardLibraryUtil.getOperationName(PredefinedType.NOT_EQUAL)
							);
					setOffsets(simpleNameCS, getIToken($getToken(2)));
					EList args = new BasicEList();
					args.add($getSym(3));
					CSTNode result = createOperationCallExpCS(
							(OCLExpressionCS)$getSym(1),
							simpleNameCS,
							args
						);
					setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./

	StringLiteralExpCS ::= StringLiteralExpCS STRING_LITERAL
		/.$BeginJava
					IToken literalToken = getIToken($getToken(2));
					StringLiteralExpCS result = (StringLiteralExpCS) $getSym(1);
					result.setSymbol(result.getSymbol() +  literalToken.toString());
					result.setStringSymbol(result.getStringSymbol() + literalToken.toString());
					result.setUnescapedStringSymbol(result.getUnescapedStringSymbol() +  unescape(literalToken));
					int tokenLine = literalToken.getLine();
					setOffsets(result, result, literalToken);
					IToken prevToken = getParseStream().getTokenAt(literalToken.getTokenIndex() - 1);
					int prevTokenLine = prevToken.getLine();
					if (prevTokenLine == tokenLine) {
						reportError(lpg.lpgjavaruntime.ParseErrorCodes.INVALID_CODE, "", prevToken.getTokenIndex(), literalToken.getTokenIndex(), "Multiline string literals must be located in different lines!"); //$NON-NLS-1$ //$NON-NLS-2$
					}
					$setResult(result);
		  $EndJava
		./
        
        ----- '!=' - a synonym of '<>' (end) -----
	--=== Miscellaneous QVTO grammar rules (end) ===--	
$End
