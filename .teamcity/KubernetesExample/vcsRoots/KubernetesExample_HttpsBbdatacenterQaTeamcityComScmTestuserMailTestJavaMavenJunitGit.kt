package KubernetesExample.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

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
