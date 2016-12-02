name := "akkahttp_blogbase"
 
version := "1.0"
 
scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
	"com.typesafe.akka" %% "akka-http-core" % "2.4.11",
	"com.typesafe.akka" %% "akka-http-experimental" % "2.4.11",
	"com.typesafe.akka" %% "akka-http-spray-json-experimental" % "2.4.11",
	"com.typesafe.akka" %% "akka-http-xml-experimental" % "2.4.11",
	"com.typesafe.slick" %% "slick" % "3.1.1",
	"org.postgresql" % "postgresql" % "9.4-1200-jdbc41"
)

