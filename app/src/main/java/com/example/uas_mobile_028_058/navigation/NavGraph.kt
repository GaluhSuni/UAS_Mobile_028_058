package com.example.uas_mobile_028_058.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uas_mobile_028_058.ui.theme.create.CreateEventScreen
import com.example.uas_mobile_028_058.ui.theme.main.EventListScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "event_list"
    ) {
        composable("event_list") {
            EventListScreen(
                onCreateClick = { navController.navigate("create_event") }
            )
        }

        composable("create_event") {
            CreateEventScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}
