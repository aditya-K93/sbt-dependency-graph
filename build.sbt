enablePlugins(ScriptedPlugin)

scriptedLaunchOpts += s"-Dproject.version=${version.value}"

ThisBuild / githubWorkflowJavaVersions := Seq(JavaSpec.temurin("21"))
ThisBuild / githubWorkflowPublishTargetBranches := Seq()

ThisBuild / githubWorkflowBuild := Seq(
  WorkflowStep.Run(
    List("curl -Ls https://raw.githubusercontent.com/dwijnand/sbt-extras/master/sbt > sbt && chmod 0755 sbt && sudo mv sbt /usr/local/bin/"),
    name = Some("Install sbt")
  ),
  WorkflowStep.Sbt(List("test", "scripted"))
)

libraryDependencies ++= {
  if ((pluginCrossBuild / sbtVersion).value.startsWith("0.13"))
    Seq("com.github.mdr" %% "ascii-graphs" % "0.0.3")
  else
    Nil
}


libraryDependencies += "org.specs2" %% "specs2-core" % "3.10.0" % Test

libraryDependencies += Defaults.sbtPluginExtra(
  "com.dwijnand" % "sbt-compat" % "1.2.6",
  (pluginCrossBuild / sbtBinaryVersion).value,
  (update / scalaBinaryVersion).value
)

crossSbtVersions := Seq("1.2.7", "0.13.18")

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-unchecked"
)

ScalariformSupport.formatSettings
