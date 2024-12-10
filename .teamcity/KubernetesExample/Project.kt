package KubernetesExample

import KubernetesExample.buildTypes.*
import KubernetesExample.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project
import jetbrains.buildServer.configs.kotlin.projectFeatures.bitbucketServerConnection
import jetbrains.buildServer.configs.kotlin.projectFeatures.hashiCorpVaultConnection
import jetbrains.buildServer.configs.kotlin.projectFeatures.kubernetesConnection
import jetbrains.buildServer.configs.kotlin.projectFeatures.kubernetesExecutor

object Project : Project({

    vcsRoot(KubernetesExample_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain2)
    vcsRoot(KubernetesExample_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain)
    vcsRoot(KubernetesExample_HttpsBbdatacenterQaTeamcityComScmTestuserMailTestJavaMavenJunitGit)
    vcsRoot(KubernetesExample_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain1)

    buildType(KubernetesExample_BuildParallelTests)
    buildType(KubernetesExample_Build)
    buildType(KubernetesExample_ThisIsSupposedToBeAVeryLongNameToSeeIfICanBreakStuffUwuSlay)

    params {
        text("testMeow", "meow?", description = "meowmeow", allowEmpty = true)
        text("meow", "meow", description = "MeowMeow!")
    }

    features {
        kubernetesConnection {
            id = "PROJECT_EXT_10"
            name = "EKS"
            apiServerUrl = "meow"
            namespace = "meow"
            authStrategy = eks {
                accessId = "id"
                secretKey = "credentialsJSON:3507800f-ae64-49f1-bbb5-0a4deec5c7b3"
                clusterName = "cluster-name"
            }
        }
        kubernetesConnection {
            id = "PROJECT_EXT_11"
            name = "Username and Password"
            apiServerUrl = "meow"
            namespace = "meow"
            authStrategy = usernameAndPassword {
                username = "username"
                password = "credentialsJSON:aaef5e7e-5a51-427c-b0ea-3af364cacedd"
            }
        }
        kubernetesConnection {
            id = "PROJECT_EXT_12"
            name = "Default Service Account"
            apiServerUrl = "meow"
            namespace = "meow"
            param("authStrategy", "service-account")
        }
        kubernetesConnection {
            id = "PROJECT_EXT_13"
            name = "Open ID"
            apiServerUrl = "meow"
            namespace = "meow"
            authStrategy = openId {
                idpIssuerUrl = "idpurl"
                clientId = "clientId"
                clientSecret = "credentialsJSON:612f3414-2b25-41ec-9520-12c9669d1f85"
                refreshToken = "credentialsJSON:0bb3f85a-7ff4-474e-9c14-8da47099595a"
            }
        }
        kubernetesConnection {
            id = "PROJECT_EXT_16"
            name = "EKS JB Managed"
            apiServerUrl = "https://1D9DE0392C8CFAC214189045F2125202.gr7.eu-west-1.eks.amazonaws.com"
            caCertificate = "credentialsJSON:ffe4af77-1daf-4824-975f-a6778d5566fd"
            namespace = "teamcity-cloud"
            authStrategy = token {
                token = "credentialsJSON:df987c3f-e01d-4a37-b75d-b270c95f2a2f"
            }
        }
        bitbucketServerConnection {
            id = "PROJECT_EXT_17"
            displayName = "Bitbucket Server / Data Center"
            serverUrl = "http://bbdatacenter.qa.teamcity.com:7990"
            clientId = "admin"
            clientSecret = "credentialsJSON:2f85280b-1c5e-4cda-84dd-d89ca5ae4c5a"
            useUniqueRedirect = true
        }
        kubernetesConnection {
            id = "PROJECT_EXT_18"
            name = "Limited Time Token"
            apiServerUrl = "https://6c60846089ad8c095bed3b18ff6d84a0.gr7.eu-west-1.eks.amazonaws.com"
            caCertificate = "credentialsJSON:c77bc0a7-f461-4ca8-959b-ee5c8f6389b6"
            namespace = "executor-pods"
            authStrategy = token {
                token = "credentialsJSON:d73cd72a-d98b-4526-a1c6-ef21c24c1c5e"
            }
        }
        kubernetesExecutor {
            id = "PROJECT_EXT_23"
            connectionId = "PROJECT_EXT_3"
            profileName = "Meow"
            buildsLimit = "1"
            enabled = true
            param("parametersAvailable", "1")
        }
        kubernetesConnection {
            id = "PROJECT_EXT_3"
            name = "EKS Connection"
            apiServerUrl = "https://6c60846089ad8c095bed3b18ff6d84a0.gr7.eu-west-1.eks.amazonaws.com"
            caCertificate = "credentialsJSON:c77bc0a7-f461-4ca8-959b-ee5c8f6389b6"
            namespace = "executor-pods"
            authStrategy = token {
                token = "credentialsJSON:fa92592e-ec16-4543-add0-1cdd4de87e5e"
            }
        }
        kubernetesConnection {
            id = "PROJECT_EXT_5"
            name = "JetBrains Console"
            apiServerUrl = "https://1d9de0392c8cfac214189045f2125202.gr7.eu-west-1.eks.amazonaws.com"
            caCertificate = "credentialsJSON:ffe4af77-1daf-4824-975f-a6778d5566fd"
            namespace = "teamcity-cloud"
            authStrategy = token {
                token = "credentialsJSON:df987c3f-e01d-4a37-b75d-b270c95f2a2f"
            }
        }
        kubernetesConnection {
            id = "PROJECT_EXT_7"
            name = "Unauthorized"
            apiServerUrl = "meow"
            namespace = "meowmeow"
            authStrategy = unauthorized()
        }
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

    subProject(KubernetesExample_ChildProject.Project)
})
