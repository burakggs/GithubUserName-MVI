package com.burak.githubusername.ui.main


import androidx.compose.runtime.Composable
import com.burak.githubusername.core.BaseActivity


class MainActivity :
    BaseActivity<MainScreenState, MainScreenEvent, MainViewModel>(MainViewModel::class.java) {


    @Composable
    override fun ScreenContent(state: MainScreenState) {
        MainScreen(
            state = state,
            submitButtonClicked = { viewModel.submitButtonClicked() },
            onValueChanged = {})
    }
}