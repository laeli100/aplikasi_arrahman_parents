package com.example.belajar.ui.screens.products

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
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
fun HomePage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8F8)) // Light background
            .padding(8.dp)
    ) {
        // Header Section
        SeksiHeader()

        Spacer(modifier = Modifier.height(8.dp))

        // Points and Balance Section
        PointsAndBalanceSection()

        Spacer(modifier = Modifier.height(2.dp))

        // Features Section
        Row() {
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
        }

        Spacer(modifier = Modifier.padding(5.dp))
        FeatureButton(R.drawable.iccalendaracademic, "Kalender Akademik")

        Spacer(modifier = Modifier.height(16.dp))

        // Announcements
//        AnnouncementSection()

        Spacer(modifier = Modifier.height(4.dp))

        // Children Section
        SantriCard()
    }
}

@Composable
fun SeksiHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {

        FotoProfilOrtu(modifier = Modifier.size(89.dp))

        Spacer(modifier = Modifier.width(5.dp))

        // Greeting and Title
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painterResource(R.drawable.hometext), // Ganti dengan drawable daun Anda
                contentDescription = "Background Text",
                modifier = Modifier
                    .fillMaxWidth()
                    .width(239.dp)
                    .height(200.dp)

            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.height(140.dp))
                Box(
                    modifier = Modifier
                        .width(197.dp)
                        .height(35.dp)
                        .background(
                            color = Color(0xFFFCBB53), // Warna latar belakang utama
                            shape = RoundedCornerShape(25.dp) // Bentuk oval
                        )
                        .border(
                            width = 4.dp,
                            color = Color(0xFF4E9F3D), // Warna border
                            shape = RoundedCornerShape(25.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Halo Umi Siti Rahmi!",
                        color = Color.White, // Warna teks putih
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontWeight = FontWeight.Normal
                        ),
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun PointsAndBalanceSection() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
    }
}

@Composable
fun FeatureButton(iconRes: Int, label: String, modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Color.Black),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .size(67.dp, 103.dp) // Ukuran tombol
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(1.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.iccalendaracademic),
                contentDescription = "Kalender Akademik",
                modifier = Modifier.fillMaxWidth() // Ukuran ikon lebih kecil agar proporsional
            )
            Spacer(modifier = Modifier.padding(1.dp)) // Jarak antara ikon dan teks
            Text(
                text = "Kalender Akademik",
                fontSize = 12.sp, // Menyesuaikan ukuran teks
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun HomePagePreview() {
    HomePage()
}