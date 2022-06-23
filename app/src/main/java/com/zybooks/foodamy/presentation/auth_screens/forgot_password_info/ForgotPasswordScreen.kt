package com.zybooks.foodamy.presentation.auth_screens.forgot_password_info

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.zybooks.foodamy.ui.components.OutlineTextFieldUserInput
import com.zybooks.foodamy.ui.theme.DarkRed
import com.zybooks.foodamy.util.TestTags

@Composable
fun ForgotPasswordScreen(
    viewModel: ForgotPasswordViewModel = hiltViewModel(),

    ) {
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
                        Text("Forgot Password", textAlign = TextAlign.Center, color = Color.White)
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

            OutlineTextFieldUserInput(
                textStyle = TextStyle(textAlign = TextAlign.Left),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag(TestTags.Login_Email_Textfield),
                value = viewModel.state.email,
                onValueChange = { viewModel.updateEmail(it) },
                label = { Text(text = "Email or Username") },
                singleLine = true,
                placeholder = { Text("Email or Username") },


                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                ),

            )



            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
                    .testTag(TestTags.Login_Button),
                onClick = {
                    viewModel.validateEmail()

                },
                enabled = true,
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(backgroundColor = DarkRed)
            ) {
                Text(text = "Send", color = Color.White, textAlign = TextAlign.Center)
            }
        }
    }
}


@Preview
@Composable
fun ForgotPasswordScreenPreview() {

    Column(
        modifier = Modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        OutlineTextFieldUserInput(
            textStyle = TextStyle(textAlign = TextAlign.Left),
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 16.dp)
                .testTag(TestTags.Login_Email_Textfield),
            value = " ",
            onValueChange = {},
            label = { Text(text = "Email or Username") },
            singleLine = true,
            placeholder = { Text("Email or Username") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
            ),


        )


        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .testTag(TestTags.Login_Button),
            onClick = {},
            enabled = true,
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(backgroundColor = DarkRed)
        ) {
            Text(text = "Login", color = Color.White, textAlign = TextAlign.Center)
        }
    }
}