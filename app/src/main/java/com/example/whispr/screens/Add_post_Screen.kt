package com.example.whispr.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.whispr.R
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.whispr.AuthViewModel

@Composable
fun Add_postScreen(navController: NavController,authViewModel: AuthViewModel) {
    var confess by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFFF735C),
                    shape = RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomStart = 28.dp,
                        bottomEnd = 28.dp
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .padding(horizontal = 16.dp, vertical = 24.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.man),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(start = 6.dp,top=22.dp)
                        .size(70.dp)
                        .clip(CircleShape).clickable{
                            navController.navigate(route = "edit_mode_screen")
                        }
                )
                Spacer(modifier=Modifier.padding((8.dp)))
                TextField(
                    value = confess,
                    onValueChange = { confess = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Say what you can’t say out loud...", color=Color.Black) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFFF735C),
                        unfocusedContainerColor = Color(0xFFFF735C),
                        focusedBorderColor = Color(0xFFFF735C),
                        unfocusedBorderColor = Color(0xFFFF735C),
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    )
                )
            }
        }
        Spacer(modifier=Modifier.padding(16.dp))
        Button(onClick = {
            navController.navigate("home_screen")
        }, colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFF735C),

        ),) {
            Text("Smash it! 🔥",color=Color.White, fontSize = 16.sp)
        }
    }

}

