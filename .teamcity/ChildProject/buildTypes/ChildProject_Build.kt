package ChildProject.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object ChildProject_Build : BuildType({
    name = "Build"

    vcs {
        root(ChildProject.vcsRoots.ChildProject_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain)
    }

    steps {
        gradle {
            id = "gradle_runner"
            tasks = "clean build"
            gradleWrapperPath = ""
        }
    }

    triggers {
        vcs {
        }
    }
})
