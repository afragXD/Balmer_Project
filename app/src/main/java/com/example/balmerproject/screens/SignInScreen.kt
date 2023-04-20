package com.example.balmerproject.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.balmerproject.R
import com.example.balmerproject.ui.theme.DementiaText
import com.example.balmerproject.ui.theme.MainBack
import com.example.balmerproject.ui.theme.MainText
import com.example.balmerproject.ui.theme.Montserrat

//@Preview (showBackground = true)
@Composable
fun SignInScreen(
    navController: NavController
) {

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var showPassword by remember { mutableStateOf(false) }

    val icon = if (showPassword)
        painterResource(id = R.drawable.ic_visibility)
    else
        painterResource(id = R.drawable.ic_visibility_off)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MainBack)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Z \uD83D\uDE0A",
            color = MainText,
            fontSize = 40.sp,
            fontFamily = Montserrat,
            modifier = Modifier
                .padding(top = 81.dp),
        )
        TextField(value = email, onValueChange = { newText->
            email = newText
        },
            label = {
                Text(
                    text = "E-mail",
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MainBack
            ),
            modifier = Modifier.
                    padding(top = 80.dp, start = 25.dp, end = 25.dp)
        )
        TextField(value = password, onValueChange = { newText->
            password = newText
        },
            label = {
                Text(
                    text = "Пароль",
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth(),
                )
            },
            trailingIcon = {
                           IconButton(onClick = {
                               showPassword = !showPassword
                           }) {
                               Icon(
                                   painter = icon,
                                   contentDescription = "visibility icon",
                               )
                           }
            },
            visualTransformation = if (showPassword) VisualTransformation.None
            else PasswordVisualTransformation(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Go
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MainBack
            ),
            modifier = Modifier.
                    padding(start = 25.dp, end = 25.dp, bottom = 102.dp)
        )
        OutlinedButton(
            onClick = {
                //onSignInClick()
                      },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 60.dp, end = 60.dp, bottom = 18.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MainBack,
            ),
            border = BorderStroke(1.dp, MainText),
            shape = RoundedCornerShape(20),
        ) {
            Text(
                text = "Войти",
                color = MainText,
                fontSize = 20.sp,
                fontFamily = Montserrat,
            )
        }
        TextButton(
            onClick = { /*TODO*/ },

        ) {
            Text(
                text = "Забыли пароль?",
                color = DementiaText,
                fontSize = 15.sp,
                fontFamily = Montserrat,
                textDecoration = TextDecoration.Underline
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Нет аккаунта?",
                color = DementiaText,
                fontSize = 15.sp,
                fontFamily = Montserrat,
            )
            TextButton(
                onClick = { navController.navigate("registration") },

                ) {
                Text(
                    text = "Зарегистрироваться",
                    color = DementiaText,
                    fontSize = 15.sp,
                    fontFamily = Montserrat,
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }
}