package com.zybooks.foodamy.presentation.register_info

import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.zybooks.foodamy.ui.components.OutlineTextFieldWithError
import com.zybooks.foodamy.ui.theme.DarkBlue
import com.zybooks.foodamy.ui.theme.DarkRed
import com.zybooks.foodamy.util.TestTags

@Composable
fun RegisterInfoScreen(
    //navController: NavController,
    viewModel: RegisterInfoViewModel = hiltViewModel()
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        modifier = Modifier
            .padding(0.dp, 0.dp, 0.dp, 16.dp),

        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Sign Up", textAlign = TextAlign.Center, color = Color.White)
                    }
                },
                backgroundColor = DarkRed
            )
        },
        scaffoldState = scaffoldState
    ) {

        Column(
            modifier = Modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            DividerText("Connect With Your Social Media Account")

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 0.dp, 16.dp)
                    .height(45.dp)
                    .testTag(TestTags.Register_Facebook_Button),
                onClick = {},
                enabled = true,
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(backgroundColor = DarkBlue)
            ) {
                Text(
                    text = "Login with Facebook",
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 0.dp, 16.dp)
                    .height(45.dp)
                    .testTag(TestTags.Register_Google_Button),
                onClick = {},
                enabled = true,
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(backgroundColor = DarkRed)
            ) {
                Text(text = "Login with Google", color = Color.White, textAlign = TextAlign.Center)
            }

            DividerText("Or")
            OutlineTextFieldWithError(
                textStyle = TextStyle(textAlign = TextAlign.Left),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 0.dp, 16.dp)
                    .testTag(TestTags.Register_Username_Textfield),
                value = viewModel.state.username,
                onValueChange = { viewModel.updateUsername(it) },
                label = { Text(text = "User name") },
                singleLine = true,
                placeholder = { Text("User name") },
                isError = false,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                ),
                errorMessage = "Invalid UserName"
            )


            OutlineTextFieldWithError(
                textStyle = TextStyle(textAlign = TextAlign.Left),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 0.dp, 16.dp)
                    .testTag(TestTags.Login_Email_Textfield),
                value = viewModel.state.email,
                onValueChange = { viewModel.updateEmail(it) },
                label = { Text(text = "Email or Username") },
                singleLine = true,
                placeholder = { Text("Email or Username") },
                isError = viewModel.state.isEmailError,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                ),
                errorMessage = "Invalid Email"
            )

            OutlineTextFieldWithError(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 0.dp, 16.dp)
                    .testTag(TestTags.Login_Password_Textfield),
                value = viewModel.state.password,
                onValueChange = { viewModel.updatePassword(it) },
                label = { Text("Password") },
                singleLine = true,
                isError = viewModel.state.isPasswordError,
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
                },
                errorMessage = "Invalid Password"

            )



            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
                    .testTag(TestTags.Login_Button),
                onClick = {
                    viewModel.validateEmail()
                    viewModel.validatePassword()
                },
                enabled = true,
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
            ) {
                Text(text = "Sign Up", color = Color.White, textAlign = TextAlign.Center)
            }
        }
    }

}

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

@Preview
@Composable
fun LoginInfoScreenPreview() {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        DividerText("Connect With Your Social Media Account")

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 16.dp)
                .height(45.dp)
                .testTag(TestTags.Register_Facebook_Button),
            onClick = {},
            enabled = true,
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(backgroundColor = DarkBlue)
        ) {
            Text(text = "Login with Facebook", color = Color.White, textAlign = TextAlign.Center)
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 16.dp)
                .height(45.dp)
                .testTag(TestTags.Register_Google_Button),
            onClick = {},
            enabled = true,
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(backgroundColor = DarkRed)
        ) {
            Text(text = "Login with Google", color = Color.White, textAlign = TextAlign.Center)
        }

        DividerText("Or")
        TextField(
            textStyle = TextStyle(textAlign = TextAlign.Left),
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 16.dp)
                .testTag(TestTags.Register_Username_Textfield),
            value = "",
            onValueChange = {},
            label = { Text(text = "User name") },
            singleLine = true,
            placeholder = { Text("User name") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
            ),
        )


        TextField(
            textStyle = TextStyle(textAlign = TextAlign.Left),
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 16.dp)
                .testTag(TestTags.Login_Email_Textfield),
            value = "",
            onValueChange = {},
            label = { Text(text = "Email or Username") },
            singleLine = true,
            placeholder = { Text("Email or Username") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
            ),
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 16.dp)
                .testTag(TestTags.Login_Password_Textfield),
            value = "",
            onValueChange = {},
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



        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .testTag(TestTags.Login_Button),
            onClick = {},
            enabled = true,
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
        ) {
            Text(text = "Sign Up", color = Color.White, textAlign = TextAlign.Center)
        }
    }
}