package com.example.whispr.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.whispr.AuthViewModel
import com.example.whispr.Auth_State

@Composable
fun home_screen(navController: NavController,authViewModel: AuthViewModel)
{
//    val auth_state=authViewModel.auth_state.observeAsState()
//    LaunchedEffect(auth_state.value) {
//        when(auth_state.value){
//            is Auth_State.unauthenticated->navController.navigate(route = "login_screen")
//            else -> {}
//        }
//    }
    Column(modifier = Modifier.fillMaxSize().background(Color.White) ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Button(onClick = {
            navController.navigate(route = "edit_mode_screen")
        }) {
            Text("Edit Profile")
        }
    }
}