package com.example.uas_mobile_028_058.navigation

//import androidx.compose.runtime.Composable
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import com.example.uas_mobile_028_058.MainScreen
//import com.example.uas_mobile_028_058.EventListScreen
//import com.example.uas_mobile_028_058.EventDetailScreen
//import com.example.uas_mobile_028_058.CreateEventScreen
//
//sealed class Screen(val route: String) {
//    object Home : Screen("home")
//    object EventList : Screen("event_list")
//    object Detail : Screen("detail/{id}") {
//        fun withId(id: Int) = "detail/$id"
//    }
//    object Create : Screen("create_event")
//}
//
//@Composable
//fun AppNavGraph(navController: NavHostController) {
//    NavHost(
//        navController = navController,
//        startDestination = Screen.Home.route
//    ) {
//        composable(Screen.Home.route) {
//            MainScreen(navController)
//        }
//        composable(Screen.EventList.route) {
//            EventListScreen(navController)
//        }
//        composable(Screen.Create.route) {
//            CreateEventScreen(navController)
//        }
//        composable(Screen.Detail.route) { backStackEntry ->
//            val id = backStackEntry.arguments?.getString("id")?.toInt()
//            EventDetailScreen(navController, id)
//        }
//    }
//}