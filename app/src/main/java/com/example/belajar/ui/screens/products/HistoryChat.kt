package com.example.belajar.ui.screens.products

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.belajar.R

@Composable
fun HistoryChat(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize().padding(paddingValues)
            .background(Color(0xFF519D90)) // Background color of the screen
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .horizontalScroll(
                            rememberScrollState()
                        )
                ) {
                    ElevatedCardExample()
                    Spacer(modifier = Modifier.padding(4.dp))
                    ElevatedCardExample()
                    Spacer(modifier = Modifier.padding(4.dp))
                    ElevatedCardExample()
                    Spacer(modifier = Modifier.padding(4.dp))
                }

                Column {
                    Spacer(
                        modifier = Modifier.padding(
                            5.dp
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
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .verticalScroll(rememberScrollState())
                        ) {
                            Text(
                                text = "Pesan",
                                modifier = Modifier.padding(start = 20.dp, top = 20.dp),
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF032B35)
                                )
                            )
                            RecentChat()
                            RecentChat()
                            RecentChat()
                            RecentChat()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ElevatedCardExample() {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .size(width = 134.dp, height = 198.dp)
            .drawBehind {
                val gradientBrush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF032B35),
                        Color(0xFFFCBB53),
                        Color(0xFFBEFFF4)
                    ),
                    start = androidx.compose.ui.geometry.Offset(0f, 0f),
                    end = androidx.compose.ui.geometry.Offset(0f, size.height)
                )
                val borderWidth = 6.dp.toPx()
                val halfBorder = borderWidth / 2

                drawRoundRect(
                    brush = gradientBrush,
                    cornerRadius = androidx.compose.ui.geometry.CornerRadius(22.dp.toPx()),
                    style = Stroke(width = borderWidth),
                    size = size.copy(
                        width = size.width - borderWidth,
                        height = size.height - borderWidth
                    ),
                    topLeft = androidx.compose.ui.geometry.Offset(halfBorder, halfBorder)
                )
            }
            .padding(2.dp), // Ensures content is not covered by border
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF78D6C6)
        ),
        shape = RoundedCornerShape(22.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(114.dp)
                    .clip(RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp))
                    .background(color = Color.Yellow)
            ) {
                Image(
                    painter = painterResource(R.drawable.profil_tri),
                    contentDescription = "profil",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Ustz. Tri")
                Spacer(modifier = Modifier.padding(top = 15.dp))
                AssistChip(
                    modifier = Modifier
                        .height(21.dp)
                        .width(71.dp), // Pastikan ukuran chip sesuai
                    onClick = { Log.d("Assist chip", "hello world") },
                    label = {
                        Box(
                            modifier = Modifier
                                .fillMaxSize(),
                            contentAlignment = Alignment.Center // Memusatkan konten di tengah
                        ) {
                            Text(
                                "Chat",
                                color = Color.White,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                ),
                                textAlign = TextAlign.Center
                            )
                        }
                    },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = Color(0xFF032B35), // Warna latar belakang gelap
                        labelColor = Color.White
                    ),
                    shape = RoundedCornerShape(18.dp), // Membuat bentuk rounded yang mirip pill
                    border = BorderStroke(1.dp, Color(0xFFFCBB53)) // Warna border oranye
                )


            }
        }
    }
}

@Composable
fun MainHistoryChartScreeen(){
    Scaffold(
        bottomBar = {CustomBottomAppBar()}
    ) { paddingValues ->
        HistoryChat(paddingValues)
    }
}


@Preview
@Composable
fun HistoryChatPreview() {
    MainHistoryChartScreeen()
}
