package com.example.belajar.ui.screens.products

import CalendarScreen
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.belajar.R
import com.example.belajar.ui.components.TopHeader

@Composable
fun KalenderAkademikScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0FFEC)) // Background utama layar
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Header
            TopHeader(
                logoRes = R.drawable.icpelanggaran,
                homeIconRes = R.drawable.ichome,
                namaFitur = "Kalender Akademik"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Kontainer utama dengan berat fleksibel
            Card(
                shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                border = BorderStroke(3.dp, Color(0xFF4E9F3D)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceBright),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // Mencegah infinite height constraint
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState()) // Scroll hanya di dalam Card
                ) {
                    // Gambar Background (Dibatasi tinggi agar tidak infinite constraint)
                    Image(
                        painter = rememberImagePainter(
                            ImageRequest.Builder(LocalContext.current)
                                .data(R.drawable.bg1)
                                .apply { crossfade(true) }
                                .build()
                        ),
                        contentDescription = "Background Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp), // Beri tinggi agar tidak infinite constraint
                        contentScale = ContentScale.Crop
                    )

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Gambar Kalender
                        Image(
                            painter = painterResource(R.drawable.gambarkalender),
                            contentDescription = "Gambar Kalender",
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp) // Dibatasi tinggi
                        )

                        // Bagian Kalender
                        CalendarScreen()

                        // Legenda Event
                        EventLegend()
                    }
                }
            }
        }
    }
}

// Item Legenda
@Composable
fun EventLegendItem(color: Color, title: String) {
    Column(
        modifier = Modifier
            .width(100.dp)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
                .background(color)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFF002B36))
                .padding(horizontal = 8.dp, vertical = 6.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = title, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
    }
}

// Legenda Event
@Composable
fun EventLegend() {
    val eventList = listOf(
        Pair(Color(0xFF88C67D), "Event Pondok"),
        Pair(Color(0xFF78D6C6), "Penilaian Tengah Semester"),
        Pair(Color(0xFFAE0003), "Penilaian Akhir Semester"),
        Pair(Color(0xFF4E9F3D), "Hari Libur")
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        eventList.forEach { (color, title) ->
            EventLegendItem(color, title)
        }
    }
}

@Preview
@Composable
fun KalenderAkademikScreenPreview() {
    KalenderAkademikScreen()
}
