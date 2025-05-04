package com.example.whispr.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.whispr.AuthViewModel
import com.example.whispr.Auth_State
import com.example.whispr.R

@Composable
fun profile_screen_page(navController: NavController,authViewModel: AuthViewModel) {
    val auth_status=authViewModel.auth_state.observeAsState()
    LaunchedEffect(auth_status.value) {
        when(auth_status.value)
        {
            is Auth_State.unauthenticated ->navController.navigate("login_screen")
            else -> {}
        }
    }
    Column(modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(108.dp)
                .clip(RoundedCornerShape(bottomStart = 38.dp, bottomEnd = 38.dp))
                .background(Color(0xFFFF735C)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Edit Mode: Activated!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(top = 8.dp),
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.man),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text("Saurabh Maiti", fontSize = 20.sp)
        Spacer(modifier=Modifier.padding(22.dp))
        Box(
            modifier = Modifier
                .padding(horizontal = 28.dp) // space from left and right edges
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp)) // round corners
                .background(Color(0xFFD9D9D9)), // background color
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Edit Profile",
                fontSize = 22.sp,
                modifier = Modifier.padding(12.dp)
            )
        }
        Spacer(modifier=Modifier.padding(8.dp))
        Box(
            modifier = Modifier
                .padding(horizontal = 28.dp) // space from left and right edges
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp)) // round corners
                .background(Color(0xFFD9D9D9)), // background color
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Meet the OG",
                fontSize = 22.sp,
                modifier = Modifier.padding(12.dp)
            )
        }
        Spacer(modifier=Modifier.padding(8.dp))

        Box(
            modifier = Modifier
                .padding(horizontal = 28.dp) // space from left and right edges
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp)) // round corners
                .background(Color(0xFFD9D9D9)), // background color
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Share App",
                fontSize = 22.sp,
                modifier = Modifier.padding(12.dp)
            )
        }
        Spacer(modifier=Modifier.padding(8.dp))

        Box(
            modifier = Modifier
                .padding(horizontal = 28.dp) // space from left and right edges
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp)) // round corners
                .background(Color(0xFFD9D9D9)), // background color
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Privacy Policy",
                fontSize = 22.sp,
                modifier = Modifier.padding(12.dp)
            )
        }
        Spacer(modifier=Modifier.padding(8.dp))

        Box(
            modifier = Modifier
                .padding(horizontal = 28.dp) // space from left and right edges
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp)) // round corners
                .background(Color(0xFFD9D9D9)), // background color
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Follow Me",
                fontSize = 22.sp,
                modifier = Modifier.padding(12.dp)
            )
        }
        Spacer(modifier=Modifier.padding(8.dp))

        Box(
            modifier = Modifier
                .padding(horizontal = 28.dp) // space from left and right edges
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp)) // round corners
                .background(Color(0xFFD9D9D9)), // background color
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Delete Account",
                fontSize = 22.sp,
                modifier = Modifier.padding(12.dp)
            )
        }
        Spacer(modifier=Modifier.padding(12.dp))
        Button(modifier = Modifier
            .width(196.dp)
            .height(53.dp),
            onClick = {
                authViewModel.signout()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF735C),
                contentColor = Color.Black
            )
        ) {
            Text("Sign Out", fontSize = 24.sp, fontWeight = FontWeight.Normal)
        }

    }
}
