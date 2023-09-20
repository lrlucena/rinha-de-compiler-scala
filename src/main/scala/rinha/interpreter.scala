package rinha.interpreter

import scala.collection.mutable.Map
import rinha.syntax.Expression.Int
import rinha.syntax.Expression
import rinha.syntax.Expression.*
import rinha.syntax.BinaryOp.*

type Environment = Map[String, Expression]
given Environment = Map[String, Expression]()

def eval(expr: Expression)(using env: Environment): Any = expr match
  case Program(expr, _)               => eval(expr)

  case If(cond, th, el, _)         => if eval(cond) == Bool(true) then eval(th) else eval(el)
  case Let(id, expr, in, _)        => eval(in)(env + (id -> eval(expr)))
  case Function(params, value, _)  => s"(${params.mkString(",")}) => $value"
  case Print(expr)                 => val a = eval(expr); println(a); a
  case Call(Var("first", _), args) => eval(args(1))
  case Binary(lhs, Add, rhs, _)    => eval(lhs) + eval(rhs)
  case Binary(lhs, Sub, rhs, _)    => eval(lhs) - eval(rhs)
  case Binary(lhs, Mul, rhs, _)    => eval(lhs) * eval(rhs)
  case Binary(lhs, Div, rhs, _)    => eval(lhs) / eval(rhs)
  case Binary(lhs, Rem, rhs, _)    => eval(lhs) % eval(rhs)
  case Binary(lhs, Eq , rhs, _)    => eval(lhs) == eval(rhs)
  case Binary(lhs, Neq, rhs, _)    => eval(lhs) != eval(rhs)
  case Binary(lhs, Lt , rhs, _)    => eval(lhs) < eval(rhs)
  case Binary(lhs, Gt , rhs, _)    => eval(lhs) > eval(rhs)
  case Binary(lhs, Lte, rhs, _)    => eval(lhs) <= eval(rhs)
  case Binary(lhs, Gte, rhs, _)    => eval(lhs) >= eval(rhs)
  case Binary(lhs, And, rhs, _)    => eval(lhs) && eval(rhs)
  case Binary(lhs, Or , rhs, _)    => eval(lhs).toBool || (bool)eval(rhs)



  case Int(n, _)               => expr.loc
  case _                       => 3 //Expression.Bool(null)(true)
//  def eval: (Expression.Int | Expression.Bool | Unit) = expr match
//    case Print(Expression.Int(a,_),_)  => println(a)
//    
//    case Id(id)                   => env.getOrElseUpdate(id, 0)
//    case  _             =>
//  def evalBool: Boolean = expr match
//    case Bool(b, _) => b

// extension (expr: Expression.Int)(using env: Environment)
//  def eval: Int = expr match
//    case Syntax.Int(a) => a
//    case _             => 0


//extension (expr: Expression)(using env: Environment)
//  def value: Int = exp match
//    case Read                 => io.StdIn.readInt()
//    case Id(id)               => env.getOrElseUpdate(id, 0)
//    case Integer(value)       => value
//    case ExpSum(lhs, rhs)     => lhs.value + rhs.value
//    case ExpSub(lhs, rhs)     => lhs.value - rhs.value
//    case ExpMult(lhs, rhs)    => lhs.value * rhs.value
//    case null | _             => 0

//extension (exp: Bool)(using env: Environment)
//  def value: Boolean = exp match
//    case Boole(b)             => b
//    case ExpEq(lhs, rhs)      => lhs.value == rhs.value
//    case ExpLe(lhs, rhs)      => lhs.value <= rhs.value
//    case Not(b)               => !b.value
//    case And(lhs, rhs)        => lhs.value && rhs.value
//    case null | _             => true

/*
  case Print(expr: Exp,                          location: Loc)
  case Call(callee: Exp, args: Seq[Exp],         location: Loc)
  case Var(name: String,                         location: Loc)
  case Int(value: Int,                           location: Loc)
  case Str(value: String,                        location: Loc)
  case Bool(value: Boolean,                      location: Loc)
  case Binary(lhs: Exp, op: BinaryOp, rhs: Exp,  location: Loc)
  case Unary(op: UnaryOp, exp: Exp,              location: Loc)
  case Tuple(first: Exp, second: Exp,            location: Loc)
  */