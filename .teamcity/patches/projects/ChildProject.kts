package patches.projects

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project
import jetbrains.buildServer.configs.kotlin.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the project with id = 'ChildProject'
accordingly, and delete the patch script.
*/
changeProject(RelativeId("ChildProject")) {
    features {
        add {
            feature {
                type = "CloudProfile"
                id = "Fake-7"
                param("profileId", "Fake-7")
                param("name", "meow")
                param("description", "")
                param("cloud-code", "Fake")
                param("terminate-idle-time", "30")
                param("enabled", "true")
            }
        }
        add {
            feature {
                type = "BuildExecutor"
                id = "PROJECT_EXT_21"
                param("profileName", "meow")
                param("executorType", "FakeExecutor")
            }
        }
    }
}
