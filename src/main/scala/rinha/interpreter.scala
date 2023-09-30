package rinha

import rinha.BinaryOp.*
import rinha.Expression.*

import scala.language.implicitConversions
import scala.util.{Failure, Success, Try}

case class RinhaRuntimeError(msg: String, exp: Exp) extends Exception(msg)

def error(msg: String, exp: Exp): Failure[Exp] = Failure(RinhaRuntimeError(msg, exp))

type Env = Map[String, Exp]
type Eval = Exp => Try[Exp]
type PF = PartialFunction[Exp, Try[Exp]]

def evalBasic: PF =
  case a: Int => Success(a)
  case a: Bool => Success(a)
  case a: Str => Success(a)

def evalIf(implicit eval: Eval): PF =
  case a@If(cond, th, el) => eval(cond) flatMap :
    case Bool(true) => eval(th)
    case Bool(false) => eval(el)
    case _ => error("Expression is not a boolean", a)

def evalTuple(implicit eval: Eval): PF =
  case Tuple(first, second) =>
    for b <- eval(first)
        c <- eval(second)
    yield Tuple(b, c)

  case a@First(expr) => eval(expr) flatMap :
    case Tuple(first, _) => eval(first)
    case _ => error("Expression is not a tuple.", a)

  case a@Second(expr) => eval(expr) flatMap :
    case Tuple(_, second) => eval(second)
    case _ => error("Expression is not a tuple.", a)

def evalVar(env: Env)(implicit eval: Eval): PF =
  case a@Let(id, expr, next) => System.err.println(a);interpret(env.updated(id, expr))(next)
  case a@Var(name) => env.get(name) match
    case Some(expr) => eval(expr)
    case None => error(s"$name not found.", a)

def toStr(exp: Exp): String = exp match
  case _: Function => "<#closure>"
  case Int(n) => n.toString
  case Bool(b) => b.toString
  case Str(s) => s
  case Tuple(first, second) => s"(${toStr(first)}, ${toStr(second)})"
  case t: Exp => t.toString

def evalPrint(implicit eval: Eval): PF =
  case Print(e) => eval(e) map :
    case exp => println(toStr(exp)); exp

def evalError: PF =
  case _: Function => Success("<#closure>")
  case a => error("Unsupported expression.", a)

given Conversion[scala.Int, Exp] = x => Int(x)
given Conversion[Boolean, Exp] = x => Bool(x)
given Conversion[String, Exp] = x => Str(x)

def evalBin(implicit eval: Eval): PF =
  case Binary(Bool(true), And, rhs) => eval(rhs)
  case Binary(_: Bool, And, _) => Success(false)
  case Binary(Bool(true), Or, _) => Success(true)
  case Binary(_: Bool, Or, rhs) => eval(rhs)
  case exp@Binary(lhs, op, rhs) =>
    for l <- eval(lhs)
        r <- eval(rhs)
    yield (l, op, r) match
      case (Int(a), Add, Int(b)) => a + b
      case (Int(a), Add, Str(b)) => s"$a$b"
      case (Str(a), Add, Str(b)) => s"$a$b"
      case (Str(a), Add, Int(b)) => s"$a$b"
      case (Int(a), Sub, Int(b)) => a - b
      case (Int(a), Mul, Int(b)) => a * b
      case (Int(a), Div, Int(b)) => a / b
      case (Int(a), Rem, Int(b)) => a % b
      case (Int(a), Eq, Int(b)) => a == b
      case (Str(a), Eq, Str(b)) => a == b
      case (Bool(a), Eq, Bool(b)) => a == b
      case (Int(a), Neq, Int(b)) => a != b
      case (Str(a), Neq, Str(b)) => a != b
      case (Bool(a), Neq, Bool(b)) => a != b
      case (Int(a), Lt, Int(b)) => a < b
      case (Int(a), Gt, Int(b)) => a > b
      case (Int(a), Lte, Int(b)) => a <= b
      case (Int(a), Gte, Int(b)) => a >= b
      case _ => throw RinhaRuntimeError("Invalid binary operation.", exp)

def evalCall(env: Env = Map())(implicit eval: Eval): PF = {
  case a@Call(Function(params, value), exprs) =>
    if params.length == exprs.length then
      val en = params.zip(exprs).foldLeft(env)((en, exp) => en.updated(exp._1, exp._2))
      interpret(en)(value)
    else throw RinhaRuntimeError("The size of parameters and arguments are not the same.", a)
}

def interpret(env: Env = Map())(expr: Exp): Try[Exp] =
  given eval: Eval = interpret(env)

  val inter =
    evalBasic orElse evalIf orElse evalBin orElse
    evalTuple orElse evalVar(env) orElse evalPrint orElse
    evalCall(env) orElse evalError

  inter(expr)
