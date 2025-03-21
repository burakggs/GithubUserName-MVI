package com.burak.githubusername.core

import androidx.lifecycle.ViewModel
import com.burak.githubusername.ui.dialogs.UIEvents
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<STATE : BaseState, EVENT : NativeAction> : ViewModel() {

    val _state: MutableStateFlow<STATE> by lazy {
        MutableStateFlow(initialState())

    }

    val state: StateFlow<STATE> = _state.asStateFlow()

    private val _event: MutableStateFlow<UIEvents> = MutableStateFlow(UIEvents.None)

    val event: StateFlow<UIEvents> = _event.asStateFlow()

    protected abstract fun initialState(): STATE

    protected fun updateState(state: STATE) {
        _state.value = state

    }

    fun showLoading() {
        _event.value = UIEvents.Loading

    }

    fun hideLoading() {
        _event.value = UIEvents.None

    }

}