package KubernetesExample.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

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
