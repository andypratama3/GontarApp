package com.example.gontar.ui.component.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gontar.R

@Composable
fun DashboardScreen(
    navController: NavController,
    driverName: String = "Andy Pratama",
    deliveryCount: String = "200x",
    deliveryList: List<DeliveryItem> = List(5) {
        DeliveryItem(
            name = "Siapa Aja",
            address = "JL. BungTomo Samarinda Kalimantan Timur, Samarinda Seberang",
            distance = "1.3 km",
            date = "20/10/2021"
        )
    }
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFF5F5F5))
    ) {
        Header(driverName, navController)
        DeliveryCards(deliveryCount, "Riwayat", navController) // Pass navController here
        Text(
            text = "PENGANTARAN",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 24.dp)
        )
        DeliveryList(deliveryList, navController)
    }
}

@Composable
fun Header(driverName: String, navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Pengemudi\n$driverName",
            color = Color.Black,
            fontSize = 20.sp,
            modifier = Modifier.weight(1f)
        )
        Row {
            IconButton(onClick = { /* Handle notifications */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.notifications),
                    contentDescription = "Notifications",
                    modifier = Modifier.size(32.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            IconButton(onClick = { navController.navigate("profile") }) {
                Icon(
                    painter = painterResource(id = R.drawable.user_icon),
                    contentDescription = "Profile",
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeliveryCards(deliveryCount: String, historyText: String, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp)
    ) {
        // Delivery Count Card
        Card(
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
            shape = MaterialTheme.shapes.medium
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = deliveryCount,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "Pengantaran",
                    fontSize = 14.sp,
                    color = Color.White
                )
            }
        }

        // History Card
        Card(
            modifier = Modifier.weight(1f),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary),
            shape = MaterialTheme.shapes.medium,
            onClick = {
                navController.navigate("riwayat")
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(13.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = historyText,
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp),
                    color = Color.White
                )
                Text(
                    text = "Pengantaran",
                    fontSize = 14.sp,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun DeliveryList(deliveryList: List<DeliveryItem>, navController: NavController) {
    LazyColumn(
        modifier = Modifier.padding(top = 20.dp)
    ) {
        items(deliveryList) { item ->
            DeliveryItemView(item, navController)
        }
    }
}

@Composable
fun DeliveryItemView(item: DeliveryItem, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = item.name,
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = item.address,
                color = Color.Black,
                fontSize = 17.sp,
                modifier = Modifier.padding(top = 10.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = item.distance,
                    color = Color.Black,
                    fontSize = 16.sp
                )
                Text(
                    text = "\u2022",
                    color = Color.Black,
                    modifier = Modifier.padding(horizontal = 15.dp)
                )
                Text(
                    text = item.date,
                    color = Color.Black,
                    fontSize = 16.sp
                )
                IconButton(onClick = { navController.navigate("delivery_details/${item.name}") }) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_right),
                        contentDescription = "Show Details",
                        tint = Color.Black
                    )
                }
            }
        }
    }
}

data class DeliveryItem(
    val name: String,
    val address: String,
    val distance: String,
    val date: String
)

@Composable
@Preview(showBackground = true)
fun PreviewDashboardScreen() {
    val navController = rememberNavController()
    DashboardScreen(navController = navController)
}
