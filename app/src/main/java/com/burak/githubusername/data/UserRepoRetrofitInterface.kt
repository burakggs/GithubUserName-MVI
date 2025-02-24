package com.burak.githubusername.data

import com.burak.githubusername.data.response.UserRepo
import retrofit2.http.GET
import retrofit2.http.Path

interface UserRepoRetrofitInterface {

    @GET("users/{user}/repos")
    suspend fun getUserRepos(@Path("user") userName: String): List<UserRepo>

}