package com.example.belajar.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.belajar.R

@Composable
fun CardStudy() {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier.size(width = 357.dp, height = 142.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            CurvedBackground()
            Image(
                painter = painterResource(id = R.drawable.profil_ust),
                contentDescription = "Ustadz Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(180.dp)
                    .clip(
                        shape = RoundedCornerShape(
                            topStart = 70.dp,
                            topEnd = 15.dp,
                            bottomEnd = 15.dp,
                            bottomStart = 70.dp
                        )
                    )
                    .align(Alignment.CenterEnd)
            )
        }
    }
}



@Composable
fun CurvedBackground() {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val radius = size.height / 2 // Use half the height for a semi-circle
        val centerX = size.width * 0.6f // Position the center of the semi-circle
        val centerY = size.height / 2

        // Draw the semi-circle
        drawCircle(
            color = Color(0xFF78D6C6), // Match the background curve color
            radius = radius,
            center = androidx.compose.ui.geometry.Offset(centerX, centerY)
        )
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 14.dp, top = 14.dp, bottom = 16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Ilmu Syariah",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Ust. Ahmad Fauwaz\nbin Dato' Fadzil Noor",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.DarkGray
                )
            }
        }
    }
}

@Preview
@Composable
fun CardStudyPreview() {
    CardStudy()
}
