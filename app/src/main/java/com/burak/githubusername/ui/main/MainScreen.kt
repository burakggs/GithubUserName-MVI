package com.burak.githubusername.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.burak.githubusername.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    title: String,
    showBackButton: Boolean = false,
    showActionButton: Boolean = false,
    onBackButtonClicked: () -> Unit,
    onActionButtonClicked: () -> Unit
) {
    TopAppBar(title = { Text(title) },
        navigationIcon = {
            if (showBackButton) {
                Image(
                    painterResource(R.drawable.ic_back),
                    contentDescription = "Back Button",
                    modifier = Modifier.size(20.dp),
                    colorFilter = ColorFilter.tint(Color.Black)
                )
            }
        },
        actions = {
            if (showActionButton) {
                Image(
                    painterResource(R.drawable.ic_star_selected),
                    contentDescription = "Start Button"
                )
            }

        })

}

@Preview
@Composable
fun MyTopAppBarPreview() {
    MyTopAppBar(
        title = "My App",
        showBackButton = true,
        showActionButton = true,
        onBackButtonClicked = {},
        onActionButtonClicked = {})
}