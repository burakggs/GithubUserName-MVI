package com.burak.githubusername.data


import android.util.Log
import io.ktor.client.plugins.logging.Logger

class AndroidLogger(private val tag: String) : Logger {

    override fun log(message: String) {
        Log.d(tag, message)
    }
}