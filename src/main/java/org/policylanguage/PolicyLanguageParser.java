// Generated from /Users/gertibushati/Desktop/Extended_Policy_Specification/src/main/resources/PolicyLanguage.g4 by ANTLR 4.10.1
package org.policylanguage;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PolicyLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, SHIP=2, AS_AGGREGATES=3, FROM=4, TO=5, WHERE=6, AND=7, OR=8, GROUP_BY=9, 
		EXCEPT=10, ASTERISK=11, PARAMETER=12, TEXT=13, NUMBER=14, OPERATOR=15, 
		WHITESPACE=16, NEWLINE=17, TAB=18;
	public static final int
		RULE_policy_expression = 0, RULE_positive_policy = 1, RULE_ship = 2, RULE_ship_attribute = 3, 
		RULE_as_aggregates = 4, RULE_aggr_func = 5, RULE_from = 6, RULE_table = 7, 
		RULE_to = 8, RULE_location = 9, RULE_where = 10, RULE_operator = 11, RULE_operand = 12, 
		RULE_group_by = 13, RULE_negative_policy = 14, RULE_except = 15, RULE_except_attribute = 16, 
		RULE_except_as_aggregates = 17, RULE_except_to = 18, RULE_except_where = 19, 
		RULE_except_group_by = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"policy_expression", "positive_policy", "ship", "ship_attribute", "as_aggregates", 
			"aggr_func", "from", "table", "to", "location", "where", "operator", 
			"operand", "group_by", "negative_policy", "except", "except_attribute", 
			"except_as_aggregates", "except_to", "except_where", "except_group_by"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", null, null, null, null, null, null, null, null, null, "'*'", 
			null, null, null, null, "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "SHIP", "AS_AGGREGATES", "FROM", "TO", "WHERE", "AND", "OR", 
			"GROUP_BY", "EXCEPT", "ASTERISK", "PARAMETER", "TEXT", "NUMBER", "OPERATOR", 
			"WHITESPACE", "NEWLINE", "TAB"
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
	public String getGrammarFileName() { return "PolicyLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PolicyLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class Policy_expressionContext extends ParserRuleContext {
		public Positive_policyContext positive_policy() {
			return getRuleContext(Positive_policyContext.class,0);
		}
		public List<Negative_policyContext> negative_policy() {
			return getRuleContexts(Negative_policyContext.class);
		}
		public Negative_policyContext negative_policy(int i) {
			return getRuleContext(Negative_policyContext.class,i);
		}
		public Policy_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_policy_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).enterPolicy_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).exitPolicy_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyLanguageVisitor ) return ((PolicyLanguageVisitor<? extends T>)visitor).visitPolicy_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Policy_expressionContext policy_expression() throws RecognitionException {
		Policy_expressionContext _localctx = new Policy_expressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_policy_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			positive_policy();
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXCEPT) {
				{
				{
				setState(43);
				negative_policy();
				}
				}
				setState(48);
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

	public static class Positive_policyContext extends ParserRuleContext {
		public ShipContext ship() {
			return getRuleContext(ShipContext.class,0);
		}
		public FromContext from() {
			return getRuleContext(FromContext.class,0);
		}
		public ToContext to() {
			return getRuleContext(ToContext.class,0);
		}
		public As_aggregatesContext as_aggregates() {
			return getRuleContext(As_aggregatesContext.class,0);
		}
		public WhereContext where() {
			return getRuleContext(WhereContext.class,0);
		}
		public Group_byContext group_by() {
			return getRuleContext(Group_byContext.class,0);
		}
		public Positive_policyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_positive_policy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).enterPositive_policy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).exitPositive_policy(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyLanguageVisitor ) return ((PolicyLanguageVisitor<? extends T>)visitor).visitPositive_policy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Positive_policyContext positive_policy() throws RecognitionException {
		Positive_policyContext _localctx = new Positive_policyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_positive_policy);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			ship();
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS_AGGREGATES) {
				{
				setState(50);
				as_aggregates();
				}
			}

			setState(53);
			from();
			setState(54);
			to();
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(55);
				where();
				}
			}

			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==GROUP_BY) {
				{
				setState(58);
				group_by();
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

	public static class ShipContext extends ParserRuleContext {
		public TerminalNode SHIP() { return getToken(PolicyLanguageParser.SHIP, 0); }
		public TerminalNode ASTERISK() { return getToken(PolicyLanguageParser.ASTERISK, 0); }
		public List<Ship_attributeContext> ship_attribute() {
			return getRuleContexts(Ship_attributeContext.class);
		}
		public Ship_attributeContext ship_attribute(int i) {
			return getRuleContext(Ship_attributeContext.class,i);
		}
		public ShipContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ship; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).enterShip(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).exitShip(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyLanguageVisitor ) return ((PolicyLanguageVisitor<? extends T>)visitor).visitShip(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShipContext ship() throws RecognitionException {
		ShipContext _localctx = new ShipContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_ship);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(SHIP);
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASTERISK:
				{
				setState(62);
				match(ASTERISK);
				}
				break;
			case PARAMETER:
				{
				setState(63);
				ship_attribute();
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(64);
					match(T__0);
					setState(65);
					ship_attribute();
					}
					}
					setState(70);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Ship_attributeContext extends ParserRuleContext {
		public TerminalNode PARAMETER() { return getToken(PolicyLanguageParser.PARAMETER, 0); }
		public Ship_attributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ship_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).enterShip_attribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).exitShip_attribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyLanguageVisitor ) return ((PolicyLanguageVisitor<? extends T>)visitor).visitShip_attribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ship_attributeContext ship_attribute() throws RecognitionException {
		Ship_attributeContext _localctx = new Ship_attributeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ship_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(PARAMETER);
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

	public static class As_aggregatesContext extends ParserRuleContext {
		public TerminalNode AS_AGGREGATES() { return getToken(PolicyLanguageParser.AS_AGGREGATES, 0); }
		public List<Aggr_funcContext> aggr_func() {
			return getRuleContexts(Aggr_funcContext.class);
		}
		public Aggr_funcContext aggr_func(int i) {
			return getRuleContext(Aggr_funcContext.class,i);
		}
		public As_aggregatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_as_aggregates; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).enterAs_aggregates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).exitAs_aggregates(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyLanguageVisitor ) return ((PolicyLanguageVisitor<? extends T>)visitor).visitAs_aggregates(this);
			else return visitor.visitChildren(this);
		}
	}

	public final As_aggregatesContext as_aggregates() throws RecognitionException {
		As_aggregatesContext _localctx = new As_aggregatesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_as_aggregates);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(AS_AGGREGATES);
			setState(76);
			aggr_func();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(77);
				match(T__0);
				setState(78);
				aggr_func();
				}
				}
				setState(83);
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

	public static class Aggr_funcContext extends ParserRuleContext {
		public TerminalNode PARAMETER() { return getToken(PolicyLanguageParser.PARAMETER, 0); }
		public Aggr_funcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggr_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).enterAggr_func(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).exitAggr_func(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyLanguageVisitor ) return ((PolicyLanguageVisitor<? extends T>)visitor).visitAggr_func(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Aggr_funcContext aggr_func() throws RecognitionException {
		Aggr_funcContext _localctx = new Aggr_funcContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_aggr_func);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(PARAMETER);
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

	public static class FromContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(PolicyLanguageParser.FROM, 0); }
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public FromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_from; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).enterFrom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).exitFrom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyLanguageVisitor ) return ((PolicyLanguageVisitor<? extends T>)visitor).visitFrom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FromContext from() throws RecognitionException {
		FromContext _localctx = new FromContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_from);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(FROM);
			setState(87);
			table();
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

	public static class TableContext extends ParserRuleContext {
		public TerminalNode PARAMETER() { return getToken(PolicyLanguageParser.PARAMETER, 0); }
		public TableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).enterTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).exitTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyLanguageVisitor ) return ((PolicyLanguageVisitor<? extends T>)visitor).visitTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableContext table() throws RecognitionException {
		TableContext _localctx = new TableContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(PARAMETER);
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

	public static class ToContext extends ParserRuleContext {
		public TerminalNode TO() { return getToken(PolicyLanguageParser.TO, 0); }
		public TerminalNode ASTERISK() { return getToken(PolicyLanguageParser.ASTERISK, 0); }
		public List<LocationContext> location() {
			return getRuleContexts(LocationContext.class);
		}
		public LocationContext location(int i) {
			return getRuleContext(LocationContext.class,i);
		}
		public ToContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_to; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).enterTo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).exitTo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyLanguageVisitor ) return ((PolicyLanguageVisitor<? extends T>)visitor).visitTo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ToContext to() throws RecognitionException {
		ToContext _localctx = new ToContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_to);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(TO);
			setState(101);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASTERISK:
				{
				setState(92);
				match(ASTERISK);
				}
				break;
			case PARAMETER:
				{
				setState(93);
				location();
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(94);
					match(T__0);
					setState(95);
					location();
					}
					}
					setState(100);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class LocationContext extends ParserRuleContext {
		public TerminalNode PARAMETER() { return getToken(PolicyLanguageParser.PARAMETER, 0); }
		public LocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_location; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).enterLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).exitLocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyLanguageVisitor ) return ((PolicyLanguageVisitor<? extends T>)visitor).visitLocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocationContext location() throws RecognitionException {
		LocationContext _localctx = new LocationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_location);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(PARAMETER);
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

	public static class WhereContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(PolicyLanguageParser.WHERE, 0); }
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public List<OperatorContext> operator() {
			return getRuleContexts(OperatorContext.class);
		}
		public OperatorContext operator(int i) {
			return getRuleContext(OperatorContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(PolicyLanguageParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(PolicyLanguageParser.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(PolicyLanguageParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(PolicyLanguageParser.OR, i);
		}
		public WhereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).enterWhere(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).exitWhere(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyLanguageVisitor ) return ((PolicyLanguageVisitor<? extends T>)visitor).visitWhere(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereContext where() throws RecognitionException {
		WhereContext _localctx = new WhereContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_where);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(WHERE);
			setState(106);
			operand();
			setState(107);
			operator();
			setState(108);
			operand();
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==OR) {
				{
				{
				setState(109);
				_la = _input.LA(1);
				if ( !(_la==AND || _la==OR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(110);
				operand();
				setState(111);
				operator();
				setState(112);
				operand();
				}
				}
				setState(118);
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

	public static class OperatorContext extends ParserRuleContext {
		public TerminalNode OPERATOR() { return getToken(PolicyLanguageParser.OPERATOR, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).exitOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyLanguageVisitor ) return ((PolicyLanguageVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_operator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(OPERATOR);
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

	public static class OperandContext extends ParserRuleContext {
		public TerminalNode PARAMETER() { return getToken(PolicyLanguageParser.PARAMETER, 0); }
		public TerminalNode TEXT() { return getToken(PolicyLanguageParser.TEXT, 0); }
		public TerminalNode NUMBER() { return getToken(PolicyLanguageParser.NUMBER, 0); }
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).enterOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).exitOperand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyLanguageVisitor ) return ((PolicyLanguageVisitor<? extends T>)visitor).visitOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_operand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PARAMETER) | (1L << TEXT) | (1L << NUMBER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Group_byContext extends ParserRuleContext {
		public TerminalNode GROUP_BY() { return getToken(PolicyLanguageParser.GROUP_BY, 0); }
		public TerminalNode ASTERISK() { return getToken(PolicyLanguageParser.ASTERISK, 0); }
		public List<Ship_attributeContext> ship_attribute() {
			return getRuleContexts(Ship_attributeContext.class);
		}
		public Ship_attributeContext ship_attribute(int i) {
			return getRuleContext(Ship_attributeContext.class,i);
		}
		public Group_byContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group_by; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).enterGroup_by(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).exitGroup_by(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyLanguageVisitor ) return ((PolicyLanguageVisitor<? extends T>)visitor).visitGroup_by(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Group_byContext group_by() throws RecognitionException {
		Group_byContext _localctx = new Group_byContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_group_by);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(GROUP_BY);
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASTERISK:
				{
				setState(124);
				match(ASTERISK);
				}
				break;
			case PARAMETER:
				{
				setState(125);
				ship_attribute();
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(126);
					match(T__0);
					setState(127);
					ship_attribute();
					}
					}
					setState(132);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Negative_policyContext extends ParserRuleContext {
		public ExceptContext except() {
			return getRuleContext(ExceptContext.class,0);
		}
		public Except_toContext except_to() {
			return getRuleContext(Except_toContext.class,0);
		}
		public Except_as_aggregatesContext except_as_aggregates() {
			return getRuleContext(Except_as_aggregatesContext.class,0);
		}
		public Except_whereContext except_where() {
			return getRuleContext(Except_whereContext.class,0);
		}
		public Except_group_byContext except_group_by() {
			return getRuleContext(Except_group_byContext.class,0);
		}
		public Negative_policyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negative_policy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).enterNegative_policy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).exitNegative_policy(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyLanguageVisitor ) return ((PolicyLanguageVisitor<? extends T>)visitor).visitNegative_policy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Negative_policyContext negative_policy() throws RecognitionException {
		Negative_policyContext _localctx = new Negative_policyContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_negative_policy);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			except();
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS_AGGREGATES) {
				{
				setState(136);
				except_as_aggregates();
				}
			}

			setState(139);
			except_to();
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(140);
				except_where();
				}
			}

			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==GROUP_BY) {
				{
				setState(143);
				except_group_by();
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

	public static class ExceptContext extends ParserRuleContext {
		public TerminalNode EXCEPT() { return getToken(PolicyLanguageParser.EXCEPT, 0); }
		public TerminalNode ASTERISK() { return getToken(PolicyLanguageParser.ASTERISK, 0); }
		public List<Except_attributeContext> except_attribute() {
			return getRuleContexts(Except_attributeContext.class);
		}
		public Except_attributeContext except_attribute(int i) {
			return getRuleContext(Except_attributeContext.class,i);
		}
		public ExceptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_except; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).enterExcept(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).exitExcept(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyLanguageVisitor ) return ((PolicyLanguageVisitor<? extends T>)visitor).visitExcept(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExceptContext except() throws RecognitionException {
		ExceptContext _localctx = new ExceptContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_except);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(EXCEPT);
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASTERISK:
				{
				setState(147);
				match(ASTERISK);
				}
				break;
			case PARAMETER:
				{
				setState(148);
				except_attribute();
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(149);
					match(T__0);
					setState(150);
					except_attribute();
					}
					}
					setState(155);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Except_attributeContext extends ParserRuleContext {
		public TerminalNode PARAMETER() { return getToken(PolicyLanguageParser.PARAMETER, 0); }
		public Except_attributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_except_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).enterExcept_attribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).exitExcept_attribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyLanguageVisitor ) return ((PolicyLanguageVisitor<? extends T>)visitor).visitExcept_attribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Except_attributeContext except_attribute() throws RecognitionException {
		Except_attributeContext _localctx = new Except_attributeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_except_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(PARAMETER);
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

	public static class Except_as_aggregatesContext extends ParserRuleContext {
		public TerminalNode AS_AGGREGATES() { return getToken(PolicyLanguageParser.AS_AGGREGATES, 0); }
		public List<Aggr_funcContext> aggr_func() {
			return getRuleContexts(Aggr_funcContext.class);
		}
		public Aggr_funcContext aggr_func(int i) {
			return getRuleContext(Aggr_funcContext.class,i);
		}
		public Except_as_aggregatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_except_as_aggregates; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).enterExcept_as_aggregates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).exitExcept_as_aggregates(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyLanguageVisitor ) return ((PolicyLanguageVisitor<? extends T>)visitor).visitExcept_as_aggregates(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Except_as_aggregatesContext except_as_aggregates() throws RecognitionException {
		Except_as_aggregatesContext _localctx = new Except_as_aggregatesContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_except_as_aggregates);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(AS_AGGREGATES);
			setState(161);
			aggr_func();
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(162);
				match(T__0);
				setState(163);
				aggr_func();
				}
				}
				setState(168);
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

	public static class Except_toContext extends ParserRuleContext {
		public TerminalNode TO() { return getToken(PolicyLanguageParser.TO, 0); }
		public TerminalNode ASTERISK() { return getToken(PolicyLanguageParser.ASTERISK, 0); }
		public List<LocationContext> location() {
			return getRuleContexts(LocationContext.class);
		}
		public LocationContext location(int i) {
			return getRuleContext(LocationContext.class,i);
		}
		public Except_toContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_except_to; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).enterExcept_to(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).exitExcept_to(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyLanguageVisitor ) return ((PolicyLanguageVisitor<? extends T>)visitor).visitExcept_to(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Except_toContext except_to() throws RecognitionException {
		Except_toContext _localctx = new Except_toContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_except_to);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(TO);
			setState(179);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASTERISK:
				{
				setState(170);
				match(ASTERISK);
				}
				break;
			case PARAMETER:
				{
				setState(171);
				location();
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(172);
					match(T__0);
					setState(173);
					location();
					}
					}
					setState(178);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Except_whereContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(PolicyLanguageParser.WHERE, 0); }
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public List<OperatorContext> operator() {
			return getRuleContexts(OperatorContext.class);
		}
		public OperatorContext operator(int i) {
			return getRuleContext(OperatorContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(PolicyLanguageParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(PolicyLanguageParser.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(PolicyLanguageParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(PolicyLanguageParser.OR, i);
		}
		public Except_whereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_except_where; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).enterExcept_where(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).exitExcept_where(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyLanguageVisitor ) return ((PolicyLanguageVisitor<? extends T>)visitor).visitExcept_where(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Except_whereContext except_where() throws RecognitionException {
		Except_whereContext _localctx = new Except_whereContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_except_where);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(WHERE);
			setState(182);
			operand();
			setState(183);
			operator();
			setState(184);
			operand();
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==OR) {
				{
				{
				setState(185);
				_la = _input.LA(1);
				if ( !(_la==AND || _la==OR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(186);
				operand();
				setState(187);
				operator();
				setState(188);
				operand();
				}
				}
				setState(194);
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

	public static class Except_group_byContext extends ParserRuleContext {
		public TerminalNode GROUP_BY() { return getToken(PolicyLanguageParser.GROUP_BY, 0); }
		public List<Except_attributeContext> except_attribute() {
			return getRuleContexts(Except_attributeContext.class);
		}
		public Except_attributeContext except_attribute(int i) {
			return getRuleContext(Except_attributeContext.class,i);
		}
		public Except_group_byContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_except_group_by; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).enterExcept_group_by(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyLanguageListener ) ((PolicyLanguageListener)listener).exitExcept_group_by(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyLanguageVisitor ) return ((PolicyLanguageVisitor<? extends T>)visitor).visitExcept_group_by(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Except_group_byContext except_group_by() throws RecognitionException {
		Except_group_byContext _localctx = new Except_group_byContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_except_group_by);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(GROUP_BY);
			{
			setState(196);
			except_attribute();
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(197);
				match(T__0);
				setState(198);
				except_attribute();
				}
				}
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0012\u00cd\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0001\u0000\u0001"+
		"\u0000\u0005\u0000-\b\u0000\n\u0000\f\u00000\t\u0000\u0001\u0001\u0001"+
		"\u0001\u0003\u00014\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u00019\b\u0001\u0001\u0001\u0003\u0001<\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002C\b\u0002\n\u0002\f\u0002"+
		"F\t\u0002\u0003\u0002H\b\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004P\b\u0004\n\u0004\f\u0004S\t"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\ba\b"+
		"\b\n\b\f\bd\t\b\u0003\bf\b\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\ns\b\n\n\n\f\nv\t\n\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0005\r\u0081\b\r\n\r\f\r\u0084\t\r\u0003\r\u0086\b\r\u0001\u000e\u0001"+
		"\u000e\u0003\u000e\u008a\b\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u008e"+
		"\b\u000e\u0001\u000e\u0003\u000e\u0091\b\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0098\b\u000f\n\u000f"+
		"\f\u000f\u009b\t\u000f\u0003\u000f\u009d\b\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00a5\b\u0011"+
		"\n\u0011\f\u0011\u00a8\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0005\u0012\u00af\b\u0012\n\u0012\f\u0012\u00b2\t\u0012"+
		"\u0003\u0012\u00b4\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013"+
		"\u00bf\b\u0013\n\u0013\f\u0013\u00c2\t\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0005\u0014\u00c8\b\u0014\n\u0014\f\u0014\u00cb\t\u0014"+
		"\u0001\u0014\u0000\u0000\u0015\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(\u0000\u0002\u0001\u0000"+
		"\u0007\b\u0001\u0000\f\u000e\u00cd\u0000*\u0001\u0000\u0000\u0000\u0002"+
		"1\u0001\u0000\u0000\u0000\u0004=\u0001\u0000\u0000\u0000\u0006I\u0001"+
		"\u0000\u0000\u0000\bK\u0001\u0000\u0000\u0000\nT\u0001\u0000\u0000\u0000"+
		"\fV\u0001\u0000\u0000\u0000\u000eY\u0001\u0000\u0000\u0000\u0010[\u0001"+
		"\u0000\u0000\u0000\u0012g\u0001\u0000\u0000\u0000\u0014i\u0001\u0000\u0000"+
		"\u0000\u0016w\u0001\u0000\u0000\u0000\u0018y\u0001\u0000\u0000\u0000\u001a"+
		"{\u0001\u0000\u0000\u0000\u001c\u0087\u0001\u0000\u0000\u0000\u001e\u0092"+
		"\u0001\u0000\u0000\u0000 \u009e\u0001\u0000\u0000\u0000\"\u00a0\u0001"+
		"\u0000\u0000\u0000$\u00a9\u0001\u0000\u0000\u0000&\u00b5\u0001\u0000\u0000"+
		"\u0000(\u00c3\u0001\u0000\u0000\u0000*.\u0003\u0002\u0001\u0000+-\u0003"+
		"\u001c\u000e\u0000,+\u0001\u0000\u0000\u0000-0\u0001\u0000\u0000\u0000"+
		".,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/\u0001\u0001\u0000"+
		"\u0000\u00000.\u0001\u0000\u0000\u000013\u0003\u0004\u0002\u000024\u0003"+
		"\b\u0004\u000032\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u000045\u0001"+
		"\u0000\u0000\u000056\u0003\f\u0006\u000068\u0003\u0010\b\u000079\u0003"+
		"\u0014\n\u000087\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u00009;\u0001"+
		"\u0000\u0000\u0000:<\u0003\u001a\r\u0000;:\u0001\u0000\u0000\u0000;<\u0001"+
		"\u0000\u0000\u0000<\u0003\u0001\u0000\u0000\u0000=G\u0005\u0002\u0000"+
		"\u0000>H\u0005\u000b\u0000\u0000?D\u0003\u0006\u0003\u0000@A\u0005\u0001"+
		"\u0000\u0000AC\u0003\u0006\u0003\u0000B@\u0001\u0000\u0000\u0000CF\u0001"+
		"\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000"+
		"EH\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000G>\u0001\u0000\u0000"+
		"\u0000G?\u0001\u0000\u0000\u0000H\u0005\u0001\u0000\u0000\u0000IJ\u0005"+
		"\f\u0000\u0000J\u0007\u0001\u0000\u0000\u0000KL\u0005\u0003\u0000\u0000"+
		"LQ\u0003\n\u0005\u0000MN\u0005\u0001\u0000\u0000NP\u0003\n\u0005\u0000"+
		"OM\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000"+
		"\u0000QR\u0001\u0000\u0000\u0000R\t\u0001\u0000\u0000\u0000SQ\u0001\u0000"+
		"\u0000\u0000TU\u0005\f\u0000\u0000U\u000b\u0001\u0000\u0000\u0000VW\u0005"+
		"\u0004\u0000\u0000WX\u0003\u000e\u0007\u0000X\r\u0001\u0000\u0000\u0000"+
		"YZ\u0005\f\u0000\u0000Z\u000f\u0001\u0000\u0000\u0000[e\u0005\u0005\u0000"+
		"\u0000\\f\u0005\u000b\u0000\u0000]b\u0003\u0012\t\u0000^_\u0005\u0001"+
		"\u0000\u0000_a\u0003\u0012\t\u0000`^\u0001\u0000\u0000\u0000ad\u0001\u0000"+
		"\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000cf\u0001"+
		"\u0000\u0000\u0000db\u0001\u0000\u0000\u0000e\\\u0001\u0000\u0000\u0000"+
		"e]\u0001\u0000\u0000\u0000f\u0011\u0001\u0000\u0000\u0000gh\u0005\f\u0000"+
		"\u0000h\u0013\u0001\u0000\u0000\u0000ij\u0005\u0006\u0000\u0000jk\u0003"+
		"\u0018\f\u0000kl\u0003\u0016\u000b\u0000lt\u0003\u0018\f\u0000mn\u0007"+
		"\u0000\u0000\u0000no\u0003\u0018\f\u0000op\u0003\u0016\u000b\u0000pq\u0003"+
		"\u0018\f\u0000qs\u0001\u0000\u0000\u0000rm\u0001\u0000\u0000\u0000sv\u0001"+
		"\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000"+
		"u\u0015\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000wx\u0005\u000f"+
		"\u0000\u0000x\u0017\u0001\u0000\u0000\u0000yz\u0007\u0001\u0000\u0000"+
		"z\u0019\u0001\u0000\u0000\u0000{\u0085\u0005\t\u0000\u0000|\u0086\u0005"+
		"\u000b\u0000\u0000}\u0082\u0003\u0006\u0003\u0000~\u007f\u0005\u0001\u0000"+
		"\u0000\u007f\u0081\u0003\u0006\u0003\u0000\u0080~\u0001\u0000\u0000\u0000"+
		"\u0081\u0084\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000"+
		"\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0086\u0001\u0000\u0000\u0000"+
		"\u0084\u0082\u0001\u0000\u0000\u0000\u0085|\u0001\u0000\u0000\u0000\u0085"+
		"}\u0001\u0000\u0000\u0000\u0086\u001b\u0001\u0000\u0000\u0000\u0087\u0089"+
		"\u0003\u001e\u000f\u0000\u0088\u008a\u0003\"\u0011\u0000\u0089\u0088\u0001"+
		"\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u008b\u0001"+
		"\u0000\u0000\u0000\u008b\u008d\u0003$\u0012\u0000\u008c\u008e\u0003&\u0013"+
		"\u0000\u008d\u008c\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000"+
		"\u0000\u008e\u0090\u0001\u0000\u0000\u0000\u008f\u0091\u0003(\u0014\u0000"+
		"\u0090\u008f\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000"+
		"\u0091\u001d\u0001\u0000\u0000\u0000\u0092\u009c\u0005\n\u0000\u0000\u0093"+
		"\u009d\u0005\u000b\u0000\u0000\u0094\u0099\u0003 \u0010\u0000\u0095\u0096"+
		"\u0005\u0001\u0000\u0000\u0096\u0098\u0003 \u0010\u0000\u0097\u0095\u0001"+
		"\u0000\u0000\u0000\u0098\u009b\u0001\u0000\u0000\u0000\u0099\u0097\u0001"+
		"\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009d\u0001"+
		"\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009c\u0093\u0001"+
		"\u0000\u0000\u0000\u009c\u0094\u0001\u0000\u0000\u0000\u009d\u001f\u0001"+
		"\u0000\u0000\u0000\u009e\u009f\u0005\f\u0000\u0000\u009f!\u0001\u0000"+
		"\u0000\u0000\u00a0\u00a1\u0005\u0003\u0000\u0000\u00a1\u00a6\u0003\n\u0005"+
		"\u0000\u00a2\u00a3\u0005\u0001\u0000\u0000\u00a3\u00a5\u0003\n\u0005\u0000"+
		"\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a8\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a7#\u0001\u0000\u0000\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a9"+
		"\u00b3\u0005\u0005\u0000\u0000\u00aa\u00b4\u0005\u000b\u0000\u0000\u00ab"+
		"\u00b0\u0003\u0012\t\u0000\u00ac\u00ad\u0005\u0001\u0000\u0000\u00ad\u00af"+
		"\u0003\u0012\t\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00af\u00b2\u0001"+
		"\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001"+
		"\u0000\u0000\u0000\u00b1\u00b4\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001"+
		"\u0000\u0000\u0000\u00b3\u00aa\u0001\u0000\u0000\u0000\u00b3\u00ab\u0001"+
		"\u0000\u0000\u0000\u00b4%\u0001\u0000\u0000\u0000\u00b5\u00b6\u0005\u0006"+
		"\u0000\u0000\u00b6\u00b7\u0003\u0018\f\u0000\u00b7\u00b8\u0003\u0016\u000b"+
		"\u0000\u00b8\u00c0\u0003\u0018\f\u0000\u00b9\u00ba\u0007\u0000\u0000\u0000"+
		"\u00ba\u00bb\u0003\u0018\f\u0000\u00bb\u00bc\u0003\u0016\u000b\u0000\u00bc"+
		"\u00bd\u0003\u0018\f\u0000\u00bd\u00bf\u0001\u0000\u0000\u0000\u00be\u00b9"+
		"\u0001\u0000\u0000\u0000\u00bf\u00c2\u0001\u0000\u0000\u0000\u00c0\u00be"+
		"\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1\'\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c3\u00c4\u0005"+
		"\t\u0000\u0000\u00c4\u00c9\u0003 \u0010\u0000\u00c5\u00c6\u0005\u0001"+
		"\u0000\u0000\u00c6\u00c8\u0003 \u0010\u0000\u00c7\u00c5\u0001\u0000\u0000"+
		"\u0000\u00c8\u00cb\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000"+
		"\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca)\u0001\u0000\u0000\u0000"+
		"\u00cb\u00c9\u0001\u0000\u0000\u0000\u0016.38;DGQbet\u0082\u0085\u0089"+
		"\u008d\u0090\u0099\u009c\u00a6\u00b0\u00b3\u00c0\u00c9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}