package com.zybooks.foodamy.presentation.login_info

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LoginInfoScreen(

) {
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

            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
        ) {
            Text(text = "Login with Facebook", color = Color.White)
        }

        Button(

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp, vertical = 16.dp),

            onClick = {},

            enabled = true,

            shape = MaterialTheme.shapes.medium,

            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
        ) {
            Text(text = "Login with Google", color = Color.White)
        }

        DividerText()
        EmailTextField()
        PasswordTextField()

        Row(
            modifier = Modifier.fillMaxWidth()

        ) {
            ClickableText(
                modifier = Modifier.padding(8.dp, 0.dp, 0.dp, 0.dp ),
                text = AnnotatedString("Sign Up"),
                style = TextStyle(Color.Black, fontWeight = Bold, textAlign = TextAlign.Left),
                onClick = { offset ->
                    Log.d("ClickableText", "$offset -th character is clicked.")
                }
            )

            Spacer(Modifier.weight(1f))

            ClickableText(
                modifier = Modifier.padding(8.dp, 0.dp, 0.dp, 0.dp ),
                text = AnnotatedString("Forgot Password"),
                style = TextStyle(Color.Black, fontWeight = Bold, textAlign = TextAlign.Right),
                onClick = { offset ->
                    Log.d("ClickableText", "$offset -th character is clicked.")
                }
            )

        }

        Button(

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp, vertical = 16.dp),

            onClick = {},

            enabled = true,

            shape = MaterialTheme.shapes.medium,

            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
        ) {
            Text(text = "Login", color = Color.White)
        }

        


    }


}

@Composable
fun DividerText() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth(.4f)
                .padding(0.dp, 0.dp, 16.dp, 0.dp),

            color = Color.White,
            thickness = 1.dp
        )

        Text(

            maxLines = 1,
            text = "This is a testtttttttttttttt",
            color = Color.White
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 0.dp, 0.dp, 0.dp),

            color = Color.White,
            thickness = 1.dp
        )
    }
}

@Composable
fun EmailTextField(){
    var value by remember { mutableStateOf("") }

    TextField(
        textStyle = TextStyle(textAlign = TextAlign.Left),
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = {value = it },
        label = { Text( text = "Email or Username")},
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,

    ),
    )
}

@Composable
fun PasswordTextField(){

    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = password,
        onValueChange = { password = it },
        label = { Text("Password") },
        singleLine = true,
        placeholder = { Text("Password") },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,

            ),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisible)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff

            // Please provide localized description for accessibility services
            val description = if (passwordVisible) "Hide password" else "Show password"

            IconButton(onClick = {passwordVisible = !passwordVisible}){
                Icon(imageVector  = image, description)
            }
        }
    )
}




