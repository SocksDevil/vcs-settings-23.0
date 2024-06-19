import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.projectFeatures.kubernetesExecutor
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

version = "2024.03"

project {

    vcsRoot(HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain)

    buildType(Build)

    features {
        feature {
            id = "PROJECT_EXT_3"
            type = "OAuthProvider"
            param("secure:authToken", "credentialsJSON:fa92592e-ec16-4543-add0-1cdd4de87e5e")
            param("displayName", "EKS Connection")
            param("apiServerUrl", "https://6c60846089ad8c095bed3b18ff6d84a0.gr7.eu-west-1.eks.amazonaws.com")
            param("authStrategy", "token")
            param("namespace", "executor-pods")
            param("secure:caCertData", "credentialsJSON:c77bc0a7-f461-4ca8-959b-ee5c8f6389b6")
            param("providerType", "KubernetesConnection")
        }
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
        }
        feature {
            id = "PROJECT_EXT_5"
            type = "OAuthProvider"
            param("secure:authToken", "credentialsJSON:df987c3f-e01d-4a37-b75d-b270c95f2a2f")
            param("displayName", "JetBrains Console")
            param("apiServerUrl", "https://1d9de0392c8cfac214189045f2125202.gr7.eu-west-1.eks.amazonaws.com")
            param("authStrategy", "token")
            param("namespace", "teamcity-cloud")
            param("secure:caCertData", "credentialsJSON:ffe4af77-1daf-4824-975f-a6778d5566fd")
            param("providerType", "KubernetesConnection")
        }
    }

    subProject(ChildProject)
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain)
    }

    steps {
        gradle {
            id = "gradle_runner"
            tasks = "clean build"
            gradleWrapperPath = ""
        }
    }

    triggers {
        trigger {
            type = "vcsTrigger"
        }
    }
})

object HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain : GitVcsRoot({
    name = "https://github.com/SocksDevil/teamcity-aws-lambda-plugin-example#refs/heads/main"
    url = "https://github.com/SocksDevil/teamcity-aws-lambda-plugin-example"
    branch = "refs/heads/main"
    branchSpec = "refs/heads/*"
    authMethod = password {
        userName = "SocksDevil"
        password = "credentialsJSON:2091df62-b0a6-494c-9dd1-b03db1aaf9c6"
    }
})


object ChildProject : Project({
    name = "Child Project"

    vcsRoot(ChildProject_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain)

    buildType(ChildProject_Build)
})

object ChildProject_Build : BuildType({
    name = "Build"

    vcs {
        root(ChildProject_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain)
    }

    steps {
        gradle {
            id = "gradle_runner"
            tasks = "clean build"
            gradleWrapperPath = ""
        }
    }

    triggers {
        trigger {
            type = "vcsTrigger"
        }
    }
})

object ChildProject_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain : GitVcsRoot({
    name = "https://github.com/SocksDevil/teamcity-aws-lambda-plugin-example#refs/heads/main"
    url = "https://github.com/SocksDevil/teamcity-aws-lambda-plugin-example"
    branch = "refs/heads/main"
    branchSpec = "refs/heads/*"
    authMethod = password {
        userName = "SocksDevil"
        password = "credentialsJSON:2091df62-b0a6-494c-9dd1-b03db1aaf9c6"
    }
})
