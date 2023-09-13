package rinha.syntax

type Exp = Expression
type Loc = Location
type Par = Parameter

trait Element:
  val location: Location

enum Expression extends Element:
  case Program (loc: Loc)(expr: Exp)
  case If      (loc: Loc)(cond: Exp, `then`: Exp, `else`: Exp)
  case Print   (loc: Loc)(expr: Exp)
  case Let     (loc: Loc)(id: String, exp: Exp, in: Exp)
  case Call    (loc: Loc)(callee: Exp, args: Seq[Exp])
  case Function(loc: Loc)(params: Seq[Par], value: Exp)
  case Var     (loc: Loc)(name: String)
  case Int     (loc: Loc)(value: Int)
  case Str     (loc: Loc)(value: String)
  case Bool    (loc: Loc)(value: Boolean)
  case Binary  (loc: Loc)(lhs: Exp, op: BinaryOp, rhs: Exp)
  case Unary   (loc: Loc)(op: UnaryOp, exp: Exp)
  case Tuple   (loc: Loc)(first: Exp, second: Exp)
  
enum BinaryOp:
  case Add, Sub, Mul, Div, Rem, Eq, Neq, Lt, Gt, Lte, Gte, And, Or

enum UnaryOp:
  case Minus, Not

case class Location(start: Int, end: Int, filename: String)
case class Parameter(loc: Loc)(id: String,  extends Element
case class File(name: String, expression: Exp, location: Loc) extends Element

@main
def main(): Unit = {}

//  println("ok")
//  println(Expression.Print(null)(Expression.Str(null)("ok")))