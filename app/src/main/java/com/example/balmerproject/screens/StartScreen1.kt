package com.example.balmerproject.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import com.example.balmerproject.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.balmerproject.ui.theme.MainBack
import com.example.balmerproject.ui.theme.TextFieldColor

@Preview(showBackground = true)
@Composable
fun StartScreen1() {
    var searchStr by remember {
        mutableStateOf("")
    }
    val maxSearchStr = 30
    val icon_search = painterResource(id = R.drawable.search_ico)

    Image(
        painter = painterResource(id = R.drawable.kristina),
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            //.background(MainBack)
            .padding(top = 25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        TextField(
            value = searchStr,
            onValueChange = { newText ->
                if (newText.length <= maxSearchStr)
                    searchStr = newText
                            },
            label = {
                Text(
                    text = "Товар, бренд или магазин",
                    modifier = Modifier
                        .fillMaxWidth(),
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center
                )
                    },
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = icon_search,
                        contentDescription = "search_icon"
                    )
                }
                          },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = TextFieldColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            shape = RoundedCornerShape(5.dp)
        )
        //ЕБЛАН, СЮДА ВСТАВЛЯЙ СКАФФОЛД!!!!
        //Забудь и я зарежу
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
        }
    }
}