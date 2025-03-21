package com.burak.githubusername.data

import com.google.gson.Gson
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import java.lang.reflect.Type
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class BaseRepository {

    @Inject
    lateinit var client: HttpClient

    val gson: Gson = Gson()

    suspend fun <T> makeGetRequest(param: String, type: Type): T {
        val httpResponse = client.get("https://api.github.com/users/$param/repos")
        val text = httpResponse.bodyAsText()

        return gson.fromJson(text, type)
    }

}