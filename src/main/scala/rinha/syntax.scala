package rinha

//import Expression.{Bool, Function, Int, Str, Tuple}

type Exp = Expression
type Loc = Option[Location]
type Par = Parameter

enum Expression(override val toString: String = super.toString):
  case Program (expr: Exp,                           loc: Loc = None)
  case If      (cond: Exp, `then`: Exp, `else`: Exp, loc: Loc = None)
  case Print   (expr: Exp,                           loc: Loc = None)
  case Let     (id: String, exp: Exp, in: Exp,       loc: Loc = None)
  case Call    (callee: Exp, args: Seq[Exp],         loc: Loc = None)
  case Function(params: Seq[Par], value: Exp,        loc: Loc = None) extends Exp("<#clojure>")
  case Var     (name: String,                        loc: Loc = None)
  case Int     (value: scala.Int,                    loc: Loc = None) extends Exp(value.toString)
  case Str     (value: String,                       loc: Loc = None) extends Exp(value)
  case Bool    (value: Boolean,                      loc: Loc = None) extends Exp(value.toString)
  case Binary  (lhs: Exp, op: BinaryOp, rhs: Exp,    loc: Loc = None)
  case Tuple   (first: Exp, second: Exp,             loc: Loc = None)
  case First   (expr: Exp,                           loc: Loc = None)
  case Second  (expr: Exp,                           loc: Loc = None)

enum BinaryOp:
  case Add, Sub, Mul, Div, Rem, Eq, Neq, Lt, Gt, Lte, Gte, And, Or

case class Parameter(id: String, loc: Loc = None)
case class Location(start: Int, end: Int, filename: String)
