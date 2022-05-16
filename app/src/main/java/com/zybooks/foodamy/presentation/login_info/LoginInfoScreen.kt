package com.zybooks.foodamy.presentation.login_info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun LoginInfoScreen() {
    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        DividerText()

        Button(

            modifier = Modifier
                .fillMaxWidth(),
            
            onClick = {},

            enabled = true,

            shape = MaterialTheme.shapes.medium,

            colors = ButtonDefaults.buttonColors(backgroundColor = androidx.compose.ui.graphics.Color.Blue)
        ) {
            Text(text = "Login with Facebook", color = androidx.compose.ui.graphics.Color.White)
        }

        Button(

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp, vertical = 16.dp),

            onClick = {},

            enabled = true,

            shape = MaterialTheme.shapes.medium,

            colors = ButtonDefaults.buttonColors(backgroundColor = androidx.compose.ui.graphics.Color.Red)
        ) {
            Text(text = "Login with Google", color = androidx.compose.ui.graphics.Color.White)
        }

        DividerText()




    }


}

@Composable
fun DividerText(){
    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth(.4f)
                .padding(0.dp, 0.dp, 16.dp, 0.dp)
            ,

            color = Color.White,
            thickness = 1.dp)

        Text(
            modifier = Modifier.padding(0.dp, 0.dp, 16.dp, 0.dp),
            text = "This is a test",
            color = Color.White
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth()
            ,

            color = Color.White,
            thickness = 1.dp)

    }
}

@Preview
@Composable
fun Social() {
    val dividerId = "inlineDividerId"
    val text = buildAnnotatedString {

        appendInlineContent(dividerId, "[divider]")

        append(AnnotatedString(" Twitter ", spanStyle = SpanStyle(Color.White)))

        appendInlineContent(dividerId, "[divider]")

    }

    val inlineDividerContent = mapOf(
        Pair(
            // This tells the [CoreText] to replace the placeholder string "[divider]" by
            // the composable given in the [InlineTextContent] object.
            dividerId,
            InlineTextContent(
                // Placeholder tells text layout the expected size and vertical alignment of
                // children composable.
                Placeholder(
                    width = 0.15.em,
                    height = 0.90.em,
                    placeholderVerticalAlign = PlaceholderVerticalAlign.TextCenter
                )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.DarkGray)
                )
            }
        )
    )

    BasicText(text = text, inlineContent = inlineDividerContent, style = TextStyle(fontSize = 17.sp))
}


