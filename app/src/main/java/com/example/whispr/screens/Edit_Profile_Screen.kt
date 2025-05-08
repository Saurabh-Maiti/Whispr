package com.example.whispr.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.whispr.R

@Composable
fun Edit_profile_Screen(navController: NavController)
{
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .clip(RoundedCornerShape(bottomStart = 38.dp, bottomEnd = 38.dp))
                .background(Color(0xFFFF735C)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Edit Profile",
                fontSize = 32.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(top = 8.dp),
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.padding(16.dp))
        OutlinedTextField(value = name, modifier = Modifier.width(350.dp),
            onValueChange = {name=it},
            shape = RoundedCornerShape(16.dp),
            label = {Text("Name", color = Color.Black)},
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFD9D9D9),
                unfocusedContainerColor = Color(0xFFD9D9D9),
                focusedBorderColor = Color(0xFFD9D9D9),
                unfocusedBorderColor = Color(0xFFD9D9D9),
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            )
            )
        OutlinedTextField(value = email, modifier = Modifier.width(350.dp),
            onValueChange = {email=it},
            shape = RoundedCornerShape(16.dp),
            label = {Text("Name", color = Color.Black)},
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFD9D9D9),
                unfocusedContainerColor = Color(0xFFD9D9D9),
                focusedBorderColor = Color(0xFFD9D9D9),
                unfocusedBorderColor = Color(0xFFD9D9D9),
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            )
        )
    }
}