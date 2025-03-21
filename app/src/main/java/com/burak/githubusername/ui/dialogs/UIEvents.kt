package com.burak.githubusername.ui.dialogs

sealed class UIEvents {

    data object Loading : UIEvents()

    data class Alert(
        val message: String,
        val confirmButtonText: String,
        val confirmButtonClick: () -> Unit
    ) : UIEvents()

    data object None : UIEvents()
}