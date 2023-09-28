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

def evalProgram(implicit eval: Eval): PF =
  case Program(expr, _) => println("evalprogram"); eval(expr)

def evalIf(implicit eval: Eval): PF =
  case a@If(cond, th, el, _) => eval(cond) map :
    case Bool(true, _) => th
    case Bool(false, _) => el
    case _ => throw RinhaRuntimeError("Expression is not a boolean", a)

def evalTuple(implicit eval: Eval): PF =
  case Tuple(first, second, _) =>
    for b <- eval(first)
        c <- eval(second)
    yield Tuple(b, c)

  case a@First(expr, _) => eval(expr) map :
    case t: Tuple => t.first
    case _ => throw RinhaRuntimeError("Expression is not a tuple.", a)

  case a@Second(expr, _) => eval(expr) map :
    case t: Tuple => t.second
    case _ => throw RinhaRuntimeError("Expression is not a tuple.", a)

def evalLet(env: Env): PF =
  case Let(id, expr, next, _) => println("evallet"); interpret(env.updated(id, expr))(next)

def evalVar(env: Env)(implicit eval: Eval): PF =
  case a@Var(name, _) => env.get(name) match
    case Some(expr) => eval(expr)
    case None => error(s"$name not found.", a)

def toStr(exp: Exp): String = exp match
  case _: Function => "<#closure>"
  case t: Tuple => s"(${toStr(t.first)}, ${toStr(t.second)})"
  case t: Exp => t.toString

def evalPrint(implicit eval: Eval): PF =
  case Print(e, _) => eval(e) map :
    exp => println(toStr(exp)); exp

def evalError: PF =
  case _: Function => Success("<#closure>")
  case a => error("Unsupported expression.", a)

given Conversion[scala.Int, Exp] = x => Int(x)
given Conversion[Boolean, Exp] = x => Bool(x)
given Conversion[String, Exp] = x => Str(x)

def evalBin(implicit eval: Eval): PF =
  case Binary(Bool(true, _), And, rhs, _) => eval(rhs)
  case Binary(Bool(_, _), And, _, _) => Success(false)
  case Binary(Bool(true, _), Or, _, _) => Success(true)
  case Binary(Bool(_, _), Or, rhs, _) => eval(rhs)
  case exp@Binary(lhs, op, rhs, _) =>
    for l <- eval(lhs)
        r <- eval(rhs)
    yield (l, op, r) match
      case (Int(a, _), Add, Int(b, _)) => a + b
      case (Int(a, _), Add, Str(b, _)) => s"$a$b"
      case (Str(a, _), Add, Str(b, _)) => s"$a$b"
      case (Str(a, _), Add, Int(b, _)) => s"$a$b"
      case (Int(a, _), Sub, Int(b, _)) => a - b
      case (Int(a, _), Mul, Int(b, _)) => a * b
      case (Int(a, _), Div, Int(b, _)) => a / b
      case (Int(a, _), Rem, Int(b, _)) => a % b
      case (Int(a, _), Eq, Int(b, _)) => a == b
      case (Str(a, _), Eq, Str(b, _)) => a == b
      case (Bool(a, _), Eq, Bool(b, _)) => a == b
      case (Int(a, _), Neq, Int(b, _)) => a != b
      case (Str(a, _), Neq, Str(b, _)) => a != b
      case (Bool(a, _), Neq, Bool(b, _)) => a != b
      case (Int(a, _), Lt, Int(b, _)) => a < b
      case (Int(a, _), Gt, Int(b, _)) => a > b
      case (Int(a, _), Lte, Int(b, _)) => a <= b
      case (Int(a, _), Gte, Int(b, _)) => a >= b
      case (_, _, _) => throw RinhaRuntimeError("Invalid binary operation.", exp)

def evalCall(implicit eval: Eval): PF = {
  //     interpret()
  case exp => Success(exp)
  /*  case a@Call(callee, exprs, loc) =>
    if needsEval(a)
    then {
      if needsEval(callee)
      then eval(callee).flatMap(e => Success(Call(e, exprs, loc)))
      else exprs.map(eval).map(es => Success(Call(callee, es, loc)))
    }
    else Success(a) */
}

def interpret(env: Env = Map())(expr: Exp): Try[Exp] =
  given eval: Eval = interpret(env)

  val inter = evalProgram(eval) orElse
    evalBasic orElse
    evalIf(eval) orElse
    evalBin(eval) orElse
//    evalCall(eval) orElse
    evalTuple(eval) orElse
    evalLet(env) orElse
    evalVar(env)(eval) orElse
    evalPrint(eval) orElse
    evalError

  inter(expr)
