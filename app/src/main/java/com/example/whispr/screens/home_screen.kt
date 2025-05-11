package com.example.whispr.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.example.whispr.R
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun ConfessionCard(text: String) {
    Card(
        modifier = Modifier.defaultMinSize(minHeight = 120.dp)
            .fillMaxWidth()
            .padding(horizontal = 4.dp),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(0.5.dp, Color.Black),
        colors = CardDefaults.cardColors(
            Color(0xFFD9D9D9)
        )
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
fun home_screen(navController: NavController, authViewModel: AuthViewModel) {
    // Store confessions in a state list
    var confessions by remember { mutableStateOf(listOf<String>()) }

    // Listen to Firestore data
    LaunchedEffect(Unit) {
        FirebaseFirestore.getInstance()
            .collection("confessions")
            .orderBy("timestamp", com.google.firebase.firestore.Query.Direction.DESCENDING)
            .addSnapshotListener { snapshot, e ->
                if (e == null && snapshot != null) {
                    val texts = snapshot.documents.mapNotNull { it.getString("text") }
                    confessions = texts
                }
            }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F0F0)),
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

                Image(
                    painter = painterResource(
                        id = R.drawable.man),
                    contentDescription = "",
                    modifier = Modifier
                        .size(80.dp)
                        .padding(top = 22.dp)
                        .clickable { navController.navigate(route = "edit_mode_screen") }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    modifier = Modifier.padding(start = 3.dp, top = 22.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Whispr", color = Color.White, fontSize = 38.sp)
                    Text(text = "Undress your thoughts.", color = Color.White, fontSize = 18.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Hey Maverick!", fontSize = 18.sp)

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
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.LightGray
                )
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

        // Confession List
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(bottom = 80.dp)
        ) {
            items(confessions) { confession ->
                ConfessionCard(text = confession)
            }
        }
    }
}
