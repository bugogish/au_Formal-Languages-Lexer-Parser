// Generated from /home/bugogish/au/FL/Lexer/src/main/LLanguage.g4 by ANTLR 4.6

package ru.spbau.mit.utils;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LLanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LLanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LLanguageParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(LLanguageParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(LLanguageParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLanguageParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(LLanguageParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLanguageParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(LLanguageParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(LLanguageParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLanguageParser#orexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrexpr(LLanguageParser.OrexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLanguageParser#andexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndexpr(LLanguageParser.AndexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLanguageParser#eqexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqexpr(LLanguageParser.EqexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLanguageParser#compexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompexpr(LLanguageParser.CompexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLanguageParser#addexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddexpr(LLanguageParser.AddexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLanguageParser#multexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultexpr(LLanguageParser.MultexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLanguageParser#atomexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomexpr(LLanguageParser.AtomexprContext ctx);
}