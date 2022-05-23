package com.zybooks.foodamy.presentation.login_info

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.zybooks.foodamy.util.TestTags

@Composable
fun LoginInfoScreen(
    viewModel: LoginInfoViewModel = hiltViewModel()
) {


    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        DividerText()

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .testTag(TestTags.Login_Facebook_Button),
            onClick = {},
            enabled = true,
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
        ) {
            Text(text = "Login with Facebook", color = Color.White) }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp, vertical = 16.dp)
                .testTag(TestTags.Login_Google_Button),
            onClick = {},
            enabled = true,
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
        ) {
            Text(text = "Login with Google", color = Color.White)}

        DividerText()

        TextField(
            textStyle = TextStyle(textAlign = TextAlign.Left),
            modifier = Modifier
                .fillMaxWidth()
                .testTag(TestTags.Login_Email_Textfield),
            value = viewModel.state.email,
            onValueChange = { viewModel.updateEmail(it) },
            label = { Text(text = "Email or Username") },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                ),
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .testTag(TestTags.Login_Password_Textfield),
            value = viewModel.state.password,
            onValueChange = { viewModel.updatePassword(it) },
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

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, description)
                }
            }
        )

        Row(
            modifier = Modifier.fillMaxWidth()

        ) {
            ClickableText(
                modifier = Modifier
                    .padding(8.dp, 0.dp, 0.dp, 0.dp)
                    .testTag(TestTags.Sign_Up_Text_Click),
                text = AnnotatedString("Sign Up"),
                style = TextStyle(Color.Black, fontWeight = Bold, textAlign = TextAlign.Left),
                onClick = { offset ->
                    Log.d("ClickableText", "$offset -th character is clicked.") }
            )

            Spacer(Modifier.weight(1f))

            ClickableText(
                modifier = Modifier
                    .padding(8.dp, 0.dp, 0.dp, 0.dp)
                    .testTag(TestTags.Forgot_Password_Text_Click),
                text = AnnotatedString("Forgot Password"),
                style = TextStyle(Color.Black, fontWeight = Bold, textAlign = TextAlign.Right),
                onClick = { offset ->
                    Log.d("ClickableText", "$offset -th character is clicked.") }
            )}

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp, vertical = 16.dp)
                .testTag(TestTags.Login_Button),
            onClick = {},
            enabled = true,
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
        ) {
            Text(text = "Login", color = Color.White)}
    }
}

@Composable
fun DividerText() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Divider(
            modifier = Modifier
                .weight(1.0f)
                .padding(0.dp, 0.dp, 16.dp, 0.dp),

            color = Color.Gray,
            thickness = 1.dp
        )

        Text(

            maxLines = 1,
            text = "This is a test",
            color = Color.Gray
        )

        Divider(
            modifier = Modifier
                .weight(1.0f)
                .padding(16.dp, 0.dp, 0.dp, 0.dp),

            color = Color.Gray,
            thickness = 1.dp
        )
    }
}

@Preview
@Composable
fun LoginInfoScreenPreview(){
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

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
            Text(text = "Login with Facebook", color = Color.White) }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp, vertical = 16.dp),
            onClick = {},
            enabled = true,
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
        ) {
            Text(text = "Login with Google", color = Color.White)}

        DividerText()
        TextField(
            textStyle = TextStyle(textAlign = TextAlign.Left),
            modifier = Modifier.fillMaxWidth(),
            value =  " ",
            onValueChange = { it },
            label = { Text(text = "Email or Username") },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
            ),
        )
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

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, description)
                }
            }
        )

        Row(
            modifier = Modifier.fillMaxWidth()

        ) {
            ClickableText(
                modifier = Modifier.padding(8.dp, 0.dp, 0.dp, 0.dp),
                text = AnnotatedString("Sign Up"),
                style = TextStyle(Color.Black, fontWeight = Bold, textAlign = TextAlign.Left),
                onClick = { offset ->
                    Log.d("ClickableText", "$offset -th character is clicked.") }
            )

            Spacer(Modifier.weight(1f))

            ClickableText(
                modifier = Modifier.padding(8.dp, 0.dp, 0.dp, 0.dp),
                text = AnnotatedString("Forgot Password"),
                style = TextStyle(Color.Black, fontWeight = Bold, textAlign = TextAlign.Right),
                onClick = { offset ->
                    Log.d("ClickableText", "$offset -th character is clicked.") }
            )}

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp, vertical = 16.dp),
            onClick = {},
            enabled = true,
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
        ) {
            Text(text = "Login", color = Color.White)}
    }
}




