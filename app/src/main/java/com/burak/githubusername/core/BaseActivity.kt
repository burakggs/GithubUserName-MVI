package com.burak.githubusername.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.burak.githubusername.ui.theme.GithubUserNameTheme


abstract class BaseActivity<STATE : BaseState, ACTION : NativeAction, VM : BaseViewModel<STATE, ACTION>>(
    private val viewModelClass: Class<VM>
) :
    ComponentActivity() {

    val viewModel by lazy {
        ViewModelProvider(this)[viewModelClass]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            GithubUserNameTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val uiState: STATE by viewModel.stateStream.collectAsStateWithLifecycle()

                    ScreenContent(uiState)

                }
            }
        }
    }

    @Composable
    abstract fun ScreenContent(state: STATE)

}