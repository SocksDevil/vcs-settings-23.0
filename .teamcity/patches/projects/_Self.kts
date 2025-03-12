package patches.projects

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project
import jetbrains.buildServer.configs.kotlin.projectFeatures.HashiCorpVaultConnection
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
        val feature1 = find<KubernetesExecutor> {
            kubernetesExecutor {
                id = "PROJECT_EXT_23"
                connectionId = "PROJECT_EXT_3"
                profileName = "Meow"
            }
        }
        feature1.apply {
            containerParameters = "parameter.dot.meow=meow"
        }
        val feature2 = find<HashiCorpVaultConnection> {
            hashiCorpVaultConnection {
                id = "hashicorpVaultConnection1"
                name = "HashiCorp Vault"
                url = "http://127.0.0.1:8200"
                authMethod = appRole {
                    roleId = "f3e75c6b-118b-48a1-97fc-6b8a69eb3bc3"
                    secretId = "credentialsJSON:a90c9e97-f71b-4571-bfff-24f0eb0db85b"
                }
                failOnError = false
            }
        }
        feature2.apply {
            vaultId = ""
        }
    }
}
