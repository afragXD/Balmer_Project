package com.example.balmerproject.activites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.balmerproject.models.MainViewModel
import com.example.balmerproject.ui.theme.BalmerProjectTheme
import com.example.balmerproject.screens.SignInScreen
import com.example.balmerproject.screens.SignUpScreen
import com.example.balmerproject.screens.StartScreen

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepVisibleCondition{
                viewModel.isLoading.value
            }
        }
        setContent {
            BalmerProjectTheme {
                val navController = rememberNavController()
                NavHost(
                    navController,
                    startDestination = "login"
                ){
                    composable("login"){
                        SignInScreen(navController)
                    }
                    composable("registration"){
                        //StartScreen()
                        SignUpScreen()
                    }
                }
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)){ view, insets ->
            val bottom = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom
            view.updatePadding(bottom = bottom)
            insets
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BalmerProjectTheme {

    }
}
