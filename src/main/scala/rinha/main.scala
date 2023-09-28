package rinha

import scala.language.implicitConversions
import scala.util.{Failure, Success}
import Expression.*
import BinaryOp.*

@main
def main(): Unit = {
 //  val a = Program(Binary(1, Add, 0))
 // val a = Program(Print(Binary(Var("x"), Add, 2)))
 // val a = Program(Let("x", 10, Print(Binary(Var("x"), Add, Var("x")))))
   val a = Program(Print(Tuple(4, Tuple(Binary(5, Add, "b"), Function(Seq(), Var("a"))))))

  val exec = interpret()(a)
  exec match {
    case Success(x) => //scalaprintln(s"Output: $x ${x.getClass.descriptorString()}")
    case Failure(erro: RinhaRuntimeError) => println(s"Error: ${erro.getMessage} ${erro.exp}}")
    case a => println(s"Unkown error. $a")
  }
}
