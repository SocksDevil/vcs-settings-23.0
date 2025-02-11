package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'Build'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("Build")) {
    expectSteps {
        gradle {
            id = "gradle_runner"
            tasks = "clean build"
        }
        script {
            id = "simpleRunner_1"
            scriptContent = """
                echo "##teamcity[setParameter name='TEST' value='test']"
                echo '%vaultParam%' > meow.txt
            """.trimIndent()
        }
        script {
            id = "simpleRunner"
            scriptContent = """
                echo '%vaultParam%' >> meow.txt
                echo '%TEST%' >> meow.txt
                #sleep 1000000
            """.trimIndent()
        }
    }
    steps {
        items.removeAt(0)
        update<ScriptBuildStep>(0) {
            clearConditions()
            scriptContent = """
                echo "##teamcity[setParameter name='TEST' value='test']"
                echo '%vaultParam%' > meow.txt
                sleep 240
            """.trimIndent()
        }
        update<ScriptBuildStep>(1) {
            clearConditions()
            scriptContent = """
                echo '%vaultParam%' >> meow.txt
                echo '%TEST%' >> meow.txt
                sleep 1000000
            """.trimIndent()
        }
        insert(2) {
            gradle {
                id = "gradle_runner"
                tasks = "clean build"
                param("teamcity.kubernetes.executor.pull.policy", "+Present")
            }
        }
    }

    failureConditions {

        check(executionTimeoutMin == 0) {
            "Unexpected option value: executionTimeoutMin = $executionTimeoutMin"
        }
        executionTimeoutMin = 5
    }
}
