package rinha.interpreter

import scala.collection.mutable.Map
import rinha.syntax.*
import rinha.syntax.Expression.*

type Environment = Map[String, rinha.syntax.Expression]
given Environment = Map[String, rinha.syntax.Expression]()

extension (expr: Expression)(using env: Environment)
  def eval: (Expression.Int | Expression.Bool | Unit) = expr match
    case If(cond, th, el, _) => (if cond.evalBool then th else el).eval
    case Print(Expression.Int(a,_),_)  => println(a)
    case Let(id, expr, in)        => env += id -> expr.eval ; in.eval
    case Program(expr)            => expr.eval
    case Id(id)                   => env.getOrElseUpdate(id, 0)
    case  _             =>
  def evalBool: Boolean = expr match
    case Bool(b, _) => b

extension (expr: Expression.Int)(using env: Environment)
  def eval: Int = expr match
    case Syntax.Int(a) => a
    case _             => 0


extension (expr: Expression)(using env: Environment)
  def value: Int = exp match
    case Read                 => io.StdIn.readInt()
    case Id(id)               => env.getOrElseUpdate(id, 0)
    case Integer(value)       => value
    case ExpSum(lhs, rhs)     => lhs.value + rhs.value
    case ExpSub(lhs, rhs)     => lhs.value - rhs.value
    case ExpMult(lhs, rhs)    => lhs.value * rhs.value
    case null | _             => 0

extension (exp: Bool)(using env: Environment)
  def value: Boolean = exp match
    case Boole(b)             => b
    case ExpEq(lhs, rhs)      => lhs.value == rhs.value
    case ExpLe(lhs, rhs)      => lhs.value <= rhs.value
    case Not(b)               => !b.value
    case And(lhs, rhs)        => lhs.value && rhs.value
    case null | _             => true

/*
  case Program(expr: Exp,                        location: Loc)                      
  case If(cond: Exp, `then`: Exp, `else`: Exp,   location: Loc)
  case Print(expr: Exp,                          location: Loc)
  case Let(id: Var, exp: Exp, in: Exp,           location: Loc)
  case Call(callee: Exp, args: Seq[Exp],         location: Loc)
  case Function(params: Seq[Par], value: Exp,    location: Loc)
  case Var(name: String,                         location: Loc)
  case Int(value: Int,                           location: Loc)
  case Str(value: String,                        location: Loc)
  case Bool(value: Boolean,                      location: Loc)
  case Binary(lhs: Exp, op: BinaryOp, rhs: Exp,  location: Loc)
  case Unary(op: UnaryOp, exp: Exp,              location: Loc)
  case Tuple(first: Exp, second: Exp,            location: Loc)
  */