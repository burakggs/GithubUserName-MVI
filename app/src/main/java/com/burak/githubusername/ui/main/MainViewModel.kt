package com.burak.githubusername.ui.main

import androidx.lifecycle.viewModelScope
import com.burak.githubusername.core.BaseState
import com.burak.githubusername.core.BaseViewModel
import com.burak.githubusername.core.NativeAction
import com.burak.githubusername.data.UserRepository
import com.burak.githubusername.data.response.RepoUIObject

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repository: UserRepository) :
    BaseViewModel<MainScreenState, MainScreenEvent>() {


    override fun initialState(): MainScreenState {
        return MainScreenState()
    }

    fun submitButtonClicked(userName: String) {
        viewModelScope.launch {
            showLoading()
            val result = repository.getUserRepoList(userName)
            hideLoading()
            val repoList = result.map { userRepo ->
                RepoUIObject(userRepo.name, false)

            }
            _state.value = state.value.copy(repoList = repoList)
        }
    }

    fun itemClicked() {

    }

    fun addFavorite() {

    }

}

data class MainScreenState(val repoList: List<RepoUIObject> = emptyList()) :
    BaseState()

sealed class MainScreenEvent : NativeAction()