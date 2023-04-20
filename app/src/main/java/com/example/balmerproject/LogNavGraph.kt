package com.example.balmerproject

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.balmerproject.items.BottomNavItem
import com.example.balmerproject.screens.*
import com.example.balmerproject.ui.theme.BottomNavColor
import com.example.balmerproject.ui.theme.BottomNavSelectedColor
import com.example.balmerproject.ui.theme.BottomNavUnselectedColor

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "start1"
    ){
        composable("start1"){
            StartScreen1()
        }
        composable("start2"){
            StartScreen2()
        }
        composable("start3"){
            StartScreen3()
        }
        composable("profile"){
            StartScreen4()
        }
        composable("start5"){
            StartScreen5()
        }
    }
}

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController:NavController,
    modifier: Modifier = Modifier,
    onItemClick:(BottomNavItem) -> Unit
){
    val  backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier
            .fillMaxHeight(0.1f),
        backgroundColor = BottomNavColor,
        elevation = 5.dp,
    ) {
        items.forEach {item->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = BottomNavSelectedColor,
                unselectedContentColor = BottomNavUnselectedColor,
                icon = {
                    Column(
                        horizontalAlignment = CenterHorizontally,
                    ) {
                        if (item.badgeCount > 0){
                            BadgedBox(
                                badge = {
                                    Badge{ Text(item.badgeCount.toString())}
                                }
                            ) {
                                Icon(
                                    modifier = Modifier.size(30.dp),
                                    imageVector = item.icon,
                                    contentDescription = item.name,
                                )
                            }
                        }else{
                            Icon(
                                modifier = Modifier.size(30.dp),
                                imageVector = item.icon,
                                contentDescription = item.name,
                            )
                        }
                        if (selected){
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 15.sp,
                            )
                        }
                    }
                }
            )
        }
    }
}