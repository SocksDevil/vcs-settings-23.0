package patches.projects

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project
import jetbrains.buildServer.configs.kotlin.kubernetesCloudImage
import jetbrains.buildServer.configs.kotlin.projectFeatures.KubernetesExecutor
import jetbrains.buildServer.configs.kotlin.projectFeatures.hashiCorpVaultConnection
import jetbrains.buildServer.configs.kotlin.projectFeatures.kubernetesExecutor
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
        val feature1 = find<KubernetesExecutor> {
            kubernetesExecutor {
                id = "PROJECT_EXT_4"
                connectionId = "PROJECT_EXT_3"
                profileName = "Meow"
                templateContainer = """
                    apiVersion: v1
                    kind: Pod
                    spec:
                      containers:
                          # This is a template container, where all the presented settings will be used for the real containers generated by TeamCity
                          # Please refrain from adding new containers, as those can't be added to your build
                          # To modify the volume used to run the build, add a volume with the name agent-volume
                        - name: template-container
                """.trimIndent()
                param("profileServerUrl", "https://teamcity.evielution.me/bs")
                param("system.cloud.profile_id", "PROJECT_EXT_4")
            }
        }
        feature1.apply {
            enabled = false
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
        add {
            hashiCorpVaultConnection {
                id = "hashicorpVaultConnection1"
                name = "HashiCorp Vault"
                url = "https://many-socks-fetch.loca.lt"
                authMethod = appRole {
                    roleId = "f3e75c6b-118b-48a1-97fc-6b8a69eb3bc3"
                    secretId = "credentialsJSON:26e2160e-39b8-4d6c-af12-20913b9eaa40"
                }
                failOnError = false
            }
        }
    }
}
