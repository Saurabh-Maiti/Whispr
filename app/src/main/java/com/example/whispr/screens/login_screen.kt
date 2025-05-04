package com.example.whispr.screens

import android.R.id.message
import android.app.ProgressDialog.show
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextButton
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.whispr.AuthViewModel
import com.example.whispr.Auth_State

@Composable
fun login_screen(navController: NavController,authViewModel: AuthViewModel) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val auth_state=authViewModel.auth_state.observeAsState()
    val context= LocalContext.current
    LaunchedEffect(auth_state.value) {
        when(auth_state.value){
            is Auth_State.authenticated-> navController.navigate("home_screen")
            is Auth_State.Error-> Toast.makeText(context,(auth_state.value as Auth_State.Error).message, Toast.LENGTH_LONG).show()
            else -> {}
        }
    }
    Column(
        modifier = Modifier.background(Color.White)
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
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
        Spacer(Modifier.padding(top = 32.dp))
        OutlinedTextField(value = email,
            onValueChange = { email = it },
            shape = RoundedCornerShape(16.dp),
            label = { Text("Email") })
        Spacer(Modifier.padding(top = 18.dp))
        OutlinedTextField(value = password,
            onValueChange = { password = it },
            shape = RoundedCornerShape(16.dp),
            label = { Text("Password") })
        Spacer(Modifier.padding(top = 24.dp))
        Button(modifier = Modifier
            .width(196.dp)
            .height(53.dp),
            onClick = {
                authViewModel.login(email,password)

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF735C),
                contentColor = Color.Black
            )
        ) {
            Text("Login", fontSize = 24.sp, fontWeight = FontWeight.Normal)
        }
                TextButton(onClick = {
                    navController.navigate(route = "signup_screen")
                }) {
                    val annotatedText = buildAnnotatedString {
                        append("New user? ")
                        withStyle(style = SpanStyle(color = Color(0xFFFF735C))) {
                            append("Register")
                        }
                    }
                    BasicText(text = annotatedText)
                }
        Spacer(Modifier.padding(top = 24.dp))
        Text("Whispr", fontSize = 36.sp, fontWeight = FontWeight.Light)
        Spacer(Modifier.padding(top = 8.dp))
        Text("Undress your thoughts", fontSize = 24.sp, fontWeight = FontWeight.Light)
    }
}
