name := "client"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.scalaj" %% "scalaj-http" % "2.2.1"
)

// setting a maintainer which is used for all packaging types
maintainer := "Mark"

// exposing the play ports
dockerExposedPorts in Docker := Seq(9000)
