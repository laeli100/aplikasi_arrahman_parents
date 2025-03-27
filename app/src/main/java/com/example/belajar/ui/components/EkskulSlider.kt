package com.example.belajar.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ActivityProgressBar(activity: String, grade: String, progress: Float, color: Color) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        // Lingkaran warna kuning di sebelah kiri
        Box(
            modifier = Modifier
                .size(24.dp)
                .background(Color(0xFFFFC75F), shape = CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(text = activity, fontWeight = FontWeight.Bold, fontSize = 14.sp)

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .background(Color(0xFF032B35), shape = RoundedCornerShape(50))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(progress)
                        .height(10.dp)
                        .background(color, shape = RoundedCornerShape(50))
                )
            }
        }

        Spacer(modifier = Modifier.width(8.dp))
        Text(text = grade, fontWeight = FontWeight.Bold, fontSize = 14.sp)
    }
}

@Composable
fun ActivityProgressContainer() {
    Card(
        shape = RoundedCornerShape(16.dp), // Sudut lengkung
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp), // Shadow
        colors = CardDefaults.cardColors(containerColor = Color.White), // Warna putih
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            ActivityProgressBar("Pramuka", "B", 0.5f, Color(0xFF76D7C4)) // Hijau muda
            ActivityProgressBar("Karate", "C", 0.33f, Color(0xFFE74C3C)) // Merah
            ActivityProgressBar("Tilawatil Qur’an", "A", 1.0f, Color(0xFF2ECC71)) // Hijau
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewActivityProgressContainer() {
    ActivityProgressContainer()
}
