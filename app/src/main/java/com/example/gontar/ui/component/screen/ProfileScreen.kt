package com.example.gontar.ui.component.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gontar.R

@Composable
fun ProfileScreen(navController: NavController) {
    var name by remember { mutableStateOf("Andy Pratama") }
    var email by remember { mutableStateOf("andypratama1211@gmail.com") }
    var phone by remember { mutableStateOf("082217160075") }
    var birthDate by remember { mutableStateOf("02 Januari 2004") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .size(48.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ) {
            Image(
                painter = painterResource(id = R.drawable.arrow),
                contentDescription = "Kembali"
            )
        }

        Image(
            painter = painterResource(id = R.drawable.user_icon),
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(100.dp)
                .background(MaterialTheme.colorScheme.secondary, shape = RoundedCornerShape(50))
        )

        Text(
            text = "Edit Profile",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp)
        )

        // Profile Details with TextFields
        Column(
            modifier = Modifier.padding(top = 16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            ProfileTextField("Nama", name) { name = it }
            ProfileTextField("Email", email) { email = it }
            ProfileTextField("HP", phone) { phone = it }
            ProfileTextField("Tanggal Lahir", birthDate) { birthDate = it }
        }

        // Save Button
        Button(
            onClick = {
                navController.navigate("dashboard")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Simpan Perubahan", color = Color.White)
        }

        // Logout Button
        Button(
            onClick = {
                navController.navigate("home")
            },
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ) {
            Text(text = "Logout", color = Color.Red)
        }
    }
}

@Composable
fun ProfileTextField(label: String, value: String, onValueChange: (String) -> Unit) {
    Text(text = label, fontWeight = FontWeight.Bold)
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Masukkan $label") }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    ProfileScreen(navController = rememberNavController())
}
