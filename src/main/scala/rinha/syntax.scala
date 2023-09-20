package rinha.syntax

type Exp = Expression
type Loc = Location
type Par = Parameter

trait Element:
  val loc: Location

enum Expression extends Element:
  case Program (expr: Exp,                           loc: Loc)
  case If      (cond: Exp, `then`: Exp, `else`: Exp, loc: Loc)
  case Print   (expr: Exp,                           loc: Loc)
  case Let     (id: String, exp: Exp, in: Exp,       loc: Loc)
  case Call    (callee: Exp, args: Seq[Exp],         loc: Loc)
  case Function(params: Seq[Par], value: Exp,        loc: Loc)
  case Var     (name: String,                        loc: Loc)
  case Int     (value: Int,                          loc: Loc)
  case Str     (value: String,                       loc: Loc)
  case Bool    (value: Boolean,                      loc: Loc)
  case Binary  (lhs: Exp, op: BinaryOp, rhs: Exp,    loc: Loc)
  case Unary   (op: UnaryOp, exp: Exp,               loc: Loc)
  case Tuple   (first: Exp, second: Exp,             loc: Loc)
  
enum BinaryOp:
  case Add, Sub, Mul, Div, Rem, Eq, Neq, Lt, Gt, Lte, Gte, And, Or

enum UnaryOp:
  case Minus, Not

case class Location(start: Int, end: Int, filename: String)
case class Parameter(id: String, loc: Loc)  extends Element
//case class File(name: String, expression: Exp, loc: Loc) extends Element

@main
def main(): Unit = {}

//  println("ok")
//  println(Expression.Print(null)(Expression.Str(null)("ok")))