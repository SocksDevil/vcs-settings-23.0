package patches.projects

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project
import jetbrains.buildServer.configs.kotlin.projectFeatures.HashiCorpVaultConnection
import jetbrains.buildServer.configs.kotlin.projectFeatures.KubernetesConnection
import jetbrains.buildServer.configs.kotlin.projectFeatures.KubernetesExecutor
import jetbrains.buildServer.configs.kotlin.projectFeatures.hashiCorpVaultConnection
import jetbrains.buildServer.configs.kotlin.projectFeatures.kubernetesConnection
import jetbrains.buildServer.configs.kotlin.projectFeatures.kubernetesExecutor
import jetbrains.buildServer.configs.kotlin.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the root project
accordingly, and delete the patch script.
*/
changeProject(DslContext.projectId) {
    params {
        add {
            text("inherit", "meow")
        }
    }

    features {
        val feature1 = find<KubernetesExecutor> {
            kubernetesExecutor {
                id = "PROJECT_EXT_23"
                connectionId = "PROJECT_EXT_3"
                profileName = "Meow"
                buildsLimit = "1"
                enabled = true
                param("parametersAvailable", "1")
            }
        }
        feature1.apply {
            buildsLimit = "2"
            param("parametersAvailable", "")
            param("enabled", "")
        }
        val feature2 = find<KubernetesConnection> {
            kubernetesConnection {
                id = "PROJECT_EXT_8"
                name = "Certificate & Key"
                apiServerUrl = "meow"
                namespace = "meow"
                authStrategy = clientCertificateAndKey {
                    clientKey = "credentialsJSON:43b46ece-15a7-4621-a271-7d2b33e9e356"
                    clientCertificate = "credentialsJSON:87a6537c-cb8f-4684-b44d-e0ea183e9fa1"
                }
            }
        }
        feature2.apply {
            caCertificate = "credentialsJSON:b5a2935a-eda9-4e36-b4e0-398d6c833371"
        }
        remove {
            kubernetesConnection {
                id = "PROJECT_EXT_9"
                name = "EKS with server instance profile"
                apiServerUrl = "meow"
                authStrategy = eks {
                    eksUseInstanceProfile = true
                    assumeIamRole = true
                    iamRoleArn = "arn"
                    clusterName = "cluster-name"
                }
            }
        }
        val feature3 = find<HashiCorpVaultConnection> {
            hashiCorpVaultConnection {
                id = "hashicorpVaultConnection1"
                name = "HashiCorp Vault"
                vaultId = ""
                url = "http://127.0.0.1:8200"
                authMethod = appRole {
                    roleId = "f3e75c6b-118b-48a1-97fc-6b8a69eb3bc3"
                    secretId = "credentialsJSON:a90c9e97-f71b-4571-bfff-24f0eb0db85b"
                }
                failOnError = false
            }
        }
        feature3.apply {
        }
    }
}
