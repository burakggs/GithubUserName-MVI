package com.burak.githubusername.data.disk

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferencesLocalStore @Inject constructor(
    val context: Context
) : LocalStore {

    override fun saveFavorite(userName: String, repoId: String) {
        getSharedPreferences().edit().putString(userName, repoId).apply()
    }

    override fun getFavorites(userName: String): List<String> {
        val favoritesAsStr = getSharedPreferences().getString(userName, null)
        return emptyList()
    }

    private fun getSharedPreferences(): SharedPreferences {
        return context.getSharedPreferences("favorites", Context.MODE_PRIVATE)

    }

}