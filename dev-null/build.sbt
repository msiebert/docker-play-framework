name := "dev-null"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq()

// setting a maintainer which is used for all packaging types
maintainer := "Mark"

// exposing the play ports
dockerExposedPorts in Docker := Seq(9000)
