package com.example.belajar.ui.screens.products

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.belajar.R
import com.example.belajar.ui.components.CardMading
import com.example.belajar.ui.components.CardStudy
import com.example.belajar.ui.components.TopHeader

@Composable
fun eMading() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0FFEC)) // Background color of the screen
    ) {
        Box(modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)){
            TopHeader(logoRes = R.drawable.emading,
                homeIconRes = R.drawable.ichome,
                namaFitur = "e-Mading"
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
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .verticalScroll(rememberScrollState())
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
                            modifier = Modifier
                                .fillMaxSize(),
//                                .verticalScroll(rememberScrollState()),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Belajar Bersama Ustadz",
                                modifier = Modifier.padding(10.dp),
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF032B35)
                                )
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                                    .horizontalScroll(
                                        rememberScrollState()
                                    ),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                CardStudy()
                                Spacer(modifier = Modifier.padding(5.dp))
                                CardStudy()
                                Spacer(modifier = Modifier.padding(5.dp))
                                CardStudy()
                                Spacer(modifier = Modifier.padding(5.dp))
                                CardStudy()
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(5.dp)
                                ) {
                                    Text(
                                        text = "Berita Terbaru",
                                        modifier = Modifier.padding(5.dp),
                                        style = MaterialTheme.typography.bodyLarge.copy(
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Medium,
                                            color = Color(0xFF032B35)
                                        )
                                    )
                                    Spacer(modifier = Modifier.padding(start = 30.dp, end = 100.dp))
                                    Text(
                                        text = "Lihat Semua",
                                        modifier = Modifier.padding(5.dp),
                                        style = MaterialTheme.typography.bodyLarge.copy(
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Normal,
                                            color = Color(0xFF032B35)
                                        )
                                    )
                                }
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp)
                                        .horizontalScroll(
                                            rememberScrollState()
                                        ),
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    CardMading()
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    CardMading()
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    CardMading()
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    CardMading()
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    CardMading()
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    CardMading()
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    CardMading()
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    CardMading()
                                }
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(5.dp)
                                ) {
                                    Text(
                                        text = "Prestasi",
                                        modifier = Modifier.padding(5.dp),
                                        style = MaterialTheme.typography.bodyLarge.copy(
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Medium,
                                            color = Color(0xFF032B35)
                                        )
                                    )
                                    Spacer(modifier = Modifier.padding(start = 80.dp, end = 100.dp))
                                    Text(
                                        text = "Lihat Semua",
                                        modifier = Modifier.padding(5.dp),
                                        style = MaterialTheme.typography.bodyLarge.copy(
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Normal,
                                            color = Color(0xFF032B35)
                                        )
                                    )
                                }
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp)
                                        .horizontalScroll(
                                            rememberScrollState()
                                        ),
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    CardMading()
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    CardMading()
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    CardMading()
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    CardMading()
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    CardMading()
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    CardMading()
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    CardMading()
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    CardMading()
                                }
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(5.dp)
                                ) {
                                    Text(
                                        text = "Ekstrakurikuler",
                                        modifier = Modifier.padding(5.dp),
                                        style = MaterialTheme.typography.bodyLarge.copy(
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Medium,
                                            color = Color(0xFF032B35)
                                        )
                                    )
                                    Spacer(modifier = Modifier.padding(start = 20.dp, end = 100.dp))
                                    Text(
                                        text = "Lihat Semua",
                                        modifier = Modifier.padding(5.dp),
                                        style = MaterialTheme.typography.bodyLarge.copy(
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Normal,
                                            color = Color(0xFF032B35)
                                        )
                                    )
                                }
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp)
                                        .horizontalScroll(
                                            rememberScrollState()
                                        ),
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    CardMading()
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    CardMading()
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    CardMading()
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    CardMading()
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    CardMading()
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    CardMading()
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    CardMading()
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    CardMading()
                                }
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
fun eMadingPreview() {
    eMading()
}