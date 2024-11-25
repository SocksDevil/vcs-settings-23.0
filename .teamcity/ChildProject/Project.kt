package ChildProject

import ChildProject.buildTypes.*
import ChildProject.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project
import jetbrains.buildServer.configs.kotlin.projectFeatures.kubernetesExecutor

object Project : Project({
    id("ChildProject")
    name = "Child Project"

    vcsRoot(ChildProject_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain)

    buildType(ChildProject_Build)

    features {
        feature {
            id = "Fake-1"
            type = "CloudProfile"
            param("profileId", "Fake-1")
            param("name", "Fake cloud")
            param("description", "")
            param("cloud-code", "Fake")
            param("terminate-idle-time", "30")
            param("enabled", "true")
        }
        kubernetesExecutor {
            id = "PROJECT_EXT_4"
            connectionId = "PROJECT_EXT_13"
            profileName = "Test"
        }
    }
})
