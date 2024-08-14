package com.aleksa.innovaassignment.data.repository

import com.aleksa.innovaassignment.data.remote.GitHubApi

class GitHubRepository(private val gitHubApi: GitHubApi) {

    /**
     * Remote
     */
    suspend fun getRepositories() = gitHubApi.getRepositories()

    suspend fun getTags(repoName: String) = gitHubApi.getTags(repoName)


}