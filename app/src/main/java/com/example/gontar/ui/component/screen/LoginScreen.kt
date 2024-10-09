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
import androidx.navigation.compose.rememberNavController
import com.example.gontar.R

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    onResetPasswordClick: () -> Unit,
    onJoinClick: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Logo
        Image(
            painter = painterResource(id = R.drawable.core),
            contentDescription = "Logo",
            modifier = Modifier.size(120.dp)
        )

        Text("Login", fontSize = 20.sp, color = Color.Black, modifier = Modifier.padding(bottom = 24.dp).align(Alignment.Start))

        // Input Fields
        InputField(label = "Email", value = email, onValueChange = { email = it })
        InputField(label = "Password", value = password, onValueChange = { password = it })

        Button(onClick = onLoginClick, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary), shape = RoundedCornerShape(8.dp)) {
            Text(text = "LOGIN", color = Color.White)
        }

        // Other buttons
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Lupa password?", color = Color.Gray, modifier = Modifier.padding(top = 15.dp))
            Button(onClick = onResetPasswordClick, colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary), shape = RoundedCornerShape(8.dp)) {
                Text(text = "Reset", color = Color.White)
            }
        }

        Text(text = "Belum punya akun?", color = Color.Black, modifier = Modifier.padding(top = 24.dp))
        Button(onClick = onJoinClick, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary), shape = RoundedCornerShape(8.dp)) {
            Text(text = "BUAT AKUN BARU", color = Color.White)
        }
    }
}

@Composable
fun InputField(label: String, value: String, onValueChange: (String) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(label, color = Color.Black, modifier = Modifier.padding(bottom = 4.dp))
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen(
        onLoginClick = {},
        onResetPasswordClick = {},
        onJoinClick = {}
    )
}
