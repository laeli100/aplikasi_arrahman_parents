package com.example.belajar.ui.screens.products


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.belajar.R
import com.example.belajar.ui.components.ButtonBack
import com.example.belajar.ui.components.FilterMading
import com.example.belajar.ui.components.TopHeader

@Composable
fun RincianMading() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ) {
        ButtonBack()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.imgnews),
                contentDescription = "Gambar berita",
                modifier = Modifier.fillMaxSize()
            )
        }
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Info PPDB Tahun Ajaran 2024/2025",
                    color = Color(0xFF845924),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Spacer(modifier = Modifier.height(10.dp))

                FilterMading(
                    modifier = Modifier
                        .width(100.dp)
                        .height(20.dp),
                    text = "PPDB",
                    fontSize = 15
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    color = Color(0xFFAA7C43),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }

    }
}

@Preview
@Composable
fun RincianMadingPreview() {
    RincianMading()
}