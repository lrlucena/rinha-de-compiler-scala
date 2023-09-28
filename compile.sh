cd  src/main/scala/rinha
scalac -d ../../../../rinha-lrlucena.jar syntax.scala interpreter.scala main.scala
cd ../../../..
scala rinha-lrlucena.jar
