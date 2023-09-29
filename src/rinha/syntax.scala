package rinha

type Exp = Expression

case class Program(expr: Exp)

enum Expression:
  case If(cond: Exp, `then`: Exp, `else`: Exp)
  case Print(expr: Exp)
  case Let(id: String, exp: Exp, in: Exp)
  case Call(callee: Exp, args: Seq[Exp])
  case Function(params: Seq[String], value: Exp)
  case Var(name: String)
  case Int(value: scala.Int)
  case Str(value: String)
  case Bool(value: Boolean)
  case Binary(lhs: Exp, op: BinaryOp, rhs: Exp)
  case Tuple(first: Exp, second: Exp)
  case First(expr: Exp)
  case Second(expr: Exp)

enum BinaryOp:
  case Add, Sub, Mul, Div, Rem, Eq, Neq, Lt, Gt, Lte, Gte, And, Or
  