package rinha

import rinha.BinaryOp.{Sub, *}
import rinha.Error.*
import rinha.Expression.{Int, *}

import scala.language.implicitConversions
import scala.util.{Failure, Success, Try}

object Interpreter:
  private type Env = Map[String, Exp]
  private type Eval = Exp => Try[Exp]
  private type PF = PartialFunction[Exp, Try[Exp]]

  def evaluate(expr: Exp): Try[Exp] = interpret(Map())(expr)

  given Conversion[scala.Int, Exp] = x => Int(x)
  given Conversion[Boolean, Exp] = x => Bool(x)
  given Conversion[String, Exp] = x => Str(x)

  private def evalBasic: PF =
    case a: Int => Success(a)
    case a: Bool => Success(a)
    case a: Str => Success(a)

  private def evalIf(implicit eval: Eval): PF =
    case If(cond, th, el) => eval(cond) flatMap :
      case Bool(true)  => eval(th)
      case Bool(false) => eval(el)
      case _ => Failure(notBool(cond))

  private def evalTuple(implicit eval: Eval): PF =
    case Tuple(first, second) =>
      for b <- eval(first)
          c <- eval(second)
      yield Tuple(b, c)

    case a@First(expr) => eval(expr) flatMap :
      case Tuple(first, _) => eval(first)
      case _ => Failure(notTuple(a))

    case a@Second(expr) => eval(expr) flatMap :
      case Tuple(_, second) => eval(second)
      case _ => Failure(notTuple(a))

  private def evalVar(env: Env)(implicit eval: Eval): PF =
    case f: Function => Success(f)
    case Let(id, expr, next) =>
      eval(expr) flatMap :
        ex => interpret(env.updated(id, ex))(next)
    case a@Var(name) => env.get(name) match
      case Some(expr) => eval(expr)
      case None => Failure(nameNotFound(a))

  private def toStr(exp: Exp): String = exp match
    case _: Function => "<#closure>"
    case Int(n) => n.toString
    case Bool(b) => b.toString
    case Str(s) => s
    case Tuple(first, second) => s"(${toStr(first)}, ${toStr(second)})"
    case t: Exp => t.toString

  private def evalPrint(implicit eval: Eval): PF =
    case Print(e) =>
      for exp <- eval(e) yield
        println(toStr(exp))
        exp

  private def evalBin(implicit eval: Eval): PF =
    case a@Binary(lhs, And, rhs) =>
      eval(lhs) flatMap :
        case Bool(true) => eval(rhs)
        case Bool(false) => Success(Bool(false))
        case _ => Failure(invalidBinary(a))

    case a@Binary(lhs, Or, rhs) =>
      eval(lhs) flatMap :
        case Bool(true) => Success(Bool(true))
        case Bool(false) => eval(rhs)
        case _ => Failure(invalidBinary(a))

    case exp@Binary(lhs, op, rhs) =>
      for l <- eval(lhs)
          r <- eval(rhs)
      yield (l, op, r) match
        case (a, Eq, b) => a == b
        case (a, Neq, b) if a.getClass == b.getClass => a != b
        case (Int(a), op, Int(b)) => op match
          case Add => a + b
          case Sub => a - b
          case Mul => a * b
          case Div => a / b
          case Rem => a % b
          case Lt  => a < b
          case Gt  => a > b
          case Lte => a <= b
          case Gte => a >= b
          case _ => throw invalidBinary(exp)
        case (Int(a), Add, Str(b)) => s"$a$b"
        case (Str(a), Add, Str(b)) => s"$a$b"
        case (Str(a), Add, Int(b)) => s"$a$b"
        case _ => throw invalidBinary(exp)

  private def evalCall(env: Env = Map())(implicit eval: Eval): PF =
    case Call(exp, exprs) =>
      eval(exp) flatMap :
        case Function(params, value) if params.length == exprs.length =>
          var ev = env
          for (id, ex) <- params.zip(exprs)
              e <- eval(ex) do
                ev = ev.updated(id, e)
          interpret(ev)(value)
        case _ : Function => Failure(sizeMismatch(exp))
        case exp => Failure(notFunction(exp))

  private def interpret(env: Env)(expr: Exp): Try[Exp] =
    given Eval = interpret(env)

    val inter =
      evalBasic orElse evalIf orElse evalBin orElse evalTuple orElse
        evalVar(env) orElse evalCall(env) orElse evalPrint

    inter.orElse(exp => Failure(unsupported(exp)))(expr)
