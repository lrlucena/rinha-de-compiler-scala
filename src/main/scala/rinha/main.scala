package rinha

import rinha.MyListener as Listener
import rinha.Walker.{sourceCode, walk}

import java.io.FileNotFoundException
import scala.language.implicitConversions
import scala.util.{Failure, Success}

@main
def main(file: String) =
  given Listener()
  sourceCode(file).flatMap(walk).flatMap :
    p => Interpreter.evaluate(p.expr)
  match
    case Success(_) =>
    case Failure(_: FileNotFoundException) => System.err.println("File not found")
    case Failure(e: Error) => System.err.println(s"Error: ${e.getMessage} ${e.exp}")
    case Failure(e) => System.err.println(s"Syntax Error: ${e.getMessage}")