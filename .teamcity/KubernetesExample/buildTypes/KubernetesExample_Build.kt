package KubernetesExample.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object KubernetesExample_Build : BuildType({
    id("Build")
    name = "Build"

    params {
        param("TEST", "")
        param("vaultParam", "meow")
        param("meow", "meowmeow")
    }

    steps {
        script {
            id = "simpleRunner_1"
            scriptContent = """
                echo "##teamcity[setParameter name='TEST' value='test']"
                echo '%vaultParam%' > meow.txt
            """.trimIndent()
        }
        gradle {
            id = "gradle_runner"
            tasks = "clean build"
            gradleWrapperPath = ""
        }
        script {
            id = "simpleRunner"
            scriptContent = """
                echo '%vaultParam%' >> meow.txt
                echo '%TEST%' >> meow.txt
                #sleep 1000000
            """.trimIndent()
            param("teamcity.kubernetes.executor.pull.policy", "IfNotPresent")
        }
    }

    triggers {
        vcs {
        }
    }
})
