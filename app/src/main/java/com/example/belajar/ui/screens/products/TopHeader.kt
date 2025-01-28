package com.example.belajar.ui.screens.products

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.belajar.R

@Composable
fun TopHeader(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 32.dp), // Padding untuk tata letak
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .size(60.dp) // Ukuran kontainer
                .clip(RoundedCornerShape(16.dp)) // Membuat sudut melengkung
                .drawBehind {
                    drawRect(
                        color = Color(0x80032B35), // Warna bayangan dengan opacity 50%
                        topLeft = Offset(0f, -3f), // Menggeser bayangan ke atas (-3.dp)
                        size = Size(size.width, size.height + 0f), // Blur ditambahkan ke tinggi
                        alpha = 0.2f
                    )
                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.emading), // Gambar Anda
                contentDescription = "eMading Icon",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp)), // Bentuk sudut gambar
                contentScale = ContentScale.Crop // Memastikan gambar sesuai
            )
        }

        // Teks di tengah
        Text(
            text = "e-MADING",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1B5E20),
            letterSpacing = 5.sp// Warna teks
        )

        Box(
            modifier = Modifier
                .size(60.dp) // Ukuran total lingkaran luar
                .clip(CircleShape)
                .background(color = Color(0xFFFCBB53)), // Warna latar lingkaran kecil
            contentAlignment = Alignment.Center // Pusatkan logo di dalam lingkaran
        ) {
            Image(
                painter = painterResource(id = R.drawable.ichome),
                contentDescription = "Logo Ar-Rahman",
                modifier = Modifier
                    .size(54.dp), // Ukuran logo lebih besar dari lingkaran
                contentScale = ContentScale.Crop // Memastikan logo di-crop dengan benar
            )
        }
    }
}

@Preview
@Composable
fun TopHeaderPreview(){
    TopHeader()
}