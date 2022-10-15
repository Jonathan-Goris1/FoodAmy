package com.zybooks.foodamy.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DividerText(prompt: String = "This is a Test") {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 0.dp, 0.dp, 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Divider(
            modifier = Modifier
                .weight(1.0f)
                .padding(0.dp, 0.dp, 16.dp, 0.dp),
            color = Color.DarkGray,
            thickness = 1.dp
        )

        Text(
            maxLines = 1,
            text = prompt,
            color = Color.Gray
        )

        Divider(
            modifier = Modifier
                .weight(1.0f)
                .padding(16.dp, 0.dp, 0.dp, 0.dp),
            color = Color.DarkGray,
            thickness = 1.dp
        )
    }
}