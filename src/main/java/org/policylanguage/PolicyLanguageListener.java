// Generated from /Users/gertibushati/Desktop/Extended_Policy_Specification/src/main/resources/PolicyLanguage.g4 by ANTLR 4.10.1
package org.policylanguage;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PolicyLanguageParser}.
 */
public interface PolicyLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PolicyLanguageParser#policy_expression}.
	 * @param ctx the parse tree
	 */
	void enterPolicy_expression(PolicyLanguageParser.Policy_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyLanguageParser#policy_expression}.
	 * @param ctx the parse tree
	 */
	void exitPolicy_expression(PolicyLanguageParser.Policy_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolicyLanguageParser#positive_policy}.
	 * @param ctx the parse tree
	 */
	void enterPositive_policy(PolicyLanguageParser.Positive_policyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyLanguageParser#positive_policy}.
	 * @param ctx the parse tree
	 */
	void exitPositive_policy(PolicyLanguageParser.Positive_policyContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolicyLanguageParser#ship}.
	 * @param ctx the parse tree
	 */
	void enterShip(PolicyLanguageParser.ShipContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyLanguageParser#ship}.
	 * @param ctx the parse tree
	 */
	void exitShip(PolicyLanguageParser.ShipContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolicyLanguageParser#ship_attribute}.
	 * @param ctx the parse tree
	 */
	void enterShip_attribute(PolicyLanguageParser.Ship_attributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyLanguageParser#ship_attribute}.
	 * @param ctx the parse tree
	 */
	void exitShip_attribute(PolicyLanguageParser.Ship_attributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolicyLanguageParser#as_aggregates}.
	 * @param ctx the parse tree
	 */
	void enterAs_aggregates(PolicyLanguageParser.As_aggregatesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyLanguageParser#as_aggregates}.
	 * @param ctx the parse tree
	 */
	void exitAs_aggregates(PolicyLanguageParser.As_aggregatesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolicyLanguageParser#aggr_func}.
	 * @param ctx the parse tree
	 */
	void enterAggr_func(PolicyLanguageParser.Aggr_funcContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyLanguageParser#aggr_func}.
	 * @param ctx the parse tree
	 */
	void exitAggr_func(PolicyLanguageParser.Aggr_funcContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolicyLanguageParser#from}.
	 * @param ctx the parse tree
	 */
	void enterFrom(PolicyLanguageParser.FromContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyLanguageParser#from}.
	 * @param ctx the parse tree
	 */
	void exitFrom(PolicyLanguageParser.FromContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolicyLanguageParser#table}.
	 * @param ctx the parse tree
	 */
	void enterTable(PolicyLanguageParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyLanguageParser#table}.
	 * @param ctx the parse tree
	 */
	void exitTable(PolicyLanguageParser.TableContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolicyLanguageParser#to}.
	 * @param ctx the parse tree
	 */
	void enterTo(PolicyLanguageParser.ToContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyLanguageParser#to}.
	 * @param ctx the parse tree
	 */
	void exitTo(PolicyLanguageParser.ToContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolicyLanguageParser#location}.
	 * @param ctx the parse tree
	 */
	void enterLocation(PolicyLanguageParser.LocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyLanguageParser#location}.
	 * @param ctx the parse tree
	 */
	void exitLocation(PolicyLanguageParser.LocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolicyLanguageParser#where}.
	 * @param ctx the parse tree
	 */
	void enterWhere(PolicyLanguageParser.WhereContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyLanguageParser#where}.
	 * @param ctx the parse tree
	 */
	void exitWhere(PolicyLanguageParser.WhereContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolicyLanguageParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(PolicyLanguageParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyLanguageParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(PolicyLanguageParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolicyLanguageParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(PolicyLanguageParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyLanguageParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(PolicyLanguageParser.OperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolicyLanguageParser#group_by}.
	 * @param ctx the parse tree
	 */
	void enterGroup_by(PolicyLanguageParser.Group_byContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyLanguageParser#group_by}.
	 * @param ctx the parse tree
	 */
	void exitGroup_by(PolicyLanguageParser.Group_byContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolicyLanguageParser#negative_policy}.
	 * @param ctx the parse tree
	 */
	void enterNegative_policy(PolicyLanguageParser.Negative_policyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyLanguageParser#negative_policy}.
	 * @param ctx the parse tree
	 */
	void exitNegative_policy(PolicyLanguageParser.Negative_policyContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolicyLanguageParser#except}.
	 * @param ctx the parse tree
	 */
	void enterExcept(PolicyLanguageParser.ExceptContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyLanguageParser#except}.
	 * @param ctx the parse tree
	 */
	void exitExcept(PolicyLanguageParser.ExceptContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolicyLanguageParser#except_attribute}.
	 * @param ctx the parse tree
	 */
	void enterExcept_attribute(PolicyLanguageParser.Except_attributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyLanguageParser#except_attribute}.
	 * @param ctx the parse tree
	 */
	void exitExcept_attribute(PolicyLanguageParser.Except_attributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolicyLanguageParser#except_as_aggregates}.
	 * @param ctx the parse tree
	 */
	void enterExcept_as_aggregates(PolicyLanguageParser.Except_as_aggregatesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyLanguageParser#except_as_aggregates}.
	 * @param ctx the parse tree
	 */
	void exitExcept_as_aggregates(PolicyLanguageParser.Except_as_aggregatesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolicyLanguageParser#except_to}.
	 * @param ctx the parse tree
	 */
	void enterExcept_to(PolicyLanguageParser.Except_toContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyLanguageParser#except_to}.
	 * @param ctx the parse tree
	 */
	void exitExcept_to(PolicyLanguageParser.Except_toContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolicyLanguageParser#except_where}.
	 * @param ctx the parse tree
	 */
	void enterExcept_where(PolicyLanguageParser.Except_whereContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyLanguageParser#except_where}.
	 * @param ctx the parse tree
	 */
	void exitExcept_where(PolicyLanguageParser.Except_whereContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolicyLanguageParser#except_group_by}.
	 * @param ctx the parse tree
	 */
	void enterExcept_group_by(PolicyLanguageParser.Except_group_byContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyLanguageParser#except_group_by}.
	 * @param ctx the parse tree
	 */
	void exitExcept_group_by(PolicyLanguageParser.Except_group_byContext ctx);
}