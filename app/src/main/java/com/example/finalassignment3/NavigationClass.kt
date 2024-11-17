package com.example.finalassignment3


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.finalassignment3.Second.Main_Screen
import com.example.finalassignment3.ThridTask.FilmScreen


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavigationClass() {
    val navController = rememberNavController()

    androidx.compose.material3.Scaffold(
        content = {
            NavHost(
                navController = navController,
                startDestination = "pagerScreen"
            ) {
                composable("pagerScreen") {
                    ScreenPager(navController)
                }
                composable("newScreen") {
                    Main_Screen()
                }
                composable(
                    route = "NewScreen3/{id}",
                    arguments = listOf(navArgument("id") { type = NavType.IntType })
                ) { backStackEntry ->
                    val id = backStackEntry.arguments?.getInt("id") ?: 0

                    FilmScreen(kinopoiskId = id)
                }
            }
        }
    )
}

