package com.example.gontar

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gontar.ui.component.screen.*

@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(onTimeout = {
                navController.navigate("home") {
                    popUpTo("splash") { inclusive = true }
                }
            })
        }
        composable("home") {
            HomeScreen(
                navController = navController,
                onLoginClick = { navController.navigate("login") },
                onJoinClick = { navController.navigate("join") }
            )
        }
        composable("login") {
            LoginScreen(
                onLoginClick = { navController.navigate("dashboard") },
                onResetPasswordClick = { /* Handle reset */ },
                onJoinClick = { navController.navigate("join") }
            )
        }
        composable("join") {
            JoinScreen(navController = navController)
        }
        composable("dashboard") {
            DashboardScreen(navController = navController)
        }
        composable("profile") {
            ProfileScreen(navController = navController)
        }
        composable("riwayat") {
            RiwayatScreen(navController = navController)
        }

    }
}

@Composable
@Preview(showBackground = true)
fun PreviewMyApp() {
    MyApp()
}

