// Generated from /home/epsilon/Documents/Varsity/Project/build/web/uploadFiles/simpl.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link simplParser}.
 */
public interface simplListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link simplParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(simplParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link simplParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(simplParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link simplParser#fundef}.
	 * @param ctx the parse tree
	 */
	void enterFundef(simplParser.FundefContext ctx);
	/**
	 * Exit a parse tree produced by {@link simplParser#fundef}.
	 * @param ctx the parse tree
	 */
	void exitFundef(simplParser.FundefContext ctx);
	/**
	 * Enter a parse tree produced by {@link simplParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(simplParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link simplParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(simplParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link simplParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(simplParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link simplParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(simplParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link simplParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(simplParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link simplParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(simplParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link simplParser#vardecl}.
	 * @param ctx the parse tree
	 */
	void enterVardecl(simplParser.VardeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link simplParser#vardecl}.
	 * @param ctx the parse tree
	 */
	void exitVardecl(simplParser.VardeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link simplParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(simplParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link simplParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(simplParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link simplParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(simplParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link simplParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(simplParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link simplParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(simplParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link simplParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(simplParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link simplParser#xif}.
	 * @param ctx the parse tree
	 */
	void enterXif(simplParser.XifContext ctx);
	/**
	 * Exit a parse tree produced by {@link simplParser#xif}.
	 * @param ctx the parse tree
	 */
	void exitXif(simplParser.XifContext ctx);
	/**
	 * Enter a parse tree produced by {@link simplParser#xwhile}.
	 * @param ctx the parse tree
	 */
	void enterXwhile(simplParser.XwhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link simplParser#xwhile}.
	 * @param ctx the parse tree
	 */
	void exitXwhile(simplParser.XwhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link simplParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(simplParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link simplParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(simplParser.InputContext ctx);
	/**
	 * Enter a parse tree produced by {@link simplParser#output}.
	 * @param ctx the parse tree
	 */
	void enterOutput(simplParser.OutputContext ctx);
	/**
	 * Exit a parse tree produced by {@link simplParser#output}.
	 * @param ctx the parse tree
	 */
	void exitOutput(simplParser.OutputContext ctx);
	/**
	 * Enter a parse tree produced by {@link simplParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(simplParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link simplParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(simplParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link simplParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(simplParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link simplParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(simplParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link simplParser#simple}.
	 * @param ctx the parse tree
	 */
	void enterSimple(simplParser.SimpleContext ctx);
	/**
	 * Exit a parse tree produced by {@link simplParser#simple}.
	 * @param ctx the parse tree
	 */
	void exitSimple(simplParser.SimpleContext ctx);
	/**
	 * Enter a parse tree produced by {@link simplParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(simplParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link simplParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(simplParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link simplParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(simplParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link simplParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(simplParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link simplParser#num}.
	 * @param ctx the parse tree
	 */
	void enterNum(simplParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by {@link simplParser#num}.
	 * @param ctx the parse tree
	 */
	void exitNum(simplParser.NumContext ctx);
}