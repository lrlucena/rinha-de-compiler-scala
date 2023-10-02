package rinha

case class Error(msg: String, exp: Exp) extends Exception(msg)

object Error:
  def notBool(exp: Exp): Error =
    Error(s"Expression $exp is not a boolean", exp)

  def notTuple(exp: Exp): Error =
    Error(s"Expression $exp is not a tuple.", exp)

  def nameNotFound(exp: Exp): Error =
    Error(s"Name $exp not found", exp)

  def invalidBinary(exp: Exp): Error =
    Error("Invalid binary operation.", exp)

  def unsupported(exp: Exp): Error =
    Error(s"Unsupported expression $exp.", exp)

  def sizeMismatch(exp: Exp): Error =
    Error("The size of parameters and arguments are not the same.", exp)

  def notFunction(exp: Exp): Error =
    Error(s"$exp is not a function.", exp)