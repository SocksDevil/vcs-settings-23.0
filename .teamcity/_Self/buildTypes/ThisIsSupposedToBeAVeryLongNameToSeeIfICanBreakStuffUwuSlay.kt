package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object ThisIsSupposedToBeAVeryLongNameToSeeIfICanBreakStuffUwuSlay : BuildType({
    name = "this is supposed to be a very long name to see if I can break stuff uwu slay"

    vcs {
        root(_Self.vcsRoots.HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain1)
    }

    triggers {
        vcs {
        }
    }
})
