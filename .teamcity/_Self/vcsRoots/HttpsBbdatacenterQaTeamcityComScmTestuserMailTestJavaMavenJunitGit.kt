package _Self.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object HttpsBbdatacenterQaTeamcityComScmTestuserMailTestJavaMavenJunitGit : GitVcsRoot({
    name = "https://bbdatacenter.qa.teamcity.com/scm/~testuser_mail.test/java-maven-junit.git"
    url = "https://bbdatacenter.qa.teamcity.com/scm/~testuser_mail.test/java-maven-junit.git"
    branch = "refs/heads/master"
    authMethod = password {
        userName = "admin"
        password = "credentialsJSON:2f85280b-1c5e-4cda-84dd-d89ca5ae4c5a"
    }
})
