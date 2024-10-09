package com.example.gontar.ui.component.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.gontar.R

@Composable
fun DeliveryDetailScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        // Nama Pengirim dan Tanggal
        Text(
            text = "Pak Vincent",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        Text(
            text = "24 September 2023 - 13:30",
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Jarak
        Text(
            text = "Jarak 1.3 km",
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Alamat Toko
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.icongarpu),
                contentDescription = "Icon Toko",
                modifier = Modifier.size(24.dp)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                Text(
                    text = "(Warung Nasi Bungkus)",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Jl. Niaga Utara, Pelabuhan, Kec. Samarinda Kota, Kota Samarinda"
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Alamat Penerima
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.lokasi),
                contentDescription = "Icon Lokasi",
                modifier = Modifier.size(24.dp)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                Text(
                    text = "(Rumah Di Pinggir Sawit)",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Jl. Bhayangkara, Bugis, Kec. Samarinda Kota, Kota Samarinda"
                )
            }
        }

        Divider(color = Color.DarkGray, modifier = Modifier.padding(vertical = 16.dp))

        // Nama Penerima
        Text(
            text = "Nama Penerima",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Bapak Vincent",
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Gambar Penerima
        Image(
            painter = painterResource(id = R.drawable.vincent),
            contentDescription = "Gambar Penerima",
            modifier = Modifier
                .fillMaxWidth()
                .height(330.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = androidx.compose.ui.layout.ContentScale.Crop
        )
    }
}


@Composable
@Preview(showBackground = true)
fun DeliveryDetailScreen() {
    LoginScreen()
}