package com.example.streamverse.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.streamverse.presentation.details.DetailScreen
import com.example.streamverse.presentation.home.HomeScreen

@Composable
fun WatchAppNavigation(
    navController : NavHostController = rememberNavController(),

    ){
    NavHost(
        navController = navController ,
        startDestination = Screen.Home.route
    ){
        composable(Screen.Home.route) {

            HomeScreen(
                onNavigateToDetails = {
                        contentId -> navController.navigate(Screen.Details.createRoute(contentId))
                }
            )
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(
                navArgument("contentId"){type = NavType.StringType}

            )
        ) { navBackStackEntry ->

            DetailScreen (
                contentId = navBackStackEntry.arguments?.getString("contentId") ?: "",
                contentType = "movie",
                onNavigateBack = { navController.popBackStack()}
            )
        }
    }


}