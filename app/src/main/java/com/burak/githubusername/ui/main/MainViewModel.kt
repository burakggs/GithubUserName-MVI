package com.burak.githubusername.ui.main

import com.burak.githubusername.core.BaseState
import com.burak.githubusername.core.BaseViewModel
import com.burak.githubusername.core.NativeAction
import com.burak.githubusername.data.response.UserRepo

class MainViewModel : BaseViewModel<MainScreenState, MainScreenEvent>() {


    override fun initialState(): MainScreenState {
        return MainScreenState()
    }

    fun submitButtonClicked() {

    }

    fun itemClicked() {

    }

    fun addFavorite() {

    }

}

data class MainScreenState(val userName: String = "", val repoList: List<UserRepo> = emptyList()) :
    BaseState()

sealed class MainScreenEvent : NativeAction()