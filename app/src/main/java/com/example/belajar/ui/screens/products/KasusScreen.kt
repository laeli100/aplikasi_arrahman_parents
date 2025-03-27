package com.example.belajar.ui.screens.products

import ViolationCard
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.belajar.R
import com.example.belajar.ui.components.TopHeader

@Composable
fun KasusScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0FFEC)) // Background utama layar
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            TopHeader(
                logoRes = R.drawable.icpelanggaran,
                homeIconRes = R.drawable.ichome,
                namaFitur = "Catatan Kasus"
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column {
                Spacer(
                    modifier = Modifier.padding(
                        50.dp
                    )
                )
                Card(
                    shape = RoundedCornerShape(
                        topStart = 50.dp,
                        topEnd = 50.dp
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    ),
                    border = BorderStroke(3.dp, Color(0xFF4E9F3D)),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceBright
                    ),
                ) {
                    Column (
//                        modifier = Modifier.verticalScroll(rememberScrollState())
                    ){
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                        ) {
                            Image(
                                painter = rememberImagePainter(
                                    ImageRequest.Builder(LocalContext.current)
                                        .data(R.drawable.bg1)
                                        .apply {
                                            size(
                                                1080,
                                                2400
                                            ) // Resize to full screen resolution or any specific size (like 1080p)
                                            crossfade(true)
                                        }
                                        .build()
                                ),
                                contentDescription = "Background Image",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                            Column(
                                verticalArrangement = Arrangement.spacedBy(15.dp), modifier = Modifier.padding(20.dp).verticalScroll(rememberScrollState())
                            ) {
                                ViolationCard(
                                    caseNumber = 3,
                                    violationType = "PERIBADATAN",
                                    date = "22 Februari 2025",
                                    violationDetail = "Tidak Sholat",
                                    resolution = "Setoran hafalan 3 Surah (Al-Ikhlas, An-Naas, Al-Kafirun)"
                                )
                                ViolationCard(
                                    caseNumber = 2,
                                    violationType = "PERIBADATAN",
                                    date = "22 Februari 2025",
                                    violationDetail = "Tidak Sholat",
                                    resolution = "Setoran hafalan 3 Surah (Al-Ikhlas, An-Naas, Al-Kafirun)"
                                )
                                ViolationCard(
                                    caseNumber = 1,
                                    violationType = "PERIBADATAN",
                                    date = "22 Februari 2025",
                                    violationDetail = "Tidak Sholat",
                                    resolution = "Setoran hafalan 3 Surah (Al-Ikhlas, An-Naas, Al-Kafirun)"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun KasusScreenPreview() {
    KasusScreen()
}