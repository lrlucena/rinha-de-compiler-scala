package rinha

import Expression.*
import BinaryOp.*
import scala.{Int => SInt}
import scala.util.{Failure, Success, Try}

case class RinhaRuntimeError(msg: String, loc: Loc) extends Exception(msg) {}

type Environment = Map[String, Exp]

type X = {val value: Any}

val (fst, snd) = ("first", "second")

def error(msg: String, loc: Loc) = Failure(RinhaRuntimeError(msg, loc))
def eval(env: Environment)(expr: Exp): Try[Exp] =
  val en = eval(env)
  println(s"$env - $expr")
  expr match
    case Program(expr, _)                          => en(expr)
    case If(cond: Bool, th, el, _)                 => if (for e <- en(cond) yield e) == Bool(true) then en(th) else en(el)
    case If(cond, th, el, loc)                     => for c <- en(cond) yield If(c, th, el, loc)
    case Let(id, expr, in, _)                      => eval(env.updated(id, expr))(in)
    case a: Int                                    => Success(a)
  //  case Print(expr: Int, _)                       => for e <- en(expr) yield {println(e); e}
  //  case Print(expr: Bool, _)                      => println(expr.value); Success(expr)
  //  case Print(expr: Str, _)                       => println(expr.value); Success(expr)
    case Print(expr: Exp, _)                       => for e <- en(expr) yield e match {
      case a: Int => println(a.value); a
      case a: Bool => println(a.value); a
      case a: Str => println(a.value); a
     // case a@Tuple(x, y, _) => for b <- en(x);  c <- en(y) yield { println(s"($b, $c)"); Tuple(b,c)}
    }
    case Print(expr, loc)                          => for e <- en(expr) yield {println(e); e}
     // val a = en(expr); for x <- a do println(a); a
    case Call(Var(`fst`, _), exps, loc)            => evalTuple(en)(fst, exps, loc)
    case Call(Var(`snd`, _), exps, loc)            => evalTuple(en)(snd, exps, loc)
   // case Call(f: Var, exps, loc)                   => for a <- en(f) yield
    case Var(name, loc)                            => env.get(name) match {
      case Some(a) => Success(a)
      case None => error(s"$name not found.", loc)
    }
    case Binary(lhs: Int, op, rhs: Int, loc)       => evalInt(en)(lhs, op, rhs, loc)
    case Binary(lhs: Bool, op, rhs: Bool, loc)     => evalBool(lhs, op, rhs, loc)
    case Binary(lhs: Basic, op, rhs: Basic, loc)   => evalStr(lhs, op, rhs, loc)
    case Binary(lhs, op, rhs, loc)                 => for l <- en(lhs); r <- en(rhs) yield Binary(l, op, r, loc)
    case a                                         => error("Invalid operation.", a.loc)

def evalInt(en: Expression => Try[Expression])(lhs: Int, op: BinaryOp, rhs: Int, loc: Loc): Try[Exp] =
  println(s"evalInt: $lhs, $op, $rhs")
  val (l, r) = (lhs.value, rhs.value)
  def opInt(operation: (SInt, SInt) => SInt) = Success(Int(operation(l, r), loc))
  def opBool(operation: (SInt, SInt) => Boolean) = Success(Bool(operation(l, r), loc))
  op match
    case Add => en(Int(lhs.value + rhs.value))//opInt(_ + _)
    case Sub => opInt(_ - _)
    case Mul => opInt(_ * _)
    case Div => if r == 0 then error("/ by zero", loc) else opInt(_ / _)
    case Rem => if r == 0 then error("/ by zero", loc) else opInt(_ % _)
    case Eq  => opBool(_ == _)
    case Neq => opBool(_ != _)
    case Lt  => opBool(_ < _)
    case Gt  => opBool(_ > _)
    case Lte => opBool(_ <= _)
    case Gte => opBool(_ >= _)
    case _   => error("Invalid operation between integers.", loc)

def evalBool(lhs: Bool, op: BinaryOp, rhs: Bool, loc: Loc): Try[Exp] =
  val (l, r) = (lhs.value, rhs.value)
  def opBool(operation: (Boolean, Boolean) => Boolean) = Success(Bool(operation(l, r), loc))
  op match
    case And => opBool(_ && _)
    case Or  => opBool(_ || _)
    case Eq  => opBool(_ == _)
    case Neq => opBool(_ != _)
    case _   => error("Invalid operation between booleans.", loc)

def evalStr[T, R](lhs: {val value: T}, op: BinaryOp, rhs: {val value: R}, loc: Loc): Try[Exp] =
  val (l, r) = (lhs.toString, rhs.toString)
  def opStr(operation: (String, String) => String) = Success(Str(operation(l, r), loc))
  def opBool(operation: (String, String) => Boolean) = Success(Bool(operation(l, r), loc))
  (lhs, op, rhs) match
    case (a: Str, Eq, b: Str)                => opBool(_ == _)
    case (_: Str, Neq, _: Str)               => opBool(_ != _)
    case (_: Str, Add, _) | (_, Add, _: Str) => opStr(_ + _)
    case (_: Str, _, _)   | (_, _, _: Str)   => error("Invalid operation between strings.", loc)
    case (_, _, _)                           => error("Invalid operation.", loc)

def evalTuple(en: Expression => Try[Expression])(name: String, args: Seq[Exp], loc: Option[Location]) = (name, args) match
  case (`fst`, Seq(t: Tuple))  => en(t.first)
  case (`snd`, Seq(t: Tuple))  => en(t.second)
  case (_, Seq(c: Call))       => en(c)
  case (_, _)                  => error("Value is not a tuple.", loc)

@main
def main() =
  val a = Program(Binary(Int(1), Rem, Int(0)))
//  val a = Program(Print(Binary(Var("x"), Add, Bool(false))))
//  val a = Program(Print(Var("x")))

  val exec = eval(Map())(a)
  exec match
    case Success(x) => println(s"Output: $x")
    case Failure(erro: RinhaRuntimeError) => println(s"Error: ${erro.getMessage} ${erro.loc}")
    case _ => println("Unkown error.")