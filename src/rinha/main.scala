package rinha

import rinha.BinaryOp.*
import rinha.Expression.*
import Walker.{sourceCode, walk}
import rinha.MyListener as Listener

import java.io.FileNotFoundException
import scala.language.implicitConversions
import scala.util.{Failure, Success}

//@main def main(): Unit = {
//  val a = Program(Print(Call(Function(Seq("x"), Binary(Var("x"), Add, 7)), Seq(3))))

  //val a = Program(Print(Binary(true, Or, 4)))
  // val a = Program(Print(Function(Seq(), Print("a"))))
  //  val a = Program(Binary(1, And, 0))
  // val a = Program(Print(Binary(Var("x"), Add, 2)))
  // val a = Program(Let("x", 10, Print(Binary(Var("x"), Add, Var("x")))))
  // val a = Program(Print(Tuple(4, Tuple(Binary(5, Add, "b"), Function(Seq(), Var("a"))))))
/*
  val exec = interpret()(a.expr)
  exec match {
    case Success(_) => //scalaprintln(s"Output: $x ${x.getClass.descriptorString()}")
    case Failure(erro: RinhaRuntimeError) => println(s"Error: ${erro.getMessage} ${erro.exp}}")
    case a => println(s"Unkown error. $a")
  }
}*/

given Listener()
@main
def main(file: String) =
  val listener = Listener()
  sourceCode(file).flatMap(walk) match
    case Success(program) =>
    case Failure(e: FileNotFoundException) => println("File not found")
    case Failure(e: RinhaRuntimeError) => println(s"Error: ${e.msg}")
    case Failure(e) => println(s"Unknown Error: ${e.getMessage}")