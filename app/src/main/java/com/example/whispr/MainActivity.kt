package com.example.whispr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels

import com.example.whispr.ui.theme.WhisprTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhisprTheme {
                val authViewModel: AuthViewModel by viewModels()
                My_App_Navigation(authViewModel)
            }
        }
    }
}
