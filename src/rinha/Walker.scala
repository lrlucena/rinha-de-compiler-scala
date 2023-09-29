package rinha

import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.misc.ParseCancellationException
import org.antlr.v4.runtime.tree.ParseTreeWalker
import rinha.parser.{RinhaLexer as Lexer, RinhaParser as Parser}
import rinha.MyListener as Listener

import scala.util.Try

object ThrowingErrorListener extends BaseErrorListener:
  override def syntaxError(r: Recognizer[?, ?], off: Any, line: Int, col: Int, msg: String, e: RecognitionException) =
    throw ParseCancellationException(s"line $line:$col $msg")

object Walker:
  def sourceCode(file: String): Try[String] = Try:
    io.Source.fromFile(file).getLines().mkString("\n")

  def walk(source: String)(using listener: Listener): Try[Program] = Try:
    val lexer = Lexer(CharStreams.fromString(source))
    val parser = Parser(CommonTokenStream(lexer))
    addListener(lexer, parser)
    ParseTreeWalker().walk(listener, parser.program)
    listener.program

  private def addListener(r: Recognizer[?, ?]*) = r.map: r =>
    r.removeErrorListeners()
    r.addErrorListener(ThrowingErrorListener)