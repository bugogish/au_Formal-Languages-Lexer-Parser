// Generated from /home/bugogish/au/FL/Lexer/src/main/LLanguage.g4 by ANTLR 4.7

package ru.spbau.mit.utils;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LLanguageParser}.
 */
public interface LLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LLanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LLanguageParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LLanguageParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(LLanguageParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(LLanguageParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLanguageParser#skip_statement}.
	 * @param ctx the parse tree
	 */
	void enterSkip_statement(LLanguageParser.Skip_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLanguageParser#skip_statement}.
	 * @param ctx the parse tree
	 */
	void exitSkip_statement(LLanguageParser.Skip_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLanguageParser#write_statement}.
	 * @param ctx the parse tree
	 */
	void enterWrite_statement(LLanguageParser.Write_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLanguageParser#write_statement}.
	 * @param ctx the parse tree
	 */
	void exitWrite_statement(LLanguageParser.Write_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLanguageParser#read_statement}.
	 * @param ctx the parse tree
	 */
	void enterRead_statement(LLanguageParser.Read_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLanguageParser#read_statement}.
	 * @param ctx the parse tree
	 */
	void exitRead_statement(LLanguageParser.Read_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLanguageParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile_statement(LLanguageParser.While_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLanguageParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile_statement(LLanguageParser.While_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLanguageParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(LLanguageParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLanguageParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(LLanguageParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLanguageParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(LLanguageParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLanguageParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(LLanguageParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLanguageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(LLanguageParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLanguageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(LLanguageParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(LLanguageParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(LLanguageParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLanguageParser#orexpr}.
	 * @param ctx the parse tree
	 */
	void enterOrexpr(LLanguageParser.OrexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLanguageParser#orexpr}.
	 * @param ctx the parse tree
	 */
	void exitOrexpr(LLanguageParser.OrexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLanguageParser#andexpr}.
	 * @param ctx the parse tree
	 */
	void enterAndexpr(LLanguageParser.AndexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLanguageParser#andexpr}.
	 * @param ctx the parse tree
	 */
	void exitAndexpr(LLanguageParser.AndexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLanguageParser#eqexpr}.
	 * @param ctx the parse tree
	 */
	void enterEqexpr(LLanguageParser.EqexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLanguageParser#eqexpr}.
	 * @param ctx the parse tree
	 */
	void exitEqexpr(LLanguageParser.EqexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLanguageParser#compexpr}.
	 * @param ctx the parse tree
	 */
	void enterCompexpr(LLanguageParser.CompexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLanguageParser#compexpr}.
	 * @param ctx the parse tree
	 */
	void exitCompexpr(LLanguageParser.CompexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLanguageParser#addexpr}.
	 * @param ctx the parse tree
	 */
	void enterAddexpr(LLanguageParser.AddexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLanguageParser#addexpr}.
	 * @param ctx the parse tree
	 */
	void exitAddexpr(LLanguageParser.AddexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLanguageParser#multexpr}.
	 * @param ctx the parse tree
	 */
	void enterMultexpr(LLanguageParser.MultexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLanguageParser#multexpr}.
	 * @param ctx the parse tree
	 */
	void exitMultexpr(LLanguageParser.MultexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLanguageParser#atomexpr}.
	 * @param ctx the parse tree
	 */
	void enterAtomexpr(LLanguageParser.AtomexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLanguageParser#atomexpr}.
	 * @param ctx the parse tree
	 */
	void exitAtomexpr(LLanguageParser.AtomexprContext ctx);
}