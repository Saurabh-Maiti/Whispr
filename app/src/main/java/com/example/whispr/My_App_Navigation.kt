package com.example.whispr

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.whispr.screens.Add_postScreen
import com.example.whispr.screens.home_screen
import com.example.whispr.screens.login_screen
import com.example.whispr.screens.og
import com.example.whispr.screens.profile_screen_page
import com.example.whispr.screens.signup_screen
import com.example.whispr.screens.start_screen

@Composable
fun My_App_Navigation(authViewModel: AuthViewModel)
{
    val navController= rememberNavController()
    NavHost(navController=navController, startDestination = "start_screen")
    {
        composable(route="start_screen"){
            start_screen(navController, authViewModel)
        }
        composable(route="login_screen") {
            login_screen(navController, authViewModel)
        }
        composable(route="signup_screen") {
            signup_screen(navController, authViewModel)
        }
        composable(route = "home_screen") {

            home_screen(navController = navController, authViewModel)
        }

        composable(route="edit_mode_screen") {
            profile_screen_page(navController, authViewModel)
        }
        composable(route="add_post_screen") {
            Add_postScreen(navController, authViewModel)
        }
        composable(route="og") {
            og(navController, authViewModel)
        }
    }
}