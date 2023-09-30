package rinha

import rinha.BinaryOp.*
import rinha.Expression.*
import Walker.{sourceCode, walk}
import rinha.MyListener as Listener

import java.io.FileNotFoundException
import scala.language.implicitConversions
import scala.util.{Failure, Success}

@main
def main(file: String) =
  given Listener()
  sourceCode(file).flatMap(walk).flatMap(p => interpret(Map())(p.expr)) match
    case Success(program) => println(program)
    case Failure(e: FileNotFoundException) => println("File not found")
    case Failure(e: RinhaRuntimeError) => println(s"Error: ${e.getMessage}")
    case Failure(e) => println(s"Unknown Error: ${e}")