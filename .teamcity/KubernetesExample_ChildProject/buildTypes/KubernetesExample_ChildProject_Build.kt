package KubernetesExample_ChildProject.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object KubernetesExample_ChildProject_Build : BuildType({
    id("ChildProject_Build")
    name = "Build"

    vcs {
        root(KubernetesExample_ChildProject.vcsRoots.KubernetesExample_ChildProject_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain)
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
