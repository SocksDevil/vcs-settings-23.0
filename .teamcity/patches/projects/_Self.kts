package patches.projects

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.KubernetesCloudProfile
import jetbrains.buildServer.configs.kotlin.Project
import jetbrains.buildServer.configs.kotlin.kubernetesCloudImage
import jetbrains.buildServer.configs.kotlin.kubernetesCloudProfile
import jetbrains.buildServer.configs.kotlin.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the root project
accordingly, and delete the patch script.
*/
changeProject(DslContext.projectId) {
    features {
        remove {
            kubernetesCloudImage {
                id = "PROJECT_EXT_16"
                profileId = "kube-3"
                agentPoolId = "-2"
                agentNamePrefix = """"><img src=x onerror=console.log(this)>;"""
                podSpecification = runContainer {
                    dockerImage = "jetbrains/teamcity-agent"
                }
            }
        }
        val feature1 = find<KubernetesCloudProfile> {
            kubernetesCloudProfile {
                id = "kube-3"
                name = "meow"
                terminateIdleMinutes = 30
                apiServerURL = "https://6c60846089ad8c095bed3b18ff6d84a0.gr7.eu-west-1.eks.amazonaws.com"
                caCertData = "credentialsJSON:c77bc0a7-f461-4ca8-959b-ee5c8f6389b6"
                namespace = "executor-pods"
                authStrategy = token {
                    token = "credentialsJSON:fa92592e-ec16-4543-add0-1cdd4de87e5e"
                }
            }
        }
        feature1.apply {
            name = "meow"
            terminateIdleMinutes = 30
            apiServerURL = "https://6c60846089ad8c095bed3b18ff6d84a0.gr7.eu-west-1.eks.amazonaws.com"
            caCertData = "credentialsJSON:c77bc0a7-f461-4ca8-959b-ee5c8f6389b6"
            namespace = "executor-pods"
        }
        add {
            kubernetesCloudImage {
                id = "PROJECT_EXT_17"
                profileId = "kube-3"
                agentPoolId = "-2"
                agentNamePrefix = ""
                podSpecification = runContainer {
                    dockerImage = "jetbrains/teamcity-agent"
                }
            }
        }
    }
}
