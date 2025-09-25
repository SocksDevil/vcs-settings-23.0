package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.buildSteps.powerShell
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.matrix
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object Build : BuildType({
    name = "Build"

    params {
        param("vaultParam", "meow")
        param("env.DOTNET_CLI_HOME", "/tmp/DOTNET_CLI_HOME")
        param("env.XDG_DATA_HOME", "/tmp")
        param("meow", "meowmeow")
        param("TEST", "")
        param("inherit", "change")
    }

    vcs {
        root(_Self.vcsRoots.HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain)
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
            enabled = false
            scriptContent = """
                env > .env
                /usr/share/dotnet/dotnet msbuild
            """.trimIndent()
            param("teamcity.kubernetes.executor.container.image", "mcr.microsoft.com/dotnet/sdk:7.0")
        }
        script {
            name = "Zzzz"
            id = "Zzzz"
            scriptContent = "sleep 1"
        }
        powerShell {
            name = "Powershell"
            id = "Powershell"
            enabled = false
            scriptMode = file {
                path = "meow.ps1"
            }
            param("teamcity.kubernetes.executor.container.image", "socksdevil/teamcity-agent-powershell:latest")
            param("teamcity.kubernetes.executor.pull.policy", "Always")
        }
        dotnetBuild {
            name = "Dotnet"
            id = "Dotnet"
            enabled = false
        }
        script {
            name = "Meow"
            id = "Meow"
            scriptContent = "echo Meow"
            param("teamcity.kubernetes.executor.container.image", "lolol")
        }
        script {
            name = "banana"
            id = "banana"
            scriptContent = "echo banana"
            dockerImage = "banana"
        }
    }

    triggers {
        vcs {
        }
    }

    features {
        matrix {
            enabled = false
            param("meow", listOf(
                value("meow"),
                value("meowmeow")
            ))
            param("separateArtifacts", "false")
        }
    }

    dependencies {
        snapshot(AbsoluteId("AwsExample_Build")) {
        }
    }
})
