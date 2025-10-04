import sbt._

import com.typesafe.sbt.SbtScalariform
import com.typesafe.sbt.SbtScalariform.ScalariformKeys
import com.typesafe.sbt.SbtScalariform.autoImport._

object ScalariformSupport {
  lazy val formatSettings = Seq(
    scalariformAutoformat := false,
    Compile / ScalariformKeys.preferences := formattingPreferences,
    Test / ScalariformKeys.preferences := formattingPreferences
  )

  import scalariform.formatter.preferences._
  def formattingPreferences =
    FormattingPreferences()
      .setPreference(RewriteArrowSymbols, true)
      .setPreference(AlignParameters, true)
      .setPreference(AlignSingleLineCaseStatements, true)
      .setPreference(DoubleIndentConstructorArguments, true)

}
