package com.burak.githubusername.data

import com.burak.githubusername.data.response.UserRepo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class UserRepository @Inject constructor(val retrofit: Retrofit){

    private val service: UserRepoRetrofitInterface =
        retrofit.create(UserRepoRetrofitInterface::class.java)

    suspend fun getUserRepos(userName: String): List<UserRepo> {
        return service.getUserRepos(userName)
    }
}