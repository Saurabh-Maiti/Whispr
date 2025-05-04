package com.example.whispr.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.whispr.R
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.whispr.AuthViewModel

@Composable
fun start_screen(navController: NavController, authViewModel: AuthViewModel) {
    // Delay navigation for 1 seconds (you can adjust this)
    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(1000)
        navController.navigate("login_screen") {
            popUpTo("start_screen") { inclusive = true } // Removes splash from back stack
        }
    }

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.padding(top = 80.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.start),
                contentDescription = "My Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                contentScale = ContentScale.Fit
            )
        }
        Spacer(Modifier.padding(top = 140.dp))

        Text("Whispr", fontSize = 48.sp, fontWeight = FontWeight.Light)
        Spacer(Modifier.padding(top = 8.dp))
        Text("Undress your thoughts", fontSize = 24.sp, fontWeight = FontWeight.Light)
    }
}
