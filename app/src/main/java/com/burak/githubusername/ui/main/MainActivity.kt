package com.burak.githubusername.ui.main


import androidx.compose.runtime.Composable
import com.burak.githubusername.core.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity :
    BaseActivity<MainScreenState, MainScreenEvent, MainViewModel>(MainViewModel::class.java) {


    @Composable
    override fun ScreenContent(state: MainScreenState) {
        MainScreen(
            state = state,
            submitButtonClicked = { viewModel.submitButtonClicked(it) })
    }
}