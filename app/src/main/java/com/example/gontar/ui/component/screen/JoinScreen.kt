package com.example.gontar.ui.component.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gontar.R

@Composable
fun JoinScreen(navController: NavHostController) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var contact by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Logo
        Image(
            painter = painterResource(id = R.drawable.core),
            contentDescription = "App Icon",
            modifier = Modifier.size(125.dp)
        )

        Text(text = "Buat akun driver", fontSize = 20.sp, color = Color.Black, modifier = Modifier.padding(bottom = 8.dp))
        Text(text = "Silahkan daftar menjadi driver dengan data informasi yang dibutuhkan.", fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(bottom = 24.dp))

        // Input Fields
        InputField(label = "Nama Lengkap", value = fullName, onValueChange = { fullName = it })
        InputField(label = "Alamat Email", value = email, onValueChange = { email = it })
        InputField(label = "Kontak", value = contact, onValueChange = { contact = it })
        InputField(label = "Password", value = password, onValueChange = { password = it })
        InputField(label = "Konfirmasi Password", value = confirmPassword, onValueChange = { confirmPassword = it })

        Button(onClick = {
            navController.navigate("home")
        }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary), shape = RoundedCornerShape(8.dp)) {
            Text(text = "DAFTAR", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewJoinScreen() {
    val navController = rememberNavController()
    JoinScreen(navController = navController)
}
