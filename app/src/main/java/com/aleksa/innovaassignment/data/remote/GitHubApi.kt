package com.aleksa.innovaassignment.data.remote

import com.aleksa.innovaassignment.model.RepositoryItem
import com.aleksa.innovaassignment.model.RepositoryTag
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {

    @GET("users/octocat/repos")
    suspend fun getRepositories(): Response<List<RepositoryItem>>

    @GET("/repos/octocat/{repo}/tags")
    suspend fun getTags(@Path("repo") repoName: String): Response<List<RepositoryTag>>
}