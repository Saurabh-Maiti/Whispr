package com.example.whispr.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.whispr.AuthViewModel
import com.example.whispr.Auth_State
import com.example.whispr.R

@Composable
fun ConfessionCard(text: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Start,
            fontSize = 16.sp
        )
    }
}
@Composable
fun home_screen(navController: NavController,authViewModel: AuthViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F0F0)), // Light gray background
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp))
                .background(Color(0xFFF47C5B))
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Placeholder for the profile icon
                Image(painter = painterResource(id = R.drawable.man),"",
                    modifier = Modifier.size(80.dp).padding(top = 22.dp).
                    clickable{navController.navigate(route="edit_mode_screen")})
                Spacer(modifier = Modifier.width(8.dp))
                Column(modifier = Modifier.padding(start = 3.dp,
                    top = 22.dp
                    ), horizontalAlignment =  Alignment.CenterHorizontally) {
                    Text(text = "Whispr", color = Color.White, fontSize = 38.sp)
                    Text(text = "Undress your thoughts.", color = Color.White, fontSize = 18.sp)
                }
            }
            Text(text = "", color = Color.White) // Empty to balance the space
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Hey Saurabh!", fontSize = 18.sp)

        Spacer(modifier = Modifier.height(16.dp))

        // Search Bar and Add Button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),
                placeholder = { Text("Search confessions...") },
                shape = RoundedCornerShape(8.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    navController.navigate(route = "add_post_screen")
                },
                modifier = Modifier.size(56.dp),
                shape = RoundedCornerShape(28.dp),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF735C)
                )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.plus_svgrepo_com),
                    contentDescription = "Add Icon",
                    modifier = Modifier.size(28.dp)
                )
            }

        }

        Spacer(modifier = Modifier.height(16.dp))

        // Confessions
        ConfessionCard(text = "Confession 1. Crazy Shit")
        Spacer(modifier = Modifier.height(8.dp))
        ConfessionCard(text = "Confession 2. Saurabh is\nduniya\nka papa hai")
        Spacer(modifier = Modifier.height(8.dp))
        ConfessionCard(text = "Confession 3. Gurmann\nSingh\nRandi hai")
    }
}
