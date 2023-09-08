type Exp = Expression
type Loc = Location
type Par = Parameter

enum Expression(kind: Kind, location: Loc):
  case Program(expression: Exp, kind: Kind, location: Loc)                        extends Exp(kind, location)
  case If(condition: Exp, `then`: Exp, otherwise: Exp, kind: Kind, location: Loc) extends Exp(kind, location)
  case Print(expression: Exp, kind: Kind, location: Loc)                          extends Exp(Kind.Null, location)
  case Let(id: Var, expression: Exp, in: Exp, kind: Kind, location: Loc)          extends Exp(kind, location)
  case Call(callee: Exp, arguments: Seq[Exp], kind: Kind, location: Loc)          extends Exp(kind, location)
  case Function(parameters: Seq[Par], value: Exp, kind: Kind, location: Loc)      extends Exp(kind, location)
  case Var(name: String, kind: Kind, location: Loc)                               extends Exp(kind, location)
  case Int(value: Int, location: Loc)                                             extends Exp(Kind.Number, location)
  case Str(value: String, location: Loc)                                          extends Exp(Kind.String, location)
  case Bool(value: Boolean, location: Loc)                                        extends Exp(Kind.Boolean, location)
  case Binary(lhs: Exp, operation: BinaryOp, rhs: Exp, kind: Kind, location: Loc) extends Exp(kind, location)
  case Tuple(first: Exp, second: Exp, kind: Kind, location: Loc)                  extends Exp(kind, location)
  
case class Location(start: Int, end: Int, filename: String)
case class Parameter(text: String, location: Location)
case class File(name: String, expression: Expression, location: Location)

enum BinaryOp:
  case And, Or, Eq

enum Kind:
  case String, Number, Boolean, Closure, Null
  case Tuple(first: Kind, second: Kind)
