package com.example.petproject.navi

import androidx.compose.runtime.Composable


import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.petproject.FirstScreen
import com.example.petproject.ui.screens.RegionScreen

@Composable
fun SetUpNavGraph(
    navController: NavHostController

) {
    NavHost(
        navController = navController,
        startDestination = Screens.First.route
    ) {
        composable(
            route = Screens.First.route
        ) {
            FirstScreen(navController)
        }
        composable(
            route = Screens.Region.route
        ) {
            RegionScreen()
        }


    }
}