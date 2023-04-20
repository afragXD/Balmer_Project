package com.example.balmerproject.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.balmerproject.BottomNavigationBar
import com.example.balmerproject.Navigation
import com.example.balmerproject.R
import com.example.balmerproject.items.BottomNavItem
import java.lang.reflect.Modifier

@Preview(showBackground = true)
@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun StartScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavItem(
                        name = "Start1",
                        route = "start1",
                        icon =  ImageVector.vectorResource(R.drawable.start_screen1_item)
                    ),
                    BottomNavItem(
                        name = "Start2",
                        route = "start2",
                        icon =  ImageVector.vectorResource(R.drawable.start_screen2_item)
                    ),
                    BottomNavItem(
                        name = "Start3",
                        route = "start3",
                        icon =  ImageVector.vectorResource(R.drawable.start_screen3_item)
                    ),
                    BottomNavItem(
                        name = "Start4",
                        route = "profile",
                        icon =  ImageVector.vectorResource(R.drawable.start_screen4_item)
                    ),
                    BottomNavItem(
                        name = "Start5",
                        route = "start5",
                        icon =  ImageVector.vectorResource(R.drawable.start_screen5_item)
                    ),
                ),
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                }
            )
        }
    ) {
        Navigation(
            navController = navController,
        )
    }
}