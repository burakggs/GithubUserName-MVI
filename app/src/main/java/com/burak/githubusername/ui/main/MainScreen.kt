package com.burak.githubusername.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.burak.githubusername.data.response.RepoUIObject
import com.burak.githubusername.ui.widget.TextFieldWithButton


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    state: MainScreenState,
    submitButtonClicked: (String) -> Unit,
) {
    val lazyListState = rememberLazyListState()

    Column {
        TopAppBar(title = { Text("Home") }, modifier = Modifier)
        TextFieldWithButton(
            submitButtonClicked = submitButtonClicked,
        )
        LazyColumn(state = lazyListState) {
            itemsIndexed(state.repoList) { index, repo ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    Column {
                        Row {
                            Text(
                                repo.repoName ?: "",
                                modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp)
                            )
                        }
                        HorizontalDivider()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    val repoUIObject = listOf(
        RepoUIObject("test", true),
        RepoUIObject("test2", false),
        RepoUIObject("test3", true)
    )
    MainScreen(MainScreenState(repoList = repoUIObject), {})
}