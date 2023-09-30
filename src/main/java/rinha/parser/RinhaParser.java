// Generated from C:/Users/leona/IdeaProjects/rinha-de-compiler-scala2/src/main/antlr/rinha/Rinha.g4 by ANTLR 4.13.1
package rinha.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class RinhaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, INT=29, STR=30, BOOL=31, ID=32, 
		Space=33;
	public static final int
		RULE_program = 0, RULE_expr = 1, RULE_block = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expr", "block"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'let'", "'='", "';'", "'if'", "'('", "')'", "'else'", "'fn'", 
			"','", "'=>'", "'print'", "'first'", "'second'", "'*'", "'/'", "'%'", 
			"'+'", "'-'", "'<'", "'>'", "'<='", "'>='", "'&&'", "'||'", "'=='", "'!='", 
			"'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "INT", "STR", "BOOL", "ID", "Space"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "Rinha.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RinhaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			expr(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolContext extends ExprContext {
		public TerminalNode BOOL() { return getToken(RinhaParser.BOOL, 0); }
		public BoolContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).exitBool(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BinContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).enterBin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).exitBin(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntContext extends ExprContext {
		public TerminalNode INT() { return getToken(RinhaParser.INT, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).exitInt(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SecondContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SecondContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).enterSecond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).exitSecond(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StrContext extends ExprContext {
		public TerminalNode STR() { return getToken(RinhaParser.STR, 0); }
		public StrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).enterStr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).exitStr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CallContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).exitCall(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TupleContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TupleContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).enterTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).exitTuple(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrintContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).exitPrint(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LetContext extends ExprContext {
		public TerminalNode ID() { return getToken(RinhaParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LetContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).enterLet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).exitLet(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdContext extends ExprContext {
		public TerminalNode ID() { return getToken(RinhaParser.ID, 0); }
		public IdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).exitId(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IfContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).exitIf(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunContext extends ExprContext {
		public List<TerminalNode> ID() { return getTokens(RinhaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RinhaParser.ID, i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).enterFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).exitFun(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FirstContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FirstContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).enterFirst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).exitFirst(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				_localctx = new LetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(9);
				match(T__0);
				setState(10);
				match(ID);
				setState(11);
				match(T__1);
				setState(12);
				expr(0);
				setState(13);
				match(T__2);
				setState(14);
				expr(18);
				}
				break;
			case T__3:
				{
				_localctx = new IfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(16);
				match(T__3);
				setState(17);
				match(T__4);
				setState(18);
				expr(0);
				setState(19);
				match(T__5);
				setState(20);
				block();
				setState(21);
				match(T__6);
				setState(22);
				block();
				}
				break;
			case T__7:
				{
				_localctx = new FunContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24);
				match(T__7);
				setState(25);
				match(T__4);
				setState(26);
				match(ID);
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(27);
					match(T__8);
					setState(28);
					match(ID);
					}
					}
					setState(33);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(34);
				match(T__5);
				setState(35);
				match(T__9);
				setState(36);
				block();
				}
				break;
			case T__10:
				{
				_localctx = new PrintContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(37);
				match(T__10);
				setState(38);
				match(T__4);
				setState(39);
				expr(0);
				setState(40);
				match(T__5);
				}
				break;
			case T__11:
				{
				_localctx = new FirstContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(42);
				match(T__11);
				setState(43);
				match(T__4);
				setState(44);
				expr(0);
				setState(45);
				match(T__5);
				}
				break;
			case T__12:
				{
				_localctx = new SecondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(47);
				match(T__12);
				setState(48);
				match(T__4);
				setState(49);
				expr(0);
				setState(50);
				match(T__5);
				}
				break;
			case BOOL:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(52);
				match(BOOL);
				}
				break;
			case INT:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(53);
				match(INT);
				}
				break;
			case STR:
				{
				_localctx = new StrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(54);
				match(STR);
				}
				break;
			case ID:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(55);
				match(ID);
				}
				break;
			case T__4:
				{
				_localctx = new TupleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56);
				match(T__4);
				setState(57);
				expr(0);
				setState(58);
				match(T__8);
				setState(59);
				expr(0);
				setState(60);
				match(T__5);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(96);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(94);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new BinContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(64);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(65);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 114688L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(66);
						expr(7);
						}
						break;
					case 2:
						{
						_localctx = new BinContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(67);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(68);
						_la = _input.LA(1);
						if ( !(_la==T__16 || _la==T__17) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(69);
						expr(6);
						}
						break;
					case 3:
						{
						_localctx = new BinContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(70);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(71);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7864320L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(72);
						expr(5);
						}
						break;
					case 4:
						{
						_localctx = new BinContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(73);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						{
						setState(74);
						match(T__22);
						}
						setState(75);
						expr(4);
						}
						break;
					case 5:
						{
						_localctx = new BinContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(76);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						{
						setState(77);
						match(T__23);
						}
						setState(78);
						expr(3);
						}
						break;
					case 6:
						{
						_localctx = new BinContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(79);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(80);
						_la = _input.LA(1);
						if ( !(_la==T__24 || _la==T__25) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(81);
						expr(2);
						}
						break;
					case 7:
						{
						_localctx = new CallContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(82);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(83);
						match(T__4);
						setState(84);
						expr(0);
						setState(89);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__8) {
							{
							{
							setState(85);
							match(T__8);
							setState(86);
							expr(0);
							}
							}
							setState(91);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(92);
						match(T__5);
						}
						break;
					}
					} 
				}
				setState(98);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RinhaListener ) ((RinhaListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__26);
			setState(100);
			expr(0);
			setState(101);
			match(T__27);
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
		case 1:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		case 6:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001!h\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u0001\u001e\b\u0001\n\u0001\f\u0001!\t\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001?\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001X\b\u0001\n\u0001"+
		"\f\u0001[\t\u0001\u0001\u0001\u0001\u0001\u0005\u0001_\b\u0001\n\u0001"+
		"\f\u0001b\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0000\u0001\u0002\u0003\u0000\u0002\u0004\u0000\u0004\u0001\u0000"+
		"\u000e\u0010\u0001\u0000\u0011\u0012\u0001\u0000\u0013\u0016\u0001\u0000"+
		"\u0019\u001aw\u0000\u0006\u0001\u0000\u0000\u0000\u0002>\u0001\u0000\u0000"+
		"\u0000\u0004c\u0001\u0000\u0000\u0000\u0006\u0007\u0003\u0002\u0001\u0000"+
		"\u0007\u0001\u0001\u0000\u0000\u0000\b\t\u0006\u0001\uffff\uffff\u0000"+
		"\t\n\u0005\u0001\u0000\u0000\n\u000b\u0005 \u0000\u0000\u000b\f\u0005"+
		"\u0002\u0000\u0000\f\r\u0003\u0002\u0001\u0000\r\u000e\u0005\u0003\u0000"+
		"\u0000\u000e\u000f\u0003\u0002\u0001\u0012\u000f?\u0001\u0000\u0000\u0000"+
		"\u0010\u0011\u0005\u0004\u0000\u0000\u0011\u0012\u0005\u0005\u0000\u0000"+
		"\u0012\u0013\u0003\u0002\u0001\u0000\u0013\u0014\u0005\u0006\u0000\u0000"+
		"\u0014\u0015\u0003\u0004\u0002\u0000\u0015\u0016\u0005\u0007\u0000\u0000"+
		"\u0016\u0017\u0003\u0004\u0002\u0000\u0017?\u0001\u0000\u0000\u0000\u0018"+
		"\u0019\u0005\b\u0000\u0000\u0019\u001a\u0005\u0005\u0000\u0000\u001a\u001f"+
		"\u0005 \u0000\u0000\u001b\u001c\u0005\t\u0000\u0000\u001c\u001e\u0005"+
		" \u0000\u0000\u001d\u001b\u0001\u0000\u0000\u0000\u001e!\u0001\u0000\u0000"+
		"\u0000\u001f\u001d\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000"+
		" \"\u0001\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000\"#\u0005\u0006"+
		"\u0000\u0000#$\u0005\n\u0000\u0000$?\u0003\u0004\u0002\u0000%&\u0005\u000b"+
		"\u0000\u0000&\'\u0005\u0005\u0000\u0000\'(\u0003\u0002\u0001\u0000()\u0005"+
		"\u0006\u0000\u0000)?\u0001\u0000\u0000\u0000*+\u0005\f\u0000\u0000+,\u0005"+
		"\u0005\u0000\u0000,-\u0003\u0002\u0001\u0000-.\u0005\u0006\u0000\u0000"+
		".?\u0001\u0000\u0000\u0000/0\u0005\r\u0000\u000001\u0005\u0005\u0000\u0000"+
		"12\u0003\u0002\u0001\u000023\u0005\u0006\u0000\u00003?\u0001\u0000\u0000"+
		"\u00004?\u0005\u001f\u0000\u00005?\u0005\u001d\u0000\u00006?\u0005\u001e"+
		"\u0000\u00007?\u0005 \u0000\u000089\u0005\u0005\u0000\u00009:\u0003\u0002"+
		"\u0001\u0000:;\u0005\t\u0000\u0000;<\u0003\u0002\u0001\u0000<=\u0005\u0006"+
		"\u0000\u0000=?\u0001\u0000\u0000\u0000>\b\u0001\u0000\u0000\u0000>\u0010"+
		"\u0001\u0000\u0000\u0000>\u0018\u0001\u0000\u0000\u0000>%\u0001\u0000"+
		"\u0000\u0000>*\u0001\u0000\u0000\u0000>/\u0001\u0000\u0000\u0000>4\u0001"+
		"\u0000\u0000\u0000>5\u0001\u0000\u0000\u0000>6\u0001\u0000\u0000\u0000"+
		">7\u0001\u0000\u0000\u0000>8\u0001\u0000\u0000\u0000?`\u0001\u0000\u0000"+
		"\u0000@A\n\u0006\u0000\u0000AB\u0007\u0000\u0000\u0000B_\u0003\u0002\u0001"+
		"\u0007CD\n\u0005\u0000\u0000DE\u0007\u0001\u0000\u0000E_\u0003\u0002\u0001"+
		"\u0006FG\n\u0004\u0000\u0000GH\u0007\u0002\u0000\u0000H_\u0003\u0002\u0001"+
		"\u0005IJ\n\u0003\u0000\u0000JK\u0005\u0017\u0000\u0000K_\u0003\u0002\u0001"+
		"\u0004LM\n\u0002\u0000\u0000MN\u0005\u0018\u0000\u0000N_\u0003\u0002\u0001"+
		"\u0003OP\n\u0001\u0000\u0000PQ\u0007\u0003\u0000\u0000Q_\u0003\u0002\u0001"+
		"\u0002RS\n\u000b\u0000\u0000ST\u0005\u0005\u0000\u0000TY\u0003\u0002\u0001"+
		"\u0000UV\u0005\t\u0000\u0000VX\u0003\u0002\u0001\u0000WU\u0001\u0000\u0000"+
		"\u0000X[\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001\u0000"+
		"\u0000\u0000Z\\\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000\\]\u0005"+
		"\u0006\u0000\u0000]_\u0001\u0000\u0000\u0000^@\u0001\u0000\u0000\u0000"+
		"^C\u0001\u0000\u0000\u0000^F\u0001\u0000\u0000\u0000^I\u0001\u0000\u0000"+
		"\u0000^L\u0001\u0000\u0000\u0000^O\u0001\u0000\u0000\u0000^R\u0001\u0000"+
		"\u0000\u0000_b\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000`a\u0001"+
		"\u0000\u0000\u0000a\u0003\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000"+
		"\u0000cd\u0005\u001b\u0000\u0000de\u0003\u0002\u0001\u0000ef\u0005\u001c"+
		"\u0000\u0000f\u0005\u0001\u0000\u0000\u0000\u0005\u001f>Y^`";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}