cd src
java -jar ../lib/antlr-4.13.1-complete.jar  -package rinha.parser rinha/parser/Rinha.g4
cd  rinha
scalac -d ../../rinha-lrlucena.jar syntax.scala interpreter.scala main.scala
cd ../..
scala rinha-lrlucena.jar
