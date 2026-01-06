package KubernetesExample.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.parallelTests
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object KubernetesExample_BuildParallelTests : BuildType({
    id("BuildParallelTests")
    name = "Build - Parallel Tests"

    vcs {
        root(KubernetesExample.vcsRoots.KubernetesExample_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain2)
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
        parallelTests {
            enabled = false
            numberOfBatches = 2
            groupArtifactsByBuild = false
        }
    }
})
