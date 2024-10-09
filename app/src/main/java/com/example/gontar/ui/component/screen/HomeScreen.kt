package com.example.gontar.ui.component.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gontar.R

@Composable
fun HomeScreen(
    navController: NavHostController,
    onLoginClick: () -> Unit,
    onJoinClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Logo Image
        Image(
            painter = painterResource(id = R.drawable.core),
            contentDescription = "Logo",
            modifier = Modifier.size(184.dp)
        )

        // App Name
        Text(
            text = "Go Express",
            fontSize = 24.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.titleLarge
        )

        // Slogan
        Text(
            text = "Golang Express",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        // Greeting Text
        Text(
            text = "Silahkan Pilih",
            fontSize = 16.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.CenterHorizontally)
        )

        // Login Button
        Button(
            onClick = onLoginClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF008CFF)), // Blue
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "LOGIN AKUN", color = Color.White)
        }

        // Join Button
        Button(
            onClick = onJoinClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red), // Red
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "BERGABUNG", color = Color.White)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewWelcomeScreen() {
    // Mock navigation controller for preview
    val navController = rememberNavController()
    HomeScreen(
        navController = navController,
        onLoginClick = { /* Handle login click */ },
        onJoinClick = { /* Handle join click */ }
    )
}
