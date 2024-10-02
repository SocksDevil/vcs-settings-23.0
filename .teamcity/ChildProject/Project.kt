package ChildProject

import ChildProject.buildTypes.*
import ChildProject.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project

object Project : Project({
    id("ChildProject")
    name = "Child Project"

    vcsRoot(ChildProject_HttpsGithubComSocksDevilTeamcityAwsLambdaPluginExampleRefsHeadsMain)

    buildType(ChildProject_Build)
})
