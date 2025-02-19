import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.parallelTests
import jetbrains.buildServer.configs.kotlin.buildFeatures.swabra
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.projectFeatures.bitbucketServerConnection
import jetbrains.buildServer.configs.kotlin.projectFeatures.hashiCorpVaultConnection
import jetbrains.buildServer.configs.kotlin.projectFeatures.kubernetesConnection
import jetbrains.buildServer.configs.kotlin.projectFeatures.kubernetesExecutor
import jetbrains.buildServer.configs.kotlin.triggers.vcs
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2024.12"

project {

    vcsRoot(KubernetesExample_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain2)
    vcsRoot(KubernetesExample_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain)
    vcsRoot(KubernetesExample_HttpsBbdatacenterQaTeamcityComScmTestuserMailTestJavaMavenJunitGit)
    vcsRoot(KubernetesExample_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain1)

    buildType(KubernetesExample_BuildParallelTests)
    buildType(KubernetesExample_Build)
    buildType(KubernetesExample_ThisIsSupposedToBeAVeryLongNameToSeeIfICanBreakStuffUwuSlay)

    params {
        text("testMeow", "meow?", description = "meowmeow", allowEmpty = true)
        text("inherit", "meow")
        text("meow", "meow", description = "MeowMeow!")
    }

    features {
        feature {
            id = "Fake-6"
            type = "CloudProfile"
            param("profileId", "Fake-6")
            param("name", "fake")
            param("description", "")
            param("cloud-code", "Fake")
            param("terminate-idle-time", "30")
            param("enabled", "true")
        }
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
            url = "http://127.0.0.1:8200"
            authMethod = appRole {
                roleId = "f3e75c6b-118b-48a1-97fc-6b8a69eb3bc3"
                secretId = "credentialsJSON:a90c9e97-f71b-4571-bfff-24f0eb0db85b"
            }
            failOnError = false
        }
    }

    subProject(KubernetesExample_ChildProject)
}

object KubernetesExample_Build : BuildType({
    id("Build")
    name = "Build"

    params {
        param("vaultParam", "meow")
        param("env.DOTNET_CLI_HOME", "/tmp/DOTNET_CLI_HOME")
        param("env.XDG_DATA_HOME", "/tmp")
        param("meow", "meowmeow")
        param("TEST", "")
        param("inherit", "meow?")
    }

    vcs {
        root(KubernetesExample_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain)
    }

    steps {
        script {
            id = "simpleRunner_1"
            enabled = false
            scriptContent = """
                echo "##teamcity[setParameter name='TEST' value='test']"
                echo '%vaultParam%' > meow.txt
                sleep 30
            """.trimIndent()
        }
        script {
            id = "simpleRunner"
            enabled = false
            scriptContent = """
                echo '%vaultParam%' >> meow.txt
                echo '%TEST%' >> meow.txt
                sleep 30
            """.trimIndent()
        }
        gradle {
            id = "gradle_runner"
            enabled = false
            tasks = "clean build"
            param("teamcity.kubernetes.executor.pull.policy", "+Present")
        }
        script {
            id = "dotnet"
            scriptContent = """
                env > .env
                /usr/share/dotnet/dotnet msbuild
            """.trimIndent()
            param("teamcity.kubernetes.executor.container.image", "mcr.microsoft.com/dotnet/sdk:7.0")
        }
    }

    triggers {
        vcs {
        }
    }

    features {
        swabra {
        }
    }
})

object KubernetesExample_BuildParallelTests : BuildType({
    id("BuildParallelTests")
    name = "Build - Parallel Tests"

    vcs {
        root(KubernetesExample_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain2)
    }

    steps {
        gradle {
            id = "gradle_runner"
            tasks = "clean build"
            gradleWrapperPath = ""
        }
    }

    triggers {
        vcs {
        }
    }

    features {
        parallelTests {
            numberOfBatches = 2
        }
    }
})

