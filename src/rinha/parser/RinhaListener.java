// Generated from rinha/parser/Rinha.g4 by ANTLR 4.13.1
package rinha.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RinhaParser}.
 */
public interface RinhaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RinhaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(RinhaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link RinhaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(RinhaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bool}
	 * labeled alternative in {@link RinhaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBool(RinhaParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link RinhaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBool(RinhaParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bin}
	 * labeled alternative in {@link RinhaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBin(RinhaParser.BinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bin}
	 * labeled alternative in {@link RinhaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBin(RinhaParser.BinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link RinhaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(RinhaParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link RinhaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(RinhaParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code second}
	 * labeled alternative in {@link RinhaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSecond(RinhaParser.SecondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code second}
	 * labeled alternative in {@link RinhaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSecond(RinhaParser.SecondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code str}
	 * labeled alternative in {@link RinhaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStr(RinhaParser.StrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code str}
	 * labeled alternative in {@link RinhaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStr(RinhaParser.StrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code call}
	 * labeled alternative in {@link RinhaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCall(RinhaParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code call}
	 * labeled alternative in {@link RinhaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCall(RinhaParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tuple}
	 * labeled alternative in {@link RinhaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTuple(RinhaParser.TupleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tuple}
	 * labeled alternative in {@link RinhaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTuple(RinhaParser.TupleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code print}
	 * labeled alternative in {@link RinhaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPrint(RinhaParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code print}
	 * labeled alternative in {@link RinhaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPrint(RinhaParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code let}
	 * labeled alternative in {@link RinhaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLet(RinhaParser.LetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code let}
	 * labeled alternative in {@link RinhaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLet(RinhaParser.LetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link RinhaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(RinhaParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link RinhaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(RinhaParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if}
	 * labeled alternative in {@link RinhaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIf(RinhaParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if}
	 * labeled alternative in {@link RinhaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIf(RinhaParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fun}
	 * labeled alternative in {@link RinhaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFun(RinhaParser.FunContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fun}
	 * labeled alternative in {@link RinhaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFun(RinhaParser.FunContext ctx);
	/**
	 * Enter a parse tree produced by the {@code first}
	 * labeled alternative in {@link RinhaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFirst(RinhaParser.FirstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code first}
	 * labeled alternative in {@link RinhaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFirst(RinhaParser.FirstContext ctx);
	/**
	 * Enter a parse tree produced by {@link RinhaParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(RinhaParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link RinhaParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(RinhaParser.BlockContext ctx);
}