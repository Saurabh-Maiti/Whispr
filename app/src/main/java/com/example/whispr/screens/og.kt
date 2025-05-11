package com.example.whispr.screens

import android.R.attr.label
import android.content.Intent
import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.whispr.AuthViewModel
import com.example.whispr.R

@Composable
fun og(navController: NavController, authViewModel: AuthViewModel) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .clip(RoundedCornerShape(bottomStart = 38.dp, bottomEnd = 38.dp))
                .background(Color(0xFFFF735C)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Meet the OG!",
                fontSize = 32.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(top = 8.dp),
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Column(
            modifier = Modifier.padding(horizontal = 28.dp),
            verticalArrangement = Arrangement.spacedBy(22.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                GridBox(
                    iconRes = R.drawable.insta_logo_1,
                    url = "https://www.instagram.com/saurabh_maiti_/",
                    label = "@saurabh_maiti_"
                )
                GridBox(
                    iconRes = R.drawable.x_logo,
                    url = "https://x.com/SaurabhMai44482",
                    label = "@SaurabhMai44482"
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                GridBox(
                    iconRes = R.drawable.linkedin_logi,
                    url = "https://www.linkedin.com/in/saurabh-maiti-9bb574246/",
                    label = "Saurabh Maiti"
                )
                GridBox(
                    iconRes = R.drawable.site_logo,
                    url = "https://saurabhmaiti.infinityfreeapp.com/",
                    label = "My Website"
                )
            }
        }
    }
}

@Composable
fun GridBox(@DrawableRes iconRes: Int, url: String, label: String) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .height(200.dp)
            .width(150.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                context.startActivity(intent)
            },
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = "",
                modifier = Modifier.size(96.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = label,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
