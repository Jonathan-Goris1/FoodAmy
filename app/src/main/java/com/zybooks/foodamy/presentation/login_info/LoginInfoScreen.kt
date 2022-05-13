package com.zybooks.foodamy.presentation.login_info

import android.text.Layout
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun LoginInfoScreen() {
    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Button(

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp, vertical = 16.dp ),

            onClick = {},

            enabled = true,

            shape = MaterialTheme.shapes.medium,

            colors = ButtonDefaults.buttonColors(backgroundColor = androidx.compose.ui.graphics.Color.Blue)
        ) {
            Text(text = "Sign in with Facebook", color = androidx.compose.ui.graphics.Color.White)
        }

        Button(

            modifier = Modifier
                .fillMaxWidth(),

            onClick = {},

            enabled = true,

            shape = MaterialTheme.shapes.medium,

            colors = ButtonDefaults.buttonColors(backgroundColor = androidx.compose.ui.graphics.Color.Red)
        ) {
            Text(text = "Sign in with Google", color = androidx.compose.ui.graphics.Color.White)
        }



    }


}


