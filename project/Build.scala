import sbt._
import sbt.Keys._
import play.sbt.PlayScala
import play.sbt.routes.RoutesKeys._

object Build extends sbt.Build {
  val buildOrganisation = "damotou.info"
  val buildVersion = "0.0.1-SNAPSHOT"
  val buildScalaVersion = "2.11.7"
  val buildScalaOptions = Seq(
    "-unchecked", "-deprecation"
    , "-encoding", "utf8"
    , "-Xelide-below", annotation.elidable.ALL.toString
  )

  lazy val main = Project(id = "spider4everyone", base = file(".")).enablePlugins(PlayScala)
    .settings(
      libraryDependencies ++= Seq(
        "com.typesafe.play" %% "play-slick" % "1.1.1",
        "com.typesafe.play" %% "play-slick-evolutions" % "1.1.1",
        "com.h2database" % "h2" % "1.4.187",
        "com.typesafe.slick" %% "slick" % "3.1.1",
        "org.scalacheck" %% "scalacheck" % "1.11.5" % "test",
        "org.pegdown" % "pegdown" % "1.0.2" % "test", //used in html report
        "org.scalatest" %% "scalatest" % "2.2.1" % "test",
        "org.seleniumhq.selenium" % "selenium-java" % "2.35.0" % "test",
        "org.slf4j" % "slf4j-api" % "1.7.7",
        "com.storm-enroute" %% "scalameter" % "0.6" % "test",
        "ch.qos.logback" % "logback-classic" % "1.1.2",
        "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2"
      )
      , organization := buildOrganisation
      , version := buildVersion
      , scalaVersion := buildScalaVersion
      , scalacOptions := buildScalaOptions
      , routesGenerator := InjectedRoutesGenerator
    )
}
