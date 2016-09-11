name := "hz"

scalaVersion in ThisBuild := "2.11.8"

scalaJSUseRhino in Global := false

lazy val root = project.in(file(".")).
  aggregate(hzJS, hzJVM).
  settings(
    publish := {},
    publishLocal := {}
  )

lazy val hz = crossProject.in(file(".")).
  settings(
    name := "hz",
    version := "0.1-SNAPSHOT",
    libraryDependencies ++= Seq(
      "org.typelevel" %%% "cats"      % "0.7.0",
      "org.scalatest" %%% "scalatest" % "3.0.0" % "test"
    )
  ).
  jvmSettings(
    libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.0.3"
  ).
  jsSettings(
    libraryDependencies ++= Seq(
     "org.scala-js" %%% "scalajs-dom" % "0.9.1",
     "com.lihaoyi"  %%% "scalatags"   % "0.6.0"
    )
  )

lazy val hzJVM = hz.jvm
lazy val hzJS = hz.js