object KubernetesExample_ThisIsSupposedToBeAVeryLongNameToSeeIfICanBreakStuffUwuSlay : BuildType({
    id("ThisIsSupposedToBeAVeryLongNameToSeeIfICanBreakStuffUwuSlay")
    name = "this is supposed to be a very long name to see if I can break stuff uwu slay"

    vcs {
        root(KubernetesExample_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain)
    }

    steps {
        maven {
            id = "Maven2"
            enabled = false
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
        }
        dotnetBuild {
            name = "dotnettest"
            id = "dotnettest"
            param("teamcity.kubernetes.executor.container.image", "mcr.microsoft.com/dotnet/sdk:8.0")
        }
    }

    triggers {
        vcs {
        }
    }
})

object KubernetesExample_HttpsBbdatacenterQaTeamcityComScmTestuserMailTestJavaMavenJunitGit : GitVcsRoot({
    id("HttpsBbdatacenterQaTeamcityComScmTestuserMailTestJavaMavenJunitGit")
    name = "https://bbdatacenter.qa.teamcity.com/scm/~testuser_mail.test/java-maven-junit.git"
    url = "https://bbdatacenter.qa.teamcity.com/scm/~testuser_mail.test/java-maven-junit.git"
    branch = "refs/heads/master"
    authMethod = password {
        userName = "admin"
        password = "credentialsJSON:e04e7bdc-2a50-49a7-be64-7045d3df76dd"
    }
})

object KubernetesExample_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain : GitVcsRoot({
    id("HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain")
    name = "https://github.com/SocksDevil/teamcity-aws-lambda-plugin-example#refs/heads/main"
    url = "https://github.com/SocksDevil/teamcity-aws-lambda-plugin-example"
    branch = "refs/heads/main"
    branchSpec = "refs/heads/*"
    authMethod = password {
        userName = "SocksDevil"
        password = "credentialsJSON:2091df62-b0a6-494c-9dd1-b03db1aaf9c6"
    }
})

object KubernetesExample_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain1 : GitVcsRoot({
    id("HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain1")
    name = "https://github.com/SocksDevil/teamcity-aws-lambda-plugin-example#refs/heads/main (1)"
    url = "https://github.com/SocksDevil/teamcity-aws-lambda-plugin-example"
    branch = "refs/heads/main"
    branchSpec = "refs/heads/*"
    authMethod = password {
        userName = "SocksDevil"
        password = "credentialsJSON:2091df62-b0a6-494c-9dd1-b03db1aaf9c6"
    }
})

object KubernetesExample_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain2 : GitVcsRoot({
    id("HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain2")
    name = "https://github.com/SocksDevil/teamcity-aws-lambda-plugin-example#refs/heads/main (2)"
    url = "https://github.com/SocksDevil/teamcity-aws-lambda-plugin-example"
    branch = "refs/heads/main"
    branchSpec = "refs/heads/*"
    authMethod = password {
        userName = "SocksDevil"
        password = "credentialsJSON:2091df62-b0a6-494c-9dd1-b03db1aaf9c6"
    }
})


object KubernetesExample_ChildProject : Project({
    id("ChildProject")
    name = "Child Project"

    vcsRoot(KubernetesExample_ChildProject_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain)

    buildType(KubernetesExample_ChildProject_Build)

    features {
        feature {
            id = "PROJECT_EXT_4"
            type = "BuildExecutor"
            param("profileName", "Subproject Executor")
            param("executorType", "FakeExecutor")
        }
    }
})

object KubernetesExample_ChildProject_Build : BuildType({
    id("ChildProject_Build")
    name = "Build"

    vcs {
        root(KubernetesExample_ChildProject_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain)
    }

    steps {
        gradle {
            id = "gradle_runner"
            tasks = "clean build"
            gradleWrapperPath = ""
        }
    }

    triggers {
        vcs {
        }
    }
})

object KubernetesExample_ChildProject_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain : GitVcsRoot({
    id("ChildProject_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain")
    name = "https://github.com/SocksDevil/teamcity-aws-lambda-plugin-example#refs/heads/main"
    url = "https://github.com/SocksDevil/teamcity-aws-lambda-plugin-example"
    branch = "refs/heads/main"
    branchSpec = "refs/heads/*"
    authMethod = password {
        userName = "SocksDevil"
        password = "credentialsJSON:2091df62-b0a6-494c-9dd1-b03db1aaf9c6"
    }
})
