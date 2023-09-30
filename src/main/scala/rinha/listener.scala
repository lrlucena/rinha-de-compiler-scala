package rinha

import rinha.parser.RinhaBaseListener as BaseListener
import org.antlr.v4.runtime.tree.{ParseTree, ParseTreeProperty as Property}
import rinha.BinaryOp.*
import rinha.Expression.*
import rinha.parser.RinhaParser.*

import scala.Int as SInt
import scala.jdk.CollectionConverters.ListHasAsScala

trait ContextValue:
  given Property[Exp] = Property[Exp]()

  extension (tree: ParseTree)(using values: Property[Exp])
    def apply(i: SInt): ParseTree = tree.getChild(i)
    def text: String = tree.getText
    def value: Exp = values.get(tree)
    def value_=(v: Exp): Unit = values.put(tree, v)


class MyListener extends BaseListener with ContextValue:
  private var _program: Option[Program] = None
  def program: Program = _program.get

  override def exitProgram(ctx: ProgramContext): Unit = _program = Some:
    Program(ctx.expr.value)

  override def exitLet(ctx: LetContext): Unit = ctx value_= :
    val id = ctx.expr(0).text
    val value = ctx.expr(1).value
    val in = ctx.expr(2).value
    Let(id, value, in)

  override def exitIf(ctx: IfContext): Unit = ctx.value_= :
    val cond = ctx.expr.value
    val `then` = ctx.block(0).value
    val `else` = ctx.block(1).value
    If(cond, `then`, `else`)

  override def exitFun(ctx: FunContext): Unit = ctx value_= :
    ctx.ID
    val params = ctx.ID().asScala.map(_.text).toSeq
    val exp = ctx.block().value
    Function(params, exp)

  override def exitPrint(ctx: PrintContext): Unit = ctx.value_= :
    val exp = ctx.expr.value
    Print(exp)

  override def exitFirst(ctx: FirstContext): Unit = ctx value_= :
    val exp = ctx.expr.value
    First(exp)

  override def exitSecond(ctx: SecondContext): Unit = ctx value_= :
    val exp = ctx.expr.value
    Second(exp)

  override def exitCall(ctx: CallContext): Unit = ctx value_= :
    val callee = ctx.expr(0).value
    val arguments = ctx.expr().asScala.tail.map(_.value).toSeq
    Call(callee, arguments)

  override def exitInt(ctx: IntContext): Unit = ctx value_= :
    val value = ctx.text.toInt
    Int(value)

  override def exitStr(ctx: StrContext): Unit = ctx value_= :
    val value = ctx.text.drop(1).dropRight(1)
    Str(value)

  override def exitBool(ctx: BoolContext): Unit = ctx value_= :
    val value = ctx.BOOL().text == "true"
    Bool(value)

  override def exitId(ctx: IdContext): Unit = ctx value_= :
    val name = ctx.ID.text
    Var(name)

  override def exitTuple(ctx: TupleContext): Unit = ctx value_= :
    val first = ctx.expr(0).value
    val second = ctx.expr(1).value
    Tuple(first, second)

  override def exitBin(ctx: BinContext): Unit = ctx value_= :
    val lhs = ctx.expr(0).value
    val rhs = ctx.expr(1).value
    val op = ctx(1).text
    val operation = Map(
      "-" -> Sub, "*" -> Mul, "/" -> Div, "%" -> Rem, "==" -> Eq, "!=" -> Neq,
      "<" -> Lt, ">" -> Gt, "<=" -> Lte, ">=" -> Gte, "&&" -> And, "||" -> Or
    ).withDefaultValue(Add)
    Binary(lhs, operation(op), rhs)

  override def exitBlock(ctx: BlockContext): Unit = ctx value_= :
    ctx.expr.value
