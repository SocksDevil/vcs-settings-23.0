package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.remoteParameters.hashiCorpVaultParameter
import jetbrains.buildServer.configs.kotlin.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'Build'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("Build")) {
    check(artifactRules == "") {
        "Unexpected option value: artifactRules = $artifactRules"
    }
    artifactRules = "meow.txt"

    params {
        add {
            param("TEST", "")
        }
        add {
            hashiCorpVaultParameter {
                name = "vaultParam"
                query = "secret/data/path!/meias"
            }
        }
    }

    expectSteps {
        gradle {
            id = "gradle_runner"
            tasks = "clean build"
            gradleWrapperPath = ""
        }
    }
    steps {
        insert(0) {
            script {
                id = "simpleRunner_1"
                scriptContent = """
                    echo "##teamcity[setParameter name='TEST' value='test']"
                    echo '%vaultParam%' > meow.txt
                """.trimIndent()
            }
        }
        insert(2) {
            script {
                id = "simpleRunner"
                scriptContent = """
                    echo '%vaultParam%' >> meow.txt
                    echo '%TEST%' >> meow.txt
                    sleep 1000000
                """.trimIndent()
            }
        }
    }
}
