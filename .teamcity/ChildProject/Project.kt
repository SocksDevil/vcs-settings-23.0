package ChildProject

import ChildProject.buildTypes.*
import ChildProject.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project

object Project : Project({
    id("ChildProject")
    name = "Child Project"

    vcsRoot(ChildProject_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain)

    buildType(ChildProject_Build)

    features {
        feature {
            id = "Fake-7"
            type = "CloudProfile"
            param("profileId", "Fake-7")
            param("name", "meow")
            param("description", "")
            param("cloud-code", "Fake")
            param("terminate-idle-time", "30")
            param("enabled", "false")
        }
        feature {
            id = "PROJECT_EXT_21"
            type = "BuildExecutor"
            param("profileName", "meow")
            param("executorType", "FakeExecutor")
        }
        feature {
            id = "PROJECT_EXT_4"
            type = "BuildExecutor"
            param("profileName", "Subproject Executor")
            param("executorType", "FakeExecutor")
        }
    }
})
