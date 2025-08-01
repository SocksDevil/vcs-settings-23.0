package _Self

import _Self.buildTypes.*
import _Self.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project
import jetbrains.buildServer.configs.kotlin.kubernetesCloudImage
import jetbrains.buildServer.configs.kotlin.kubernetesCloudProfile
import jetbrains.buildServer.configs.kotlin.projectFeatures.bitbucketServerConnection
import jetbrains.buildServer.configs.kotlin.projectFeatures.cloudIntegration
import jetbrains.buildServer.configs.kotlin.projectFeatures.hashiCorpVaultConnection
import jetbrains.buildServer.configs.kotlin.projectFeatures.kubernetesConnection
import jetbrains.buildServer.configs.kotlin.projectFeatures.kubernetesExecutor

object Project : Project({

    vcsRoot(HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain3)
    vcsRoot(HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain2)
    vcsRoot(HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain)
    vcsRoot(HttpsBbdatacenterQaTeamcityComScmTestuserMailTestJavaMavenJunitGit)
    vcsRoot(HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain1)

    buildType(BuildMatrixBuild)
    buildType(BuildParallelTests)
    buildType(Build)
    buildType(ThisIsSupposedToBeAVeryLongNameToSeeIfICanBreakStuffUwuSlay)

    params {
        text("testMeow", "meow?", description = "meowmeow", allowEmpty = true)
        text("inherit", "meow")
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
        kubernetesConnection {
            id = "PROJECT_EXT_23"
            name = "Minikube"
            apiServerUrl = "https://127.0.0.1:58951"
            authStrategy = clientCertificateAndKey {
                clientKey = "credentialsJSON:5da4ff08-dc02-4bdc-bff9-7c0549d06912"
                clientCertificate = "credentialsJSON:5acc2170-29e9-44df-aa22-5960118c6342"
            }
        }
        cloudIntegration {
            id = "PROJECT_EXT_24"
            enabled = true
            subprojectsEnabled = true
            allowOverride = false
        }
        kubernetesCloudImage {
            id = "PROJECT_EXT_25"
            profileId = "kube-5"
            agentPoolId = "-2"
            agentNamePrefix = "pod-template"
            podSpecification = customTemplate {
                customPod = """
                    apiVersion: v1
                    kind: Pod
                    spec:
                      containers:
                      - name: teamcity-agent
                        image: jetbrains/teamcity-agent:2025.03.1-windowsservercore
                        imagePullPolicy: IfNotPresent
                      nodeSelector:
                        kubernetes.io/os: windows
                """.trimIndent()
            }
        }
        kubernetesConnection {
            id = "PROJECT_EXT_26"
            name = "Dashas Cluster"
            apiServerUrl = "https://A51B42A65F7E54005C95A4D353916627.gr7.eu-west-1.eks.amazonaws.com"
            caCertificate = "credentialsJSON:4cfb95a6-dd98-454a-98d1-2dd8a28ca6dd"
            authStrategy = eks {
                accessId = "AKIA5JH2VERVAYHV5RNO"
                secretKey = "credentialsJSON:5f77bcdc-20b7-4d84-8971-f14dc824a8e7"
                clusterName = "tc-dkrupkina-eks-cluster"
            }
        }
        kubernetesCloudImage {
            id = "PROJECT_EXT_28"
            profileId = "kube-6"
            agentPoolId = "-2"
            agentNamePrefix = "windows"
            podSpecification = customTemplate {
                customPod = """
                    apiVersion: v1
                    kind: Pod
                    metadata:
                      name: teamcity-agent
                      namespace: default
                    spec:
                      restartPolicy: Never
                      containers:
                      - name: teamcity-agent
                        image: jetbrains/teamcity-agent:2025.03.1
                        imagePullPolicy: IfNotPresent
                        securityContext:
                          runAsUser: 0
                        resources:
                          limits:
                            memory: "2Gi"
                      nodeSelector:
                        kubernetes.io/os: windows
                        kubernetes.io/arch: amd64
                """.trimIndent()
            }
        }
        kubernetesCloudImage {
            id = "PROJECT_EXT_29"
            profileId = "kube-5"
            agentPoolId = "-2"
            agentNamePrefix = "linux"
            podSpecification = runContainer {
                dockerImage = "jetbrains/teamcity-agent"
            }
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
        kubernetesExecutor {
            id = "PROJECT_EXT_30"
            connectionId = "PROJECT_EXT_3"
            profileName = "K8S Executor"
            enabled = true
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
            caCertificate = "credentialsJSON:b5a2935a-eda9-4e36-b4e0-398d6c833371"
            namespace = "meow"
            authStrategy = clientCertificateAndKey {
                clientKey = "credentialsJSON:43b46ece-15a7-4621-a271-7d2b33e9e356"
                clientCertificate = "credentialsJSON:87a6537c-cb8f-4684-b44d-e0ea183e9fa1"
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
        kubernetesCloudProfile {
            id = "kube-5"
            enabled = false
            name = "K8S Test"
            terminateAfterBuild = true
            terminateIdleMinutes = 30
            apiServerURL = "https://6c60846089ad8c095bed3b18ff6d84a0.gr7.eu-west-1.eks.amazonaws.com"
            caCertData = "credentialsJSON:c77bc0a7-f461-4ca8-959b-ee5c8f6389b6"
            namespace = "executor-pods"
            authStrategy = token {
                token = "credentialsJSON:fa92592e-ec16-4543-add0-1cdd4de87e5e"
            }
        }
        kubernetesCloudProfile {
            id = "kube-6"
            enabled = false
            name = "Dasha Cluster"
            terminateIdleMinutes = 30
            apiServerURL = "https://A51B42A65F7E54005C95A4D353916627.gr7.eu-west-1.eks.amazonaws.com"
            caCertData = "credentialsJSON:4cfb95a6-dd98-454a-98d1-2dd8a28ca6dd"
            authStrategy = eks {
                accessId = "AKIA5JH2VERVAYHV5RNO"
                secretKey = "credentialsJSON:5f77bcdc-20b7-4d84-8971-f14dc824a8e7"
                clusterName = "tc-dkrupkina-eks-cluster"
            }
        }
    }

    subProject(ChildProject.Project)
})
