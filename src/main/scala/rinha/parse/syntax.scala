package rinha.syntax

type Exp = Expression
type Loc = Location
type Par = Parameter

trait Element:
  val location: Loc

enum Expression extends Element:
  case Program(exprs: Seq[Exp],                         location: Loc)                      
  case If(cond: Exp, `then`: Seq[Exp], other: Seq[Exp], location: Loc)
  case Print(expr: Exp,                                 location: Loc)
  case Let(id: Var, expr: Exp, in: Exp,                 location: Loc)
  case Call(callee: Exp, args: Seq[Exp],                location: Loc)
  case Function(params: Seq[Par], value: Exp,           location: Loc)
  case Var(name: String,                                location: Loc)
  case Int(value: Int,                                  location: Loc)
  case Str(value: String,                               location: Loc)
  case Bool(value: Boolean,                             location: Loc)
  case Binary(lhs: Exp, op: BinaryOp, rhs: Exp,         location: Loc)
  case Unary(op: UnaryOp, exp: Exp,                     location: Loc)
  case Tuple(first: Exp, second: Exp,                   location: Loc)
  
enum BinaryOp:
  case Add, Sub, Mul, Div, Rem, Eq, Neq, Lt, Gt, Lte, Gte, And, Or

enum UnaryOp:
  case Minus, Not

case class Location(start: Int, end: Int, filename: String)
case class Parameter(text: String, location: Loc) extends Element
case class File(name: String, expression: Exp, location: Loc) extends Element
