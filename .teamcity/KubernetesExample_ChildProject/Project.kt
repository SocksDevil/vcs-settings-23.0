package KubernetesExample_ChildProject

import KubernetesExample_ChildProject.buildTypes.*
import KubernetesExample_ChildProject.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project
import jetbrains.buildServer.configs.kotlin.projectFeatures.kubernetesExecutor

object Project : Project({
    id("ChildProject")
    name = "Child Project"

    vcsRoot(KubernetesExample_ChildProject_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain)

    buildType(KubernetesExample_ChildProject_Build)

    features {
        kubernetesExecutor {
            id = "PROJECT_EXT_4"
            connectionId = "PROJECT_EXT_13"
            profileName = "Test"
        }
    }
})
