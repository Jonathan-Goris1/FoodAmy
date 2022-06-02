package com.zybooks.foodamy.presentation.login_info

import android.util.Log
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
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
import androidx.compose.ui.graphics.Shape
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
import androidx.navigation.NavController
import com.zybooks.foodamy.ui.theme.DarkBlue
import com.zybooks.foodamy.ui.theme.DarkGreen
import com.zybooks.foodamy.ui.theme.DarkRed
import com.zybooks.foodamy.util.TestTags

@Composable
fun LoginInfoScreen(
    navController: NavController?,
    viewModel: LoginInfoViewModel = hiltViewModel(),

    ) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    Scaffold(modifier = Modifier
        .padding(0.dp, 0.dp, 0.dp, 16.dp),

        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ){
                    Text("Login", textAlign = TextAlign.Center, color = Color.White) }},
                backgroundColor = DarkRed
            )
        },
        content = {

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


            OutlineTextFieldWithErrorView(
                textStyle = TextStyle(textAlign = TextAlign.Left),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag(TestTags.Login_Email_Textfield),
                value = viewModel.state.email,
                onValueChange = { viewModel.updateEmail(it) },
                label = { Text(text = "Email or Username") },
                singleLine = true,
                placeholder = { Text("Email or Username") },
                isError = viewModel.validateEmail(),

                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                ),
                errorMsg = "Incorrect Email"
            )



            OutlineTextFieldWithErrorView(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag(TestTags.Login_Password_Textfield),
                value = viewModel.state.password,
                onValueChange = { viewModel.updatePassword(it) },
                label = { Text("Password") },
                singleLine = true,
                placeholder = { Text("Password") },
                isError = viewModel.validatePassword(),
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
                errorMsg = "Incorrect Password"
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
                        navController?.navigate("Register")
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
                        navController?.navigate("forgot password")
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
                    viewModel.validateEmail()
                    viewModel.validatePassword()
                },
                enabled = true,
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(backgroundColor = DarkGreen)
            ) {
                Text(text = "Login", color = Color.White, textAlign = TextAlign.Center)
            }
        }
    })
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

@Composable
fun OutlineTextFieldWithErrorView(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = MaterialTheme.shapes.small,
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(),
    errorMsg : String = ""
){


        OutlinedTextField(
            enabled = enabled,
            readOnly = readOnly,
            value = value,
            onValueChange = onValueChange,
            modifier = modifier,
            singleLine = singleLine,
            textStyle = textStyle,
            label = label,
            placeholder = placeholder,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            isError = isError,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            maxLines = maxLines,
            interactionSource = interactionSource,
            shape = shape,
            colors = colors
        )

        if (isError){
            Text(
                text = errorMsg,
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(start = 16.dp)
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
                .testTag(TestTags.Login_Facebook_Button),
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
                .testTag(TestTags.Login_Google_Button),
            onClick = {},
            enabled = true,
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(backgroundColor = DarkRed)
        ) {
            Text(text = "Login with Google", color = Color.White, textAlign = TextAlign.Center)
        }

        DividerText("Or")

        OutlineTextFieldWithErrorView(
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

        OutlineTextFieldWithErrorView(
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
                onClick = { offset ->
                    Log.d("ClickableText", "$offset -th character is clicked.")
                }
            )

            Spacer(Modifier.weight(1f))

            ClickableText(
                modifier = Modifier
                    .testTag(TestTags.Forgot_Password_Text_Click),
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
                .height(45.dp)
                .testTag(TestTags.Login_Button),
            onClick = {},
            enabled = true,
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(backgroundColor = DarkGreen)
        ) {
            Text(text = "Login", color = Color.White, textAlign = TextAlign.Center)
        }
    }
}




