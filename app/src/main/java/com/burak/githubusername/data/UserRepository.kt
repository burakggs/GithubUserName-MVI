package com.burak.githubusername.data

import com.burak.githubusername.data.response.UserRepo
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class UserRepository @Inject constructor() : BaseRepository() {

    suspend fun getUserRepoList(userName: String): List<UserRepo> {
        return withContext(Dispatchers.IO) {
            makeGetRequest(userName, object : TypeToken<List<UserRepo>>() {}.type)
        }

    }

    suspend fun getRepoDetail(id: Int): UserRepo {
        return makeGetRequest("test", object : TypeToken<UserRepo>() {}.type)
    }
}