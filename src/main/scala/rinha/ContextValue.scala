package rinha

import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.{ParseTree, ParseTreeProperty as Property}

import scala.jdk.CollectionConverters.ListHasAsScala

trait ContextValue[V]:
  private val values = Property[V]()

  extension (tree: ParseTree)
    def apply(i: Int): ParseTree = tree.getChild(i)
    def text: String = tree.getText
    def value: V = values.get(tree)
    def value_=(v: V): Unit = values.put(tree, v)

  extension[E] (list: java.util.List[E])
    def map[T](f: E => T): Seq[T] = list.asScala.toSeq.map(f)

  given Conversion[ParserRuleContext, String] = x => x.text

  given Conversion[ParseTree, V] = x => x.value