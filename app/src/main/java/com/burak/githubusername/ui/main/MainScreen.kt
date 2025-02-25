package com.burak.githubusername.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.burak.githubusername.ui.widget.MyTopAppBar
import com.burak.githubusername.ui.widget.TextFieldWithButton


@Composable
fun MainScreen(state: MainScreenState, submitButtonClicked: () -> Unit, onValueChanged: (String) -> Unit) {
    Column(modifier = Modifier.padding(horizontal = 8.dp)) {
        MyTopAppBar("Home")
        TextFieldWithButton(submitButtonClicked = submitButtonClicked, onValueChanged = onValueChanged)
        LazyColumn {
            item {
                Text("Name")
            }
            items(state.repoList) { repo ->


            }

        }
    }

}