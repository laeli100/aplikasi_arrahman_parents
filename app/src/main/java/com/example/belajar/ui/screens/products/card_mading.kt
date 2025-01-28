package com.example.belajar.ui.screens.products

import android.util.Log
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.belajar.R

@Composable
fun CardMading() {
    OutlinedCard(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Color.Gray),
        modifier = Modifier
            .size(width = 124.dp, height = 150.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(89.dp)
                    .clip(RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp))
                    .background(color = Color.Yellow)
            ) {
                Image(
                    painter = painterResource(R.drawable.imgnews),
                    contentDescription = "profil",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()

                    .padding(top = 5.dp, start = 6.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .width(38.dp)
                        .height(15.dp)
                        .background(
                            color = Color(0xFFFFE3B6),
                            shape = RoundedCornerShape(10.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "PPDB",
                        textAlign = TextAlign.Center,
                        fontSize = 5.sp,
                        color = Color(0xFF996633),
                        fontWeight = FontWeight.Bold,
                        lineHeight = 5.sp,  // Add this to control vertical spacing
                        modifier = Modifier
                            .fillMaxSize()  // Changed to fillMaxSize
                            .wrapContentSize(Alignment.Center)  // This will center in all directions
                    )
                }


                Text(
                    text = "Info PPDB Tahun Ajaran 2024/2025",
                    fontSize = 7.sp,
                    lineHeight = 10.sp,
                    color = Color(0xFF845924),
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(2.dp)
                )
            }

        }
    }
}

@Preview
@Composable
fun CardMadingPreview() {
    CardMading()
}