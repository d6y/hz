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
    version := "0.1-SNAPSHOT"
  ).
  jvmSettings(
    // Add JVM-specific settings here
  ).
  jsSettings(
    libraryDependencies ++= Seq(
     "org.scala-js" %%% "scalajs-dom" % "0.8.2",
     "com.lihaoyi"  %%% "scalatags"   % "0.6.0"
    )
  )

lazy val hzJVM = hz.jvm
lazy val hzJS = hz.js
