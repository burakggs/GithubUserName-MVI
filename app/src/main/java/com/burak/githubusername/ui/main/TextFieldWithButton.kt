package com.burak.githubusername.ui.main

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun TextFieldWithButton(submitButtonClicked: () -> Unit, onValueChanged: (String) -> Unit) {

    var value by remember { mutableStateOf("") }

    Row {
        TextField(value = value, onValueChange = {
            value = it
            onValueChanged(it)
        })
        Spacer(modifier = Modifier.size(8.dp))
        Button(
            onClick = { submitButtonClicked() }, colors = ButtonColors(
                containerColor = Color.Black, contentColor = Color.White,
                disabledContainerColor = Color.Black,
                disabledContentColor = Color.White
            ), shape = RectangleShape
        ) {
            Text("Submit")
        }
    }
}

@Preview
@Composable
fun TextFieldWithButtonPreview() {
    TextFieldWithButton(submitButtonClicked = {}, onValueChanged = {})
}