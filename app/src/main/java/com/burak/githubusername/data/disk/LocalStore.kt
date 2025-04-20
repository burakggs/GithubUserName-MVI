package com.burak.githubusername.data.disk

interface LocalStore {

    fun saveFavorite(userName: String, repoId: String)

    fun getFavorites(userName: String): List<String>

}