package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object BuildParallelTests : BuildType({
    name = "Build - Parallel Tests"

    vcs {
        root(_Self.vcsRoots.HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain2)
    }

    triggers {
        vcs {
        }
    }
})
