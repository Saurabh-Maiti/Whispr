package com.example.whispr.screens

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

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextButton
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.whispr.AuthViewModel
import com.example.whispr.Auth_State


@Composable
fun signup_screen(navController: NavController,authViewModel: AuthViewModel)
{
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var confirm_password by remember { mutableStateOf("") }
    var password_visible by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }
    val authState=authViewModel.auth_state.observeAsState()
    val context = LocalContext.current
    LaunchedEffect(authState.value) {
        when(authState.value){
            is Auth_State.authenticated-> navController.navigate(route = "home_screen")
            is Auth_State.Error-> Toast.makeText(context,(authState.value as Auth_State.Error).message, Toast.LENGTH_LONG).show()
            else -> {}
        }
    }
    Column(
        modifier = Modifier
            .background(Color.White)
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
        Spacer(Modifier.padding(top = 14.dp))
        OutlinedTextField(value = email,
            onValueChange = { email = it },
            shape = RoundedCornerShape(16.dp),
            label = { Text("Email",color = Color.Black) },
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            ),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedBorderColor = Color(0xFFD9D9D9),
                unfocusedBorderColor = Color(0xFFD9D9D9),
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            ))
        Spacer(Modifier.padding(top = 14.dp))
        Box(modifier = Modifier.width(22.dp))
        {

        }
        Spacer(Modifier.padding(top = 14.dp))

        OutlinedTextField(value = password,
            visualTransformation =if (password_visible) VisualTransformation.None else PasswordVisualTransformation(),
            onValueChange = { password = it },
            shape = RoundedCornerShape(16.dp),
            label = { Text("Password",color = Color.Black) },
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            ),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedBorderColor = Color(0xFFD9D9D9),
                unfocusedBorderColor = Color(0xFFD9D9D9),
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            ), trailingIcon = {
                val icon=if(password_visible)
                    painterResource(id = R.drawable.hide_new)
                else
                    painterResource(id = R.drawable.show_new)
                IconButton(onClick = { password_visible = !password_visible }) {
                    Icon(painter = icon, contentDescription = null)
                }
            })
        Spacer(Modifier.padding(top = 14.dp))

        OutlinedTextField(value = confirm_password,
            visualTransformation =if (password_visible) VisualTransformation.None else PasswordVisualTransformation(),
            onValueChange = { confirm_password=it },
            shape = RoundedCornerShape(16.dp),
            label = { Text("Confirm Password",color = Color.Black) },
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            ),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedBorderColor = Color(0xFFD9D9D9),
                unfocusedBorderColor = Color(0xFFD9D9D9),
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            ),trailingIcon = {
                val icon=if(password_visible)
                    painterResource(id = R.drawable.hide_new)
                else
                    painterResource(id = R.drawable.show_new)
                IconButton(onClick = { password_visible = !password_visible }) {
                    Icon(painter = icon, contentDescription = null)
                }
            })

        Spacer(Modifier.padding(top = 24.dp))
        Button(modifier = Modifier
            .width(196.dp)
            .height(53.dp),
            onClick = {
                if(password==confirm_password) {
                    authViewModel.signup(email, password)
                }
                else
                {
                    Toast.makeText(context,"Passwords do not match. Please re-enter.", Toast.LENGTH_LONG).show()
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF735C),
                contentColor = Color.Black
            )
        ) {
            Text("Create Account", fontSize = 18.sp, fontWeight = FontWeight.Normal)
        }

        TextButton(onClick = {
            navController.navigate(route = "login_screen")
        }) {
            val annotatedText = buildAnnotatedString {
                append("Already have an account? ")
                withStyle(style = SpanStyle(color = Color(0xFFFF735C))) {
                    append("Login")
                }
            }
            BasicText(text = annotatedText)
        }
    }
}
