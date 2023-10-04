ThisBuild / version := "1.0"
ThisBuild / organization := "com.github.lrlucena"
ThisBuild / scalaVersion := "3.3.1"

enablePlugins(Antlr4Plugin)

Compile / packageBin / mainClass := Some("rinha.main")
Compile / scalacOptions ++= Seq("-deprecation","-explain")
assembly / mainClass :=  Some("rinha.main")
assembly / assemblyJarName := "/rinha-lrlucena.jar"

lazy val root = (project in file("."))
  .settings(
    name := "Rinha"
  )

libraryDependencies ++= Seq(
  "org.antlr" % "antlr4" % "4.13.1"
)

Antlr4 / antlr4Version:= "4.13.1"
Antlr4 / antlr4PackageName := Some("rinha.parser")
Antlr4 / antlr4GenListener := true
Antlr4 / antlr4GenVisitor := false