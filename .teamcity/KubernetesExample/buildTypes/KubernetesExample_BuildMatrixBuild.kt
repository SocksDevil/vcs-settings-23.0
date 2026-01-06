package KubernetesExample.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.matrix
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object KubernetesExample_BuildMatrixBuild : BuildType({
    id("BuildMatrixBuild")
    name = "Build - Matrix Build"

    vcs {
        root(KubernetesExample.vcsRoots.KubernetesExample_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain3)
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

    features {
        matrix {
            os = listOf(
                value("Linux"),
                value("MacOs")
            )
            groupArtifactsByBuild = false
        }
    }

    requirements {
        equals("teamcity.agent.jvm.os.name", "%os%")
    }
})
