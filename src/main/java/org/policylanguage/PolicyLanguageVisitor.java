// Generated from /Users/gertibushati/Desktop/Extended_Policy_Specification/src/main/resources/PolicyLanguage.g4 by ANTLR 4.10.1
package org.policylanguage;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PolicyLanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PolicyLanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PolicyLanguageParser#policy_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPolicy_expression(PolicyLanguageParser.Policy_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolicyLanguageParser#positive_policy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositive_policy(PolicyLanguageParser.Positive_policyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolicyLanguageParser#ship}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShip(PolicyLanguageParser.ShipContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolicyLanguageParser#ship_attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShip_attribute(PolicyLanguageParser.Ship_attributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolicyLanguageParser#as_aggregates}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAs_aggregates(PolicyLanguageParser.As_aggregatesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolicyLanguageParser#aggr_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggr_func(PolicyLanguageParser.Aggr_funcContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolicyLanguageParser#from}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrom(PolicyLanguageParser.FromContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolicyLanguageParser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable(PolicyLanguageParser.TableContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolicyLanguageParser#to}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTo(PolicyLanguageParser.ToContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolicyLanguageParser#location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocation(PolicyLanguageParser.LocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolicyLanguageParser#where}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhere(PolicyLanguageParser.WhereContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolicyLanguageParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(PolicyLanguageParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolicyLanguageParser#operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperand(PolicyLanguageParser.OperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolicyLanguageParser#group_by}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup_by(PolicyLanguageParser.Group_byContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolicyLanguageParser#negative_policy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegative_policy(PolicyLanguageParser.Negative_policyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolicyLanguageParser#except}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExcept(PolicyLanguageParser.ExceptContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolicyLanguageParser#except_attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExcept_attribute(PolicyLanguageParser.Except_attributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolicyLanguageParser#except_as_aggregates}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExcept_as_aggregates(PolicyLanguageParser.Except_as_aggregatesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolicyLanguageParser#except_to}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExcept_to(PolicyLanguageParser.Except_toContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolicyLanguageParser#except_where}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExcept_where(PolicyLanguageParser.Except_whereContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolicyLanguageParser#except_group_by}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExcept_group_by(PolicyLanguageParser.Except_group_byContext ctx);
}