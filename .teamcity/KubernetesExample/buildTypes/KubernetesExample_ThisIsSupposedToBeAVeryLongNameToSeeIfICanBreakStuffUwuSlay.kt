package KubernetesExample.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object KubernetesExample_ThisIsSupposedToBeAVeryLongNameToSeeIfICanBreakStuffUwuSlay : BuildType({
    id("ThisIsSupposedToBeAVeryLongNameToSeeIfICanBreakStuffUwuSlay")
    name = "this is supposed to be a very long name to see if I can break stuff uwu slay"

    vcs {
        root(KubernetesExample.vcsRoots.KubernetesExample_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain)
    }

    steps {
        maven {
            id = "Maven2"
            enabled = false
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
        }
        dotnetBuild {
            name = "dotnettest"
            id = "dotnettest"
            param("teamcity.kubernetes.executor.container.image", "mcr.microsoft.com/dotnet/sdk:8.0")
            param("teamcity.kubernetes.executor.pull.policy", "IfNotPresent")
        }
    }

    triggers {
        vcs {
        }
    }
})
