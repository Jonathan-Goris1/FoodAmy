package com.zybooks.foodamy.ui.components

import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TextTabs() {
    var tabIndex by remember { mutableStateOf(0) }
    val tabData = listOf(
        "Editors Choice",
        "Recently Added"

    )
    TabRow(
        selectedTabIndex = tabIndex,
        backgroundColor = Color.White,
        contentColor = Color.Black,
        divider = {
            TabRowDefaults.Divider(
                thickness = 5.dp,
                color = Color.White
            )
        },
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[tabIndex]),
                height = 5.dp,
                color = Color.Red
            )
        }
    ) {
        tabData.forEachIndexed { index, text ->
            Tab(selected = tabIndex == index, onClick = {
                tabIndex = index
            }, text = {
                Text(text = text, fontWeight = FontWeight.Bold)
            })
        }
    }
}

