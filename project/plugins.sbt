libraryDependencies += "org.scala-sbt" %% "scripted-plugin" % sbtVersion.value

addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.8.2")
addSbtPlugin("com.dwijnand" % "sbt-dynver" % "2.0.0")
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "1.1.0")
addSbtPlugin("com.github.sbt" % "sbt-github-actions" % "0.28.0")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.4")
