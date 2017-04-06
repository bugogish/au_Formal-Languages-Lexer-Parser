// Generated from /home/bugogish/au/FL/Lexer/src/main/LLanguage.g4 by ANTLR 4.6

package ru.spbau.mit.utils;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, THEN=2, ELSE=3, WHILE=4, DO=5, READ=6, WRITE=7, BEGIN=8, END=9, 
		KSKIP=10, Float=11, Boolean=12, LPAREN=13, RPAREN=14, SEMICOLON=15, ASSIGN=16, 
		GT=17, LT=18, EQ=19, LEQ=20, GEQ=21, NEQ=22, AND=23, OR=24, ADD=25, SUB=26, 
		POW=27, MUL=28, DIV=29, MOD=30, COMMENT=31, LINE_COMMENT=32, ERROR_WHILE_PARSING_ML_COMMENT=33, 
		ERROR_WHILE_PARSING_COMMENT=34, Id=35, WS=36;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_block = 2, RULE_assignment = 3, 
		RULE_expression = 4, RULE_andexpr = 5, RULE_orexpr = 6, RULE_eqexpr = 7, 
		RULE_compexpr = 8, RULE_addexpr = 9, RULE_multexpr = 10, RULE_atomexpr = 11;
	public static final String[] ruleNames = {
		"program", "statement", "block", "assignment", "expression", "andexpr", 
		"orexpr", "eqexpr", "compexpr", "addexpr", "multexpr", "atomexpr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'then'", "'else'", "'while'", "'do'", "'read'", "'write'", 
		"'begin'", "'end'", "'skip'", null, null, "'('", "')'", "';'", "':='", 
		"'>'", "'<'", "'=='", "'<='", "'>='", "'!='", "'&&'", "'||'", "'+'", "'-'", 
		"'**'", "'*'", "'/'", "'%'", null, null, "'(*'", "'*)'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "IF", "THEN", "ELSE", "WHILE", "DO", "READ", "WRITE", "BEGIN", "END", 
		"KSKIP", "Float", "Boolean", "LPAREN", "RPAREN", "SEMICOLON", "ASSIGN", 
		"GT", "LT", "EQ", "LEQ", "GEQ", "NEQ", "AND", "OR", "ADD", "SUB", "POW", 
		"MUL", "DIV", "MOD", "COMMENT", "LINE_COMMENT", "ERROR_WHILE_PARSING_ML_COMMENT", 
		"ERROR_WHILE_PARSING_COMMENT", "Id", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "LLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(LLanguageParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(LLanguageParser.SEMICOLON, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLanguageListener ) ((LLanguageListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLanguageListener ) ((LLanguageListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLanguageVisitor ) return ((LLanguageVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			statement();
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(25);
				match(SEMICOLON);
				setState(26);
				statement();
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public TerminalNode KSKIP() { return getToken(LLanguageParser.KSKIP, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public TerminalNode WRITE() { return getToken(LLanguageParser.WRITE, 0); }
		public TerminalNode LPAREN() { return getToken(LLanguageParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LLanguageParser.RPAREN, 0); }
		public TerminalNode READ() { return getToken(LLanguageParser.READ, 0); }
		public TerminalNode Id() { return getToken(LLanguageParser.Id, 0); }
		public TerminalNode WHILE() { return getToken(LLanguageParser.WHILE, 0); }
		public TerminalNode DO() { return getToken(LLanguageParser.DO, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode IF() { return getToken(LLanguageParser.IF, 0); }
		public TerminalNode THEN() { return getToken(LLanguageParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(LLanguageParser.ELSE, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLanguageListener ) ((LLanguageListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLanguageListener ) ((LLanguageListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLanguageVisitor ) return ((LLanguageVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KSKIP:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				match(KSKIP);
				}
				break;
			case Id:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				assignment();
				}
				break;
			case WRITE:
				enterOuterAlt(_localctx, 3);
				{
				setState(34);
				match(WRITE);
				setState(35);
				match(LPAREN);
				setState(36);
				expression();
				setState(37);
				match(RPAREN);
				}
				break;
			case READ:
				enterOuterAlt(_localctx, 4);
				{
				setState(39);
				match(READ);
				setState(40);
				match(LPAREN);
				setState(41);
				match(Id);
				setState(42);
				match(RPAREN);
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 5);
				{
				setState(43);
				match(WHILE);
				setState(44);
				match(LPAREN);
				setState(45);
				expression();
				setState(46);
				match(RPAREN);
				setState(47);
				match(DO);
				setState(48);
				block();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 6);
				{
				setState(50);
				match(IF);
				setState(51);
				match(LPAREN);
				setState(52);
				expression();
				setState(53);
				match(RPAREN);
				setState(54);
				match(THEN);
				setState(55);
				block();
				setState(56);
				match(ELSE);
				setState(57);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(LLanguageParser.BEGIN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode END() { return getToken(LLanguageParser.END, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(LLanguageParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(LLanguageParser.SEMICOLON, i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLanguageListener ) ((LLanguageListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLanguageListener ) ((LLanguageListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLanguageVisitor ) return ((LLanguageVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		int _la;
		try {
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGIN:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				match(BEGIN);
				setState(62);
				statement();
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEMICOLON) {
					{
					{
					setState(63);
					match(SEMICOLON);
					setState(64);
					statement();
					}
					}
					setState(69);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(70);
				match(END);
				}
				break;
			case IF:
			case WHILE:
			case READ:
			case WRITE:
			case KSKIP:
			case Id:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(LLanguageParser.Id, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLanguageListener ) ((LLanguageListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLanguageListener ) ((LLanguageListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLanguageVisitor ) return ((LLanguageVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(Id);
			setState(76);
			match(ASSIGN);
			setState(77);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public MultexprContext multexpr() {
			return getRuleContext(MultexprContext.class,0);
		}
		public AddexprContext addexpr() {
			return getRuleContext(AddexprContext.class,0);
		}
		public CompexprContext compexpr() {
			return getRuleContext(CompexprContext.class,0);
		}
		public EqexprContext eqexpr() {
			return getRuleContext(EqexprContext.class,0);
		}
		public AndexprContext andexpr() {
			return getRuleContext(AndexprContext.class,0);
		}
		public OrexprContext orexpr() {
			return getRuleContext(OrexprContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLanguageListener ) ((LLanguageListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLanguageListener ) ((LLanguageListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLanguageVisitor ) return ((LLanguageVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expression);
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				multexpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				addexpr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				compexpr(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(82);
				eqexpr(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(83);
				andexpr(0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(84);
				orexpr(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndexprContext extends ParserRuleContext {
		public EqexprContext eqexpr() {
			return getRuleContext(EqexprContext.class,0);
		}
		public AndexprContext andexpr() {
			return getRuleContext(AndexprContext.class,0);
		}
		public TerminalNode AND() { return getToken(LLanguageParser.AND, 0); }
		public AndexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLanguageListener ) ((LLanguageListener)listener).enterAndexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLanguageListener ) ((LLanguageListener)listener).exitAndexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLanguageVisitor ) return ((LLanguageVisitor<? extends T>)visitor).visitAndexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndexprContext andexpr() throws RecognitionException {
		return andexpr(0);
	}

	private AndexprContext andexpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AndexprContext _localctx = new AndexprContext(_ctx, _parentState);
		AndexprContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_andexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(88);
			eqexpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(95);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndexprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_andexpr);
					setState(90);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(91);
					match(AND);
					setState(92);
					eqexpr(0);
					}
					} 
				}
				setState(97);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class OrexprContext extends ParserRuleContext {
		public AddexprContext addexpr() {
			return getRuleContext(AddexprContext.class,0);
		}
		public OrexprContext orexpr() {
			return getRuleContext(OrexprContext.class,0);
		}
		public TerminalNode OR() { return getToken(LLanguageParser.OR, 0); }
		public OrexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLanguageListener ) ((LLanguageListener)listener).enterOrexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLanguageListener ) ((LLanguageListener)listener).exitOrexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLanguageVisitor ) return ((LLanguageVisitor<? extends T>)visitor).visitOrexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrexprContext orexpr() throws RecognitionException {
		return orexpr(0);
	}

	private OrexprContext orexpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		OrexprContext _localctx = new OrexprContext(_ctx, _parentState);
		OrexprContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_orexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(99);
			addexpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(106);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OrexprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_orexpr);
					setState(101);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(102);
					match(OR);
					setState(103);
					addexpr(0);
					}
					} 
				}
				setState(108);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EqexprContext extends ParserRuleContext {
		public CompexprContext compexpr() {
			return getRuleContext(CompexprContext.class,0);
		}
		public EqexprContext eqexpr() {
			return getRuleContext(EqexprContext.class,0);
		}
		public TerminalNode EQ() { return getToken(LLanguageParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(LLanguageParser.NEQ, 0); }
		public EqexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLanguageListener ) ((LLanguageListener)listener).enterEqexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLanguageListener ) ((LLanguageListener)listener).exitEqexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLanguageVisitor ) return ((LLanguageVisitor<? extends T>)visitor).visitEqexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqexprContext eqexpr() throws RecognitionException {
		return eqexpr(0);
	}

	private EqexprContext eqexpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqexprContext _localctx = new EqexprContext(_ctx, _parentState);
		EqexprContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_eqexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(110);
			compexpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(120);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(118);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new EqexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_eqexpr);
						setState(112);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(113);
						match(EQ);
						setState(114);
						compexpr(0);
						}
						break;
					case 2:
						{
						_localctx = new EqexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_eqexpr);
						setState(115);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(116);
						match(NEQ);
						setState(117);
						compexpr(0);
						}
						break;
					}
					} 
				}
				setState(122);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CompexprContext extends ParserRuleContext {
		public AddexprContext addexpr() {
			return getRuleContext(AddexprContext.class,0);
		}
		public CompexprContext compexpr() {
			return getRuleContext(CompexprContext.class,0);
		}
		public TerminalNode LT() { return getToken(LLanguageParser.LT, 0); }
		public TerminalNode LEQ() { return getToken(LLanguageParser.LEQ, 0); }
		public TerminalNode GT() { return getToken(LLanguageParser.GT, 0); }
		public TerminalNode GEQ() { return getToken(LLanguageParser.GEQ, 0); }
		public CompexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLanguageListener ) ((LLanguageListener)listener).enterCompexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLanguageListener ) ((LLanguageListener)listener).exitCompexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLanguageVisitor ) return ((LLanguageVisitor<? extends T>)visitor).visitCompexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompexprContext compexpr() throws RecognitionException {
		return compexpr(0);
	}

	private CompexprContext compexpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CompexprContext _localctx = new CompexprContext(_ctx, _parentState);
		CompexprContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_compexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(124);
			addexpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(140);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(138);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new CompexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_compexpr);
						setState(126);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(127);
						match(LT);
						setState(128);
						addexpr(0);
						}
						break;
					case 2:
						{
						_localctx = new CompexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_compexpr);
						setState(129);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(130);
						match(LEQ);
						setState(131);
						addexpr(0);
						}
						break;
					case 3:
						{
						_localctx = new CompexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_compexpr);
						setState(132);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(133);
						match(GT);
						setState(134);
						addexpr(0);
						}
						break;
					case 4:
						{
						_localctx = new CompexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_compexpr);
						setState(135);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(136);
						match(GEQ);
						setState(137);
						addexpr(0);
						}
						break;
					}
					} 
				}
				setState(142);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AddexprContext extends ParserRuleContext {
		public MultexprContext multexpr() {
			return getRuleContext(MultexprContext.class,0);
		}
		public AddexprContext addexpr() {
			return getRuleContext(AddexprContext.class,0);
		}
		public TerminalNode ADD() { return getToken(LLanguageParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(LLanguageParser.SUB, 0); }
		public AddexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLanguageListener ) ((LLanguageListener)listener).enterAddexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLanguageListener ) ((LLanguageListener)listener).exitAddexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLanguageVisitor ) return ((LLanguageVisitor<? extends T>)visitor).visitAddexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddexprContext addexpr() throws RecognitionException {
		return addexpr(0);
	}

	private AddexprContext addexpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AddexprContext _localctx = new AddexprContext(_ctx, _parentState);
		AddexprContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_addexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(144);
			multexpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(154);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(152);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new AddexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_addexpr);
						setState(146);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(147);
						match(ADD);
						setState(148);
						multexpr();
						}
						break;
					case 2:
						{
						_localctx = new AddexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_addexpr);
						setState(149);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(150);
						match(SUB);
						setState(151);
						multexpr();
						}
						break;
					}
					} 
				}
				setState(156);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MultexprContext extends ParserRuleContext {
		public AtomexprContext atomexpr() {
			return getRuleContext(AtomexprContext.class,0);
		}
		public List<TerminalNode> MUL() { return getTokens(LLanguageParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(LLanguageParser.MUL, i);
		}
		public List<MultexprContext> multexpr() {
			return getRuleContexts(MultexprContext.class);
		}
		public MultexprContext multexpr(int i) {
			return getRuleContext(MultexprContext.class,i);
		}
		public List<TerminalNode> DIV() { return getTokens(LLanguageParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(LLanguageParser.DIV, i);
		}
		public List<TerminalNode> MOD() { return getTokens(LLanguageParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(LLanguageParser.MOD, i);
		}
		public MultexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLanguageListener ) ((LLanguageListener)listener).enterMultexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLanguageListener ) ((LLanguageListener)listener).exitMultexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLanguageVisitor ) return ((LLanguageVisitor<? extends T>)visitor).visitMultexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultexprContext multexpr() throws RecognitionException {
		MultexprContext _localctx = new MultexprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_multexpr);
		try {
			int _alt;
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				atomexpr();
				setState(162);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(158);
						match(MUL);
						setState(159);
						multexpr();
						}
						} 
					}
					setState(164);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				atomexpr();
				setState(170);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(166);
						match(DIV);
						setState(167);
						multexpr();
						}
						} 
					}
					setState(172);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(173);
				atomexpr();
				setState(178);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(174);
						match(MOD);
						setState(175);
						multexpr();
						}
						} 
					}
					setState(180);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomexprContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(LLanguageParser.Id, 0); }
		public TerminalNode Float() { return getToken(LLanguageParser.Float, 0); }
		public TerminalNode LPAREN() { return getToken(LLanguageParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LLanguageParser.RPAREN, 0); }
		public TerminalNode Boolean() { return getToken(LLanguageParser.Boolean, 0); }
		public AtomexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLanguageListener ) ((LLanguageListener)listener).enterAtomexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLanguageListener ) ((LLanguageListener)listener).exitAtomexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLanguageVisitor ) return ((LLanguageVisitor<? extends T>)visitor).visitAtomexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomexprContext atomexpr() throws RecognitionException {
		AtomexprContext _localctx = new AtomexprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_atomexpr);
		try {
			setState(190);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Id:
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				match(Id);
				}
				break;
			case Float:
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				match(Float);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(185);
				match(LPAREN);
				setState(186);
				expression();
				setState(187);
				match(RPAREN);
				}
				break;
			case Boolean:
				enterOuterAlt(_localctx, 4);
				{
				setState(189);
				match(Boolean);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return andexpr_sempred((AndexprContext)_localctx, predIndex);
		case 6:
			return orexpr_sempred((OrexprContext)_localctx, predIndex);
		case 7:
			return eqexpr_sempred((EqexprContext)_localctx, predIndex);
		case 8:
			return compexpr_sempred((CompexprContext)_localctx, predIndex);
		case 9:
			return addexpr_sempred((AddexprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean andexpr_sempred(AndexprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean orexpr_sempred(OrexprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean eqexpr_sempred(EqexprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean compexpr_sempred(CompexprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean addexpr_sempred(AddexprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 2);
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3&\u00c3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3>\n\3\3\4\3\4\3\4\3\4\7\4D\n\4\f\4\16\4"+
		"G\13\4\3\4\3\4\3\4\5\4L\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\5"+
		"\6X\n\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7`\n\7\f\7\16\7c\13\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\7\bk\n\b\f\b\16\bn\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\7\ty\n\t\f\t\16\t|\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\7\n\u008d\n\n\f\n\16\n\u0090\13\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\7\13\u009b\n\13\f\13\16\13\u009e\13\13\3\f\3\f"+
		"\3\f\7\f\u00a3\n\f\f\f\16\f\u00a6\13\f\3\f\3\f\3\f\7\f\u00ab\n\f\f\f\16"+
		"\f\u00ae\13\f\3\f\3\f\3\f\7\f\u00b3\n\f\f\f\16\f\u00b6\13\f\5\f\u00b8"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00c1\n\r\3\r\2\7\f\16\20\22\24\16"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\2\2\u00d5\2\32\3\2\2\2\4=\3\2\2\2\6K\3"+
		"\2\2\2\bM\3\2\2\2\nW\3\2\2\2\fY\3\2\2\2\16d\3\2\2\2\20o\3\2\2\2\22}\3"+
		"\2\2\2\24\u0091\3\2\2\2\26\u00b7\3\2\2\2\30\u00c0\3\2\2\2\32\37\5\4\3"+
		"\2\33\34\7\21\2\2\34\36\5\4\3\2\35\33\3\2\2\2\36!\3\2\2\2\37\35\3\2\2"+
		"\2\37 \3\2\2\2 \3\3\2\2\2!\37\3\2\2\2\">\7\f\2\2#>\5\b\5\2$%\7\t\2\2%"+
		"&\7\17\2\2&\'\5\n\6\2\'(\7\20\2\2(>\3\2\2\2)*\7\b\2\2*+\7\17\2\2+,\7%"+
		"\2\2,>\7\20\2\2-.\7\6\2\2./\7\17\2\2/\60\5\n\6\2\60\61\7\20\2\2\61\62"+
		"\7\7\2\2\62\63\5\6\4\2\63>\3\2\2\2\64\65\7\3\2\2\65\66\7\17\2\2\66\67"+
		"\5\n\6\2\678\7\20\2\289\7\4\2\29:\5\6\4\2:;\7\5\2\2;<\5\6\4\2<>\3\2\2"+
		"\2=\"\3\2\2\2=#\3\2\2\2=$\3\2\2\2=)\3\2\2\2=-\3\2\2\2=\64\3\2\2\2>\5\3"+
		"\2\2\2?@\7\n\2\2@E\5\4\3\2AB\7\21\2\2BD\5\4\3\2CA\3\2\2\2DG\3\2\2\2EC"+
		"\3\2\2\2EF\3\2\2\2FH\3\2\2\2GE\3\2\2\2HI\7\13\2\2IL\3\2\2\2JL\5\4\3\2"+
		"K?\3\2\2\2KJ\3\2\2\2L\7\3\2\2\2MN\7%\2\2NO\7\22\2\2OP\5\n\6\2P\t\3\2\2"+
		"\2QX\5\26\f\2RX\5\24\13\2SX\5\22\n\2TX\5\20\t\2UX\5\f\7\2VX\5\16\b\2W"+
		"Q\3\2\2\2WR\3\2\2\2WS\3\2\2\2WT\3\2\2\2WU\3\2\2\2WV\3\2\2\2X\13\3\2\2"+
		"\2YZ\b\7\1\2Z[\5\20\t\2[a\3\2\2\2\\]\f\3\2\2]^\7\31\2\2^`\5\20\t\2_\\"+
		"\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2b\r\3\2\2\2ca\3\2\2\2de\b\b\1\2"+
		"ef\5\24\13\2fl\3\2\2\2gh\f\3\2\2hi\7\32\2\2ik\5\24\13\2jg\3\2\2\2kn\3"+
		"\2\2\2lj\3\2\2\2lm\3\2\2\2m\17\3\2\2\2nl\3\2\2\2op\b\t\1\2pq\5\22\n\2"+
		"qz\3\2\2\2rs\f\4\2\2st\7\25\2\2ty\5\22\n\2uv\f\3\2\2vw\7\30\2\2wy\5\22"+
		"\n\2xr\3\2\2\2xu\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\21\3\2\2\2|z\3"+
		"\2\2\2}~\b\n\1\2~\177\5\24\13\2\177\u008e\3\2\2\2\u0080\u0081\f\6\2\2"+
		"\u0081\u0082\7\24\2\2\u0082\u008d\5\24\13\2\u0083\u0084\f\5\2\2\u0084"+
		"\u0085\7\26\2\2\u0085\u008d\5\24\13\2\u0086\u0087\f\4\2\2\u0087\u0088"+
		"\7\23\2\2\u0088\u008d\5\24\13\2\u0089\u008a\f\3\2\2\u008a\u008b\7\27\2"+
		"\2\u008b\u008d\5\24\13\2\u008c\u0080\3\2\2\2\u008c\u0083\3\2\2\2\u008c"+
		"\u0086\3\2\2\2\u008c\u0089\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2"+
		"\2\2\u008e\u008f\3\2\2\2\u008f\23\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0092"+
		"\b\13\1\2\u0092\u0093\5\26\f\2\u0093\u009c\3\2\2\2\u0094\u0095\f\4\2\2"+
		"\u0095\u0096\7\33\2\2\u0096\u009b\5\26\f\2\u0097\u0098\f\3\2\2\u0098\u0099"+
		"\7\34\2\2\u0099\u009b\5\26\f\2\u009a\u0094\3\2\2\2\u009a\u0097\3\2\2\2"+
		"\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\25"+
		"\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a4\5\30\r\2\u00a0\u00a1\7\36\2\2"+
		"\u00a1\u00a3\5\26\f\2\u00a2\u00a0\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2"+
		"\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00b8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7"+
		"\u00ac\5\30\r\2\u00a8\u00a9\7\37\2\2\u00a9\u00ab\5\26\f\2\u00aa\u00a8"+
		"\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\u00b8\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b4\5\30\r\2\u00b0\u00b1\7"+
		" \2\2\u00b1\u00b3\5\26\f\2\u00b2\u00b0\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4"+
		"\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2"+
		"\2\2\u00b7\u009f\3\2\2\2\u00b7\u00a7\3\2\2\2\u00b7\u00af\3\2\2\2\u00b8"+
		"\27\3\2\2\2\u00b9\u00c1\7%\2\2\u00ba\u00c1\7\r\2\2\u00bb\u00bc\7\17\2"+
		"\2\u00bc\u00bd\5\n\6\2\u00bd\u00be\7\20\2\2\u00be\u00c1\3\2\2\2\u00bf"+
		"\u00c1\7\16\2\2\u00c0\u00b9\3\2\2\2\u00c0\u00ba\3\2\2\2\u00c0\u00bb\3"+
		"\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\31\3\2\2\2\24\37=EKWalxz\u008c\u008e"+
		"\u009a\u009c\u00a4\u00ac\u00b4\u00b7\u00c0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}