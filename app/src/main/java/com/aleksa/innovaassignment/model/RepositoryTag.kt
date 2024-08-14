package com.aleksa.innovaassignment.model

data class RepositoryTag(
    val commit: Commit,
    val name: String,
    val node_id: String,
    val tarball_url: String,
    val zipball_url: String
)