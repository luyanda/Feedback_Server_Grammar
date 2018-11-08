// Generated from /home/epsilon/Documents/Varsity/Project/build/web/uploadFiles/simpl.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class simplParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, TYPE=30, RELOP=31, MULOP=32, 
		ADDOP=33, STRING=34, ESC=35, LETTER=36, DIGIT=37, WS=38;
	public static final int
		RULE_program = 0, RULE_fundef = 1, RULE_param = 2, RULE_id = 3, RULE_body = 4, 
		RULE_vardecl = 5, RULE_statements = 6, RULE_statement = 7, RULE_assign = 8, 
		RULE_xif = 9, RULE_xwhile = 10, RULE_input = 11, RULE_output = 12, RULE_name = 13, 
		RULE_expr = 14, RULE_simple = 15, RULE_term = 16, RULE_factor = 17, RULE_num = 18;
	public static final String[] ruleNames = {
		"program", "fundef", "param", "id", "body", "vardecl", "statements", "statement", 
		"assign", "xif", "xwhile", "input", "output", "name", "expr", "simple", 
		"term", "factor", "num"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'program'", "'define'", "'('", "','", "')'", "'->'", "'array'", 
		"'begin'", "'end'", "';'", "'relax'", "'leave'", "':='", "'if'", "'then'", 
		"'elsif'", "'then statements'", "'else'", "'while'", "'do'", "'read'", 
		"'write'", "'.'", "'['", "']'", "'-'", "'not'", "'true'", "'false'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "TYPE", "RELOP", "MULOP", "ADDOP", 
		"STRING", "ESC", "LETTER", "DIGIT", "WS"
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
	public String getGrammarFileName() { return "simpl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public simplParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public List<FundefContext> fundef() {
			return getRuleContexts(FundefContext.class);
		}
		public FundefContext fundef(int i) {
			return getRuleContext(FundefContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(T__0);
			setState(39);
			id();
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(40);
				fundef();
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
			body();
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

	public static class FundefContext extends ParserRuleContext {
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode TYPE() { return getToken(simplParser.TYPE, 0); }
		public FundefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fundef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).enterFundef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).exitFundef(this);
		}
	}

	public final FundefContext fundef() throws RecognitionException {
		FundefContext _localctx = new FundefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_fundef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(T__1);
			setState(49);
			id();
			setState(50);
			match(T__2);
			setState(51);
			param();
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(52);
				match(T__3);
				setState(53);
				param();
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			match(T__4);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(60);
				match(T__5);
				setState(61);
				match(TYPE);
				setState(62);
				id();
				}
			}

			setState(65);
			body();
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

	public static class ParamContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(simplParser.TYPE, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(TYPE);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(68);
				match(T__6);
				}
			}

			setState(71);
			id();
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

	public static class IdContext extends ParserRuleContext {
		public List<TerminalNode> LETTER() { return getTokens(simplParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(simplParser.LETTER, i);
		}
		public List<TerminalNode> DIGIT() { return getTokens(simplParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(simplParser.DIGIT, i);
		}
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).exitId(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(LETTER);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LETTER || _la==DIGIT) {
				{
				{
				setState(74);
				_la = _input.LA(1);
				if ( !(_la==LETTER || _la==DIGIT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(79);
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

	public static class BodyContext extends ParserRuleContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public List<VardeclContext> vardecl() {
			return getRuleContexts(VardeclContext.class);
		}
		public VardeclContext vardecl(int i) {
			return getRuleContext(VardeclContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).exitBody(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(T__7);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(81);
				vardecl();
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
			statements();
			setState(88);
			match(T__8);
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

	public static class VardeclContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(simplParser.TYPE, 0); }
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public VardeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).enterVardecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).exitVardecl(this);
		}
	}

	public final VardeclContext vardecl() throws RecognitionException {
		VardeclContext _localctx = new VardeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_vardecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(TYPE);
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(91);
				match(T__6);
				}
			}

			setState(94);
			id();
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(95);
				match(T__3);
				setState(96);
				id();
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102);
			match(T__9);
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

	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statements);
		int _la;
		try {
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				match(T__10);
				}
				break;
			case T__11:
			case T__13:
			case T__18:
			case T__20:
			case T__21:
			case LETTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				statement();
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(106);
					match(T__9);
					setState(107);
					statement();
					}
					}
					setState(112);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class StatementContext extends ParserRuleContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public XifContext xif() {
			return getRuleContext(XifContext.class,0);
		}
		public InputContext input() {
			return getRuleContext(InputContext.class,0);
		}
		public OutputContext output() {
			return getRuleContext(OutputContext.class,0);
		}
		public XwhileContext xwhile() {
			return getRuleContext(XwhileContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		try {
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				assign();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				match(T__11);
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 3);
				{
				setState(117);
				xif();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 4);
				{
				setState(118);
				input();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 5);
				{
				setState(119);
				output();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 6);
				{
				setState(120);
				xwhile();
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

	public static class AssignContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SimpleContext simple() {
			return getRuleContext(SimpleContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).exitAssign(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			name();
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(124);
				match(T__12);
				setState(128);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__2:
				case T__25:
				case T__26:
				case T__27:
				case T__28:
				case LETTER:
				case DIGIT:
					{
					setState(125);
					expr();
					}
					break;
				case T__6:
					{
					setState(126);
					match(T__6);
					setState(127);
					simple();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
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

	public static class XifContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public XifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).enterXif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).exitXif(this);
		}
	}

	public final XifContext xif() throws RecognitionException {
		XifContext _localctx = new XifContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_xif);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(T__13);
			setState(133);
			expr();
			setState(134);
			match(T__14);
			setState(135);
			statements();
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15) {
				{
				{
				setState(136);
				match(T__15);
				setState(137);
				expr();
				setState(138);
				match(T__16);
				}
				}
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(145);
				match(T__17);
				setState(146);
				statements();
				}
			}

			setState(149);
			match(T__8);
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

	public static class XwhileContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public XwhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xwhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).enterXwhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).exitXwhile(this);
		}
	}

	public final XwhileContext xwhile() throws RecognitionException {
		XwhileContext _localctx = new XwhileContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_xwhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(T__18);
			setState(152);
			expr();
			setState(153);
			match(T__19);
			setState(154);
			statements();
			setState(155);
			match(T__8);
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

	public static class InputContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).enterInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).exitInput(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(T__20);
			setState(158);
			name();
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

	public static class OutputContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(simplParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(simplParser.STRING, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public OutputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_output; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).enterOutput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).exitOutput(this);
		}
	}

	public final OutputContext output() throws RecognitionException {
		OutputContext _localctx = new OutputContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_output);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(T__21);
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				{
				setState(161);
				match(STRING);
				}
				break;
			case T__2:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case LETTER:
			case DIGIT:
				{
				setState(162);
				expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__22) {
				{
				{
				setState(165);
				match(T__22);
				setState(168);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
					{
					setState(166);
					match(STRING);
					}
					break;
				case T__2:
				case T__25:
				case T__26:
				case T__27:
				case T__28:
				case LETTER:
				case DIGIT:
					{
					setState(167);
					expr();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(174);
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

	public static class NameContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public SimpleContext simple() {
			return getRuleContext(SimpleContext.class,0);
		}
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<TerminalNode> DIGIT() { return getTokens(simplParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(simplParser.DIGIT, i);
		}
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			id();
			setState(201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(176);
				match(T__23);
				setState(177);
				simple();
				setState(178);
				match(T__24);
				}
				break;
			case 2:
				{
				setState(180);
				match(T__2);
				setState(181);
				name();
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(182);
					match(T__3);
					setState(183);
					name();
					}
					}
					setState(188);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(189);
				match(T__4);
				}
				break;
			case 3:
				{
				setState(191);
				match(T__2);
				setState(192);
				match(DIGIT);
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(193);
					match(T__3);
					setState(194);
					match(DIGIT);
					}
					}
					setState(199);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(200);
				match(T__4);
				}
				break;
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

	public static class ExprContext extends ParserRuleContext {
		public List<SimpleContext> simple() {
			return getRuleContexts(SimpleContext.class);
		}
		public SimpleContext simple(int i) {
			return getRuleContext(SimpleContext.class,i);
		}
		public TerminalNode RELOP() { return getToken(simplParser.RELOP, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			simple();
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RELOP) {
				{
				setState(204);
				match(RELOP);
				setState(205);
				simple();
				}
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

	public static class SimpleContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> ADDOP() { return getTokens(simplParser.ADDOP); }
		public TerminalNode ADDOP(int i) {
			return getToken(simplParser.ADDOP, i);
		}
		public SimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).enterSimple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).exitSimple(this);
		}
	}

	public final SimpleContext simple() throws RecognitionException {
		SimpleContext _localctx = new SimpleContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_simple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(208);
				match(T__25);
				}
			}

			setState(211);
			term();
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADDOP) {
				{
				{
				setState(212);
				match(ADDOP);
				setState(213);
				term();
				}
				}
				setState(218);
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

	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> MULOP() { return getTokens(simplParser.MULOP); }
		public TerminalNode MULOP(int i) {
			return getToken(simplParser.MULOP, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			factor();
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULOP) {
				{
				{
				setState(220);
				match(MULOP);
				setState(221);
				factor();
				}
				}
				setState(226);
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

	public static class FactorContext extends ParserRuleContext {
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_factor);
		try {
			setState(237);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DIGIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(227);
				num();
				}
				break;
			case LETTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(228);
				name();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(229);
				match(T__2);
				setState(230);
				expr();
				setState(231);
				match(T__4);
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 4);
				{
				setState(233);
				match(T__26);
				setState(234);
				factor();
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 5);
				{
				setState(235);
				match(T__27);
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 6);
				{
				setState(236);
				match(T__28);
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

	public static class NumContext extends ParserRuleContext {
		public List<TerminalNode> DIGIT() { return getTokens(simplParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(simplParser.DIGIT, i);
		}
		public NumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).enterNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplListener ) ((simplListener)listener).exitNum(this);
		}
	}

	public final NumContext num() throws RecognitionException {
		NumContext _localctx = new NumContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_num);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(239);
				match(DIGIT);
				}
				}
				setState(242); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIGIT );
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u00f7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\7\2,\n\2\f\2\16\2/\13\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\7\39\n\3\f\3\16\3<\13\3\3\3\3\3\3\3\3\3\5\3B\n\3\3"+
		"\3\3\3\3\4\3\4\5\4H\n\4\3\4\3\4\3\5\3\5\7\5N\n\5\f\5\16\5Q\13\5\3\6\3"+
		"\6\7\6U\n\6\f\6\16\6X\13\6\3\6\3\6\3\6\3\7\3\7\5\7_\n\7\3\7\3\7\3\7\7"+
		"\7d\n\7\f\7\16\7g\13\7\3\7\3\7\3\b\3\b\3\b\3\b\7\bo\n\b\f\b\16\br\13\b"+
		"\5\bt\n\b\3\t\3\t\3\t\3\t\3\t\3\t\5\t|\n\t\3\n\3\n\3\n\3\n\3\n\5\n\u0083"+
		"\n\n\5\n\u0085\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u008f"+
		"\n\13\f\13\16\13\u0092\13\13\3\13\3\13\5\13\u0096\n\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\5\16\u00a6\n\16\3\16\3\16"+
		"\3\16\5\16\u00ab\n\16\7\16\u00ad\n\16\f\16\16\16\u00b0\13\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00bb\n\17\f\17\16\17\u00be\13"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00c6\n\17\f\17\16\17\u00c9\13"+
		"\17\3\17\5\17\u00cc\n\17\3\20\3\20\3\20\5\20\u00d1\n\20\3\21\5\21\u00d4"+
		"\n\21\3\21\3\21\3\21\7\21\u00d9\n\21\f\21\16\21\u00dc\13\21\3\22\3\22"+
		"\3\22\7\22\u00e1\n\22\f\22\16\22\u00e4\13\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\5\23\u00f0\n\23\3\24\6\24\u00f3\n\24\r\24\16"+
		"\24\u00f4\3\24\2\2\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\3"+
		"\3\2&\'\2\u0108\2(\3\2\2\2\4\62\3\2\2\2\6E\3\2\2\2\bK\3\2\2\2\nR\3\2\2"+
		"\2\f\\\3\2\2\2\16s\3\2\2\2\20{\3\2\2\2\22}\3\2\2\2\24\u0086\3\2\2\2\26"+
		"\u0099\3\2\2\2\30\u009f\3\2\2\2\32\u00a2\3\2\2\2\34\u00b1\3\2\2\2\36\u00cd"+
		"\3\2\2\2 \u00d3\3\2\2\2\"\u00dd\3\2\2\2$\u00ef\3\2\2\2&\u00f2\3\2\2\2"+
		"()\7\3\2\2)-\5\b\5\2*,\5\4\3\2+*\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2"+
		".\60\3\2\2\2/-\3\2\2\2\60\61\5\n\6\2\61\3\3\2\2\2\62\63\7\4\2\2\63\64"+
		"\5\b\5\2\64\65\7\5\2\2\65:\5\6\4\2\66\67\7\6\2\2\679\5\6\4\28\66\3\2\2"+
		"\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;=\3\2\2\2<:\3\2\2\2=A\7\7\2\2>?\7\b\2"+
		"\2?@\7 \2\2@B\5\b\5\2A>\3\2\2\2AB\3\2\2\2BC\3\2\2\2CD\5\n\6\2D\5\3\2\2"+
		"\2EG\7 \2\2FH\7\t\2\2GF\3\2\2\2GH\3\2\2\2HI\3\2\2\2IJ\5\b\5\2J\7\3\2\2"+
		"\2KO\7&\2\2LN\t\2\2\2ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2P\t\3\2\2"+
		"\2QO\3\2\2\2RV\7\n\2\2SU\5\f\7\2TS\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2"+
		"\2WY\3\2\2\2XV\3\2\2\2YZ\5\16\b\2Z[\7\13\2\2[\13\3\2\2\2\\^\7 \2\2]_\7"+
		"\t\2\2^]\3\2\2\2^_\3\2\2\2_`\3\2\2\2`e\5\b\5\2ab\7\6\2\2bd\5\b\5\2ca\3"+
		"\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fh\3\2\2\2ge\3\2\2\2hi\7\f\2\2i\r"+
		"\3\2\2\2jt\7\r\2\2kp\5\20\t\2lm\7\f\2\2mo\5\20\t\2nl\3\2\2\2or\3\2\2\2"+
		"pn\3\2\2\2pq\3\2\2\2qt\3\2\2\2rp\3\2\2\2sj\3\2\2\2sk\3\2\2\2t\17\3\2\2"+
		"\2u|\5\22\n\2v|\7\16\2\2w|\5\24\13\2x|\5\30\r\2y|\5\32\16\2z|\5\26\f\2"+
		"{u\3\2\2\2{v\3\2\2\2{w\3\2\2\2{x\3\2\2\2{y\3\2\2\2{z\3\2\2\2|\21\3\2\2"+
		"\2}\u0084\5\34\17\2~\u0082\7\17\2\2\177\u0083\5\36\20\2\u0080\u0081\7"+
		"\t\2\2\u0081\u0083\5 \21\2\u0082\177\3\2\2\2\u0082\u0080\3\2\2\2\u0083"+
		"\u0085\3\2\2\2\u0084~\3\2\2\2\u0084\u0085\3\2\2\2\u0085\23\3\2\2\2\u0086"+
		"\u0087\7\20\2\2\u0087\u0088\5\36\20\2\u0088\u0089\7\21\2\2\u0089\u0090"+
		"\5\16\b\2\u008a\u008b\7\22\2\2\u008b\u008c\5\36\20\2\u008c\u008d\7\23"+
		"\2\2\u008d\u008f\3\2\2\2\u008e\u008a\3\2\2\2\u008f\u0092\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0095\3\2\2\2\u0092\u0090\3\2"+
		"\2\2\u0093\u0094\7\24\2\2\u0094\u0096\5\16\b\2\u0095\u0093\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\7\13\2\2\u0098\25\3\2\2"+
		"\2\u0099\u009a\7\25\2\2\u009a\u009b\5\36\20\2\u009b\u009c\7\26\2\2\u009c"+
		"\u009d\5\16\b\2\u009d\u009e\7\13\2\2\u009e\27\3\2\2\2\u009f\u00a0\7\27"+
		"\2\2\u00a0\u00a1\5\34\17\2\u00a1\31\3\2\2\2\u00a2\u00a5\7\30\2\2\u00a3"+
		"\u00a6\7$\2\2\u00a4\u00a6\5\36\20\2\u00a5\u00a3\3\2\2\2\u00a5\u00a4\3"+
		"\2\2\2\u00a6\u00ae\3\2\2\2\u00a7\u00aa\7\31\2\2\u00a8\u00ab\7$\2\2\u00a9"+
		"\u00ab\5\36\20\2\u00aa\u00a8\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ad\3"+
		"\2\2\2\u00ac\u00a7\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae"+
		"\u00af\3\2\2\2\u00af\33\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00cb\5\b\5"+
		"\2\u00b2\u00b3\7\32\2\2\u00b3\u00b4\5 \21\2\u00b4\u00b5\7\33\2\2\u00b5"+
		"\u00cc\3\2\2\2\u00b6\u00b7\7\5\2\2\u00b7\u00bc\5\34\17\2\u00b8\u00b9\7"+
		"\6\2\2\u00b9\u00bb\5\34\17\2\u00ba\u00b8\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc"+
		"\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bf\3\2\2\2\u00be\u00bc\3\2"+
		"\2\2\u00bf\u00c0\7\7\2\2\u00c0\u00cc\3\2\2\2\u00c1\u00c2\7\5\2\2\u00c2"+
		"\u00c7\7\'\2\2\u00c3\u00c4\7\6\2\2\u00c4\u00c6\7\'\2\2\u00c5\u00c3\3\2"+
		"\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8"+
		"\u00ca\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cc\7\7\2\2\u00cb\u00b2\3\2"+
		"\2\2\u00cb\u00b6\3\2\2\2\u00cb\u00c1\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"\35\3\2\2\2\u00cd\u00d0\5 \21\2\u00ce\u00cf\7!\2\2\u00cf\u00d1\5 \21\2"+
		"\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\37\3\2\2\2\u00d2\u00d4"+
		"\7\34\2\2\u00d3\u00d2\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2"+
		"\u00d5\u00da\5\"\22\2\u00d6\u00d7\7#\2\2\u00d7\u00d9\5\"\22\2\u00d8\u00d6"+
		"\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db"+
		"!\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00e2\5$\23\2\u00de\u00df\7\"\2\2"+
		"\u00df\u00e1\5$\23\2\u00e0\u00de\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0"+
		"\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3#\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5"+
		"\u00f0\5&\24\2\u00e6\u00f0\5\34\17\2\u00e7\u00e8\7\5\2\2\u00e8\u00e9\5"+
		"\36\20\2\u00e9\u00ea\7\7\2\2\u00ea\u00f0\3\2\2\2\u00eb\u00ec\7\35\2\2"+
		"\u00ec\u00f0\5$\23\2\u00ed\u00f0\7\36\2\2\u00ee\u00f0\7\37\2\2\u00ef\u00e5"+
		"\3\2\2\2\u00ef\u00e6\3\2\2\2\u00ef\u00e7\3\2\2\2\u00ef\u00eb\3\2\2\2\u00ef"+
		"\u00ed\3\2\2\2\u00ef\u00ee\3\2\2\2\u00f0%\3\2\2\2\u00f1\u00f3\7\'\2\2"+
		"\u00f2\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5"+
		"\3\2\2\2\u00f5\'\3\2\2\2\35-:AGOV^eps{\u0082\u0084\u0090\u0095\u00a5\u00aa"+
		"\u00ae\u00bc\u00c7\u00cb\u00d0\u00d3\u00da\u00e2\u00ef\u00f4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}