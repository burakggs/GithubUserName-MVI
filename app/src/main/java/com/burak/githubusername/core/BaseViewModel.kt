package com.burak.githubusername.core

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<STATE : BaseState, EVENT : NativeAction> : ViewModel() {

    private val _state: MutableStateFlow<STATE> by lazy {
        MutableStateFlow(initialState())

    }
    val stateStream: StateFlow<STATE> = _state.asStateFlow()

    protected abstract fun initialState(): STATE

    protected fun updateState(state: STATE) {
        _state.value = state

    }

}