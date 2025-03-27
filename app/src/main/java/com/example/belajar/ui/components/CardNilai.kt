package com.example.belajar.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun KelompokMapel(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(25))
            .border(2.dp, Color(0xFF4CAF50), RoundedCornerShape(25))
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun NilaiMapel (title: String, score: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(25))
            .border(2.dp, Color(0xFF4CAF50), RoundedCornerShape(25))
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.weight(1f)
        )
        Box(
            modifier = Modifier
                .size(28.dp)
                .clip(CircleShape)
                .background(Color(0xFF4CAF50)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "$score",
                fontSize = 12.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.width(15.dp))
        Box(
            modifier = Modifier
                .size(28.dp) // Ukuran lingkaran
                .clip(CircleShape) // Membuat lingkaran
                .border(2.dp, Color(0xFF4CAF50), CircleShape), // Outline hijau
            contentAlignment = Alignment.Center
        ) {
            IconButton(onClick = { /* TODO: Implement action */ }) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Play",
                    tint = Color(0xFF4CAF50) // Warna ikon hijau
                )
            }
        }

    }
}

@Composable
fun ListNilai(title: String, score: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
            .background(Color.White, RoundedCornerShape(50))
            .border(2.dp, Color(0xFF4CAF50), RoundedCornerShape(50))
            .padding(horizontal = 15.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.weight(1f)
        )
        Box(
            modifier = Modifier
                .size(28.dp)
                .clip(CircleShape)
                .background(Color(0xFF4CAF50)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "$score",
                fontSize = 12.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.width(15.dp))
        Box(
            modifier = Modifier
                .size(28.dp) // Ukuran lingkaran
                .clip(CircleShape) // Membuat lingkaran
                .border(2.dp, Color(0xFF4CAF50), CircleShape), // Outline hijau
            contentAlignment = Alignment.Center
        ) {
            IconButton(onClick = { /* TODO: Implement action */ }) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Play",
                    tint = Color(0xFF4CAF50) // Warna ikon hijau
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomListItem() {
    Column {
        KelompokMapel(title = "1. Pendidikan Agama Islam")
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        ListNilai(title = "a. Al-Qur'an Hadist", score = 75)
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        NilaiMapel(title = "2. Bahasa Arab", score = 90)
    }
}
