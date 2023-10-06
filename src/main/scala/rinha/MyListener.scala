package rinha

import rinha.parser.RinhaBaseListener
import rinha.BinaryOp.*
import rinha.Expression.*
import rinha.parser.RinhaParser.*

class MyListener extends RinhaBaseListener with ContextValue[Exp]:
  private var _program: Option[Program] = None
  def program: Program = _program.get

  override def exitProgram(ctx: ProgramContext): Unit = _program = Some:
    Program(ctx.expr.value)

  override def exitLet(ctx: LetContext): Unit = ctx.value_= :
    val id = ctx.ID.text
    val value = ctx.expr(0).value
    val in = ctx.expr(1).value
    Let(id, value, in)

  override def exitIf(ctx: IfContext): Unit = ctx.value_= :
    val cond = ctx.expr(0).value
    val `then` = ctx.expr(1).value
    val `else` = ctx.expr(2).value
    If(cond, `then`, `else`)

  override def exitFun(ctx: FunContext): Unit = ctx.value_= :
    val params = ctx.ID.map(_.text)
    val exp = ctx.expr.value
    Function(params, exp)

  override def exitPrint(ctx: PrintContext): Unit = ctx.value_= :
    Print(ctx.expr.value)

  override def exitFirst(ctx: FirstContext): Unit = ctx.value_= :
    First(ctx.expr.value)

  override def exitSecond(ctx: SecondContext): Unit = ctx.value_= :
    Second(ctx.expr.value)

  override def exitCall(ctx: CallContext): Unit = ctx.value_= :
    val callee :: arguments = ctx.expr.map(_.value) : @unchecked
    Call(callee, arguments)

  override def exitInt(ctx: IntContext): Unit = ctx.value_= :
    Int(ctx.INT.text.toInt)

  override def exitStr(ctx: StrContext): Unit = ctx.value_= :
    Str(ctx.STR.text.drop(1).dropRight(1))

  override def exitBool(ctx: BoolContext): Unit = ctx.value_= :
    Bool(ctx.BOOL.text == "true")

  override def exitId(ctx: IdContext): Unit = ctx.value_= :
    Var(ctx.ID.text)

  override def exitTuple(ctx: TupleContext): Unit = ctx.value_= :
    val first = ctx.expr(0).value
    val second = ctx.expr(1).value
    Tuple(first, second)

  override def exitBin(ctx: BinContext): Unit = ctx.value_= :
    val lhs = ctx.expr(0).value
    val rhs = ctx.expr(1).value
    val op = ctx(1).text
    val operation = Map(
      "-" -> Sub, "*" -> Mul, "/" -> Div, "%" -> Rem, "==" -> Eq, "!=" -> Neq,
      "<" -> Lt, ">" -> Gt, "<=" -> Lte, ">=" -> Gte, "&&" -> And, "||" -> Or
    ).withDefaultValue(Add)
    Binary(lhs, operation(op), rhs)

  override def exitBlock(ctx: BlockContext): Unit = ctx.value_= :
    ctx.expr.value
