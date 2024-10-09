package com.example.gontar.ui.component.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.example.gontar.ui.component.TopBarScreen
import com.example.gontar.ui.model.DataHistory

@Composable
fun RiwayatScreen(
    navController: NavController
) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBarScreen(
            title = {
                Text(
                    text = "Riwayat Pengantaran",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = "Kembali",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        ) {
            Box(modifier = Modifier.padding(top = 16.dp)) { // Adjust the value as needed
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                        .padding(top = 50.dp)
                        .background(MaterialTheme.colorScheme.background) // Background color
                ) {
                    items(DataHistory) { item ->
                        DeliveryItemView(
                            name = item.name,
                            address = item.address,
                            distance = item.distance,
                            date = item.date,
                            onClick = {

                            }
                        )
                    }
                }
            }

        }
    }
}



@Composable
fun DeliveryItemView(name: String, address: String, distance: String, date: String,onClick: () -> Unit) {
    Box(
        modifier = Modifier.padding(8.dp) // This adds margin around the Card
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
                shape = MaterialTheme.shapes.small,
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = name, color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text(text = address, color = Color.Black, fontSize = 17.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row {
                        Text(text = distance, color = Color.Black, fontSize = 14.sp)
                        Text(text = " • ", color = Color.Black)
                        Text(text = date, color = Color.Black, fontSize = 14.sp)
                    }
                    Text(text = "Detail", color = Color.Black, fontSize = 14.sp)
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun PreviewHistoryScreen() {
    val navController = rememberNavController()
    RiwayatScreen(navController = navController)
}
