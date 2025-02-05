package com.example.belajar.ui.screens.products

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.belajar.R

@Composable
fun VerticalCarousel() {
    val items = List(3) { index ->
        "Judul #$index" to "Isi dari konten $index ini menjelaskan lebih detail."
    }
    val listState = rememberLazyListState()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(73.dp)
            .width(363.dp), // Batasi tinggi agar background tidak ikut bergerak
        contentAlignment = Alignment.Center
    ) {
        // Gambar tetap statis sebagai background
        Image(
            painter = painterResource(R.drawable.boxpengumuman),
            contentDescription = "background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Garis indikator di sebelah kiri
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(5.dp),
                verticalArrangement = Arrangement.Center
            ) {
                items.forEachIndexed { index, _ ->
                    val isSelected = listState.firstVisibleItemIndex == index
                    Box(
                        modifier = Modifier
                            .width(5.dp)
                            .height(10.dp) // Panjang segmen garis
                            .padding(vertical = 1.dp, horizontal = 1.dp)
                            .background(if (isSelected) Color.White else Color.Gray)
                    )
                }
            }

            // Carousel hanya pada teks
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                verticalArrangement = Arrangement.Center
            ) {
                items(items) { (judul, isi) ->
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 15.dp, vertical = 10.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = judul,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFF032B35)
                        )
                        Text(
                            text = isi,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun VerticalListScreenPreview() {
    VerticalCarousel()
}
