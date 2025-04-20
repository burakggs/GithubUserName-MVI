package com.burak.githubusername.data.response

import com.google.gson.annotations.SerializedName


data class RepoUIObject(val id: String?, val repoName: String?, val favorite: Boolean?)

data class UserRepo(
    val id: String?,
    val name: String?,
    @SerializedName("stargazers_count") val starCount: Int?,
    @SerializedName("open_issues_count") val openIssuesCount: Int?,
    val owner: Owner?
)

data class Owner(
    @SerializedName("avatar_url") val avatarImage: String?,
    @SerializedName("login") val name: String?
)