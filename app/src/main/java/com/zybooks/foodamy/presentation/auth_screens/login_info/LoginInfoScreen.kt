package com.zybooks.foodamy.presentation.auth_screens.login_info

import android.annotation.SuppressLint
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.zybooks.foodamy.presentation.navigation.Screen
import com.zybooks.foodamy.ui.components.DividerText
import com.zybooks.foodamy.ui.components.OutlineTextFieldUserInput
import com.zybooks.foodamy.ui.theme.DarkBlue
import com.zybooks.foodamy.ui.theme.DarkGreen
import com.zybooks.foodamy.ui.theme.DarkRed
import com.zybooks.foodamy.util.TestTags
import kotlinx.coroutines.CoroutineScope

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginInfoScreen(
    navController: NavHostController,
    viewModel: LoginInfoViewModel = hiltViewModel(),
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    val scaffoldState = rememberScaffoldState()
    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    val tag = "LoginInfoScreen"

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
                        Text("Login", textAlign = TextAlign.Center, color = Color.White)
                    }
                },
                backgroundColor = DarkRed,
            )
        },
        scaffoldState = scaffoldState,

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
                    .testTag(TestTags.Login_Facebook_Button),
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
                    .testTag(TestTags.Login_Google_Button),
                onClick = {},
                enabled = true,
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(backgroundColor = DarkRed)
            ) {
                Text(text = "Login with Google", color = Color.White, textAlign = TextAlign.Center)
            }

            DividerText("Or")


            OutlineTextFieldUserInput(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 0.dp, 16.dp)
                    .testTag(TestTags.Login_Email_Textfield),
                value = viewModel.state.email,
                onValueChange = { viewModel.updateEmail(it) },
                label = { Text(text = "Email or Username") },
                singleLine = true,
                placeholder = { Text("Email or Username") },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                )

            )



            OutlineTextFieldUserInput(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 0.dp, 16.dp)
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


                    val description = if (passwordVisible) "Hide password" else "Show password"

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, description)
                    }
                }
            )



            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 0.dp, 16.dp)

            ) {
                ClickableText(
                    modifier = Modifier
                        .testTag(TestTags.Sign_Up_Text_Click),
                    text = AnnotatedString("Sign Up"),
                    style = TextStyle(Color.Black, fontWeight = Bold, textAlign = TextAlign.Left),
                    onClick = { onClick ->
                        navController.navigate(Screen.Register.route)
                        Log.d("ClickableText", "$onClick -th character is clicked.")
                    }
                )

                Spacer(Modifier.weight(1f))

                ClickableText(
                    modifier = Modifier
                        .testTag(TestTags.Forgot_Password_Text_Click),
                    text = AnnotatedString("Forgot Password"),
                    style = TextStyle(Color.Black, fontWeight = Bold, textAlign = TextAlign.Right),
                    onClick = { offset ->
                        navController.navigate(Screen.ForgotPassword.route)
                        Log.d("ClickableText", "$offset -th character is clicked.")
                    }
                )
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
                    .testTag(TestTags.Login_Button),
                onClick = {
                    Log.d(tag, viewModel.state.email + " " + viewModel.state.password + viewModel.state.isValid.toString())
                    viewModel.login()
                        navController.navigate(Screen.AppScaffold.route){
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true

                    }

//                    coroutineScope.launch {
//                        delay(3000)
//                        scaffoldState.snackbarHostState.showSnackbar(
//                            message = viewModel.state.snackBarMessage
//
//                        )
//
//                    }



                },
                enabled = true,
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(backgroundColor = DarkGreen)
            ) {
                Text(text = "Login", color = Color.White, textAlign = TextAlign.Center)
            }
        }
    }

}






