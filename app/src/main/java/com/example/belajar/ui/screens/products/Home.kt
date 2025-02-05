package com.example.belajar.ui.screens.products

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
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
fun HomePage(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8F8)) // Light background
            .padding(5.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Header Section
        SeksiHeader()

        Saldo()

        // Points and Balance Section
        PointsAndBalanceSection()

        Spacer(modifier = Modifier.height(2.dp))

        // Features Section
        Box(
            modifier = Modifier
                .padding(vertical = 5.dp, horizontal = 20.dp)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            Row() {
                ImageBox(imageRes = R.drawable.emading, "E-Mading")
                Spacer(modifier = Modifier.padding(horizontal = 30.dp))
                ImageBox(imageRes = R.drawable.icjadwal, "Aktivitas")
                Spacer(modifier = Modifier.padding(horizontal = 30.dp))
                ImageBox(imageRes = R.drawable.iceraport, "E-Raport")
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Box(
            modifier = Modifier
                .padding(vertical = 5.dp, horizontal = 20.dp)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            Row() {
                FeatureButton(R.drawable.iccalendaracademic, "Kalender Akademik")
                Spacer(modifier = Modifier.padding(horizontal = 25.dp))
                FeatureButton(R.drawable.icmilestone, "Setoran Hafalan")
                Spacer(modifier = Modifier.padding(horizontal = 25.dp))
                FeatureButton(R.drawable.icrules, "Peraturan")
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        // Announcements
        AnnouncementSection()

        Spacer(modifier = Modifier.height(2.dp))

        // Children Section
        SantriCard()
        Spacer(modifier = Modifier.padding(paddingValues))
    }
}

@Composable
fun MainHomePageScreeen() {
    Scaffold(
        bottomBar = { CustomBottomAppBar() }
    ) { paddingValues ->
        HomePage(paddingValues)
    }
}

@Composable
fun ImageBox(imageRes: Int, label: String) {
    Box(
        modifier = Modifier
            .width(80.dp) // Lebar tetap
            .wrapContentHeight() // Tinggi disesuaikan dengan konten
            .clip(RoundedCornerShape(16.dp)) // Membuat sudut melengkung
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Semua elemen di tengah secara horizontal
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .width(78.dp)
                    .height(78.dp)
                    .clip(RoundedCornerShape(16.dp)) // Membuat sudut melengkung
                    .drawBehind {
                        drawRect(
                            color = Color(0x80032B35), // Warna bayangan dengan opacity 50%
                            topLeft = Offset(0f, -3f), // Menggeser bayangan ke atas (-3.dp)
                            size = Size(size.width, size.height + 0f), // Blur ditambahkan ke tinggi
                            alpha = 0.1f
                        )
                    }
            ) {
                Image(
                    painter = painterResource(id = imageRes), // Gambar Anda
                    contentDescription = label,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp)), // Bentuk sudut gambar
                    contentScale = ContentScale.Crop // Memastikan gambar sesuai
                )
            }
            Spacer(modifier = Modifier.height(8.dp)) // Tambahkan jarak antara gambar dan teks
            Text(
                text = label,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 14.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}



@Composable
fun Saldo() {
    Row(modifier = Modifier.padding(horizontal = 15.dp)) {
        Box(modifier = Modifier.size(46.dp)) {
            Image(
                painter = painterResource(id = R.drawable.icspp), // Gambar Anda
                contentDescription = "eMading Icon",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp)), // Bentuk sudut gambar
                contentScale = ContentScale.Crop // Memastikan gambar sesuai
            )
        }
        Spacer(modifier = Modifier.width(20.dp))
        Box(
            modifier = Modifier
                .width(67.dp)
                .height(44.dp)
                .background(
                    color = Color(0xFF032B35), // Warna latar belakang utama
                    shape = RoundedCornerShape(25.dp) // Bentuk oval
                )
                .border(
                    width = 4.dp,
                    color = Color(0xFF78D6C6), // Warna border
                    shape = RoundedCornerShape(25.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "SPP",
                color = Color.White, // Warna teks putih
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
                fontSize = 20.sp,
                textAlign = TextAlign.Start
            )
        }
        Spacer(modifier = Modifier.width(20.dp))
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

@Composable
fun SeksiHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {

        FotoProfilOrtu(modifier = Modifier.size(80.dp))

        Spacer(modifier = Modifier.width(5.dp))

        // Greeting and Title
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 10.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.hometext), // Ganti dengan drawable daun Anda
                contentDescription = "Background Text",
                modifier = Modifier
                    .fillMaxWidth()
                    .width(239.dp)
                    .height(200.dp)

            )
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
    val borderWidth = 1.dp
    val gradientBrush = Brush.linearGradient(
        colors = listOf(
            Color(0xFF78D6C6),
            Color(0xFF032B35)
        ),
        start = Offset(0f, 0f),
        end = Offset(0f, Float.POSITIVE_INFINITY)
    )

    Box(
        modifier = modifier
            .size(
                80.dp + borderWidth * 1,
                110.dp + borderWidth * 1
            ) // Menyesuaikan ukuran dengan border
            .background(
                brush = gradientBrush,
                shape = RoundedCornerShape(9.dp)
            ) // Menggunakan background untuk border
            .padding(borderWidth) // Memberikan ruang untuk Card di dalam border
    ) {
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(9.dp),
            modifier = Modifier
                .fillMaxSize() // Pastikan Card menyesuaikan Box di dalamnya
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(2.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = iconRes),
                    contentDescription = label,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = label,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 14.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.padding(2.dp))
            }
        }
    }
}

@Composable
fun AnnouncementSection() {
    Column(modifier = Modifier.padding(10.dp)) {
        Box(modifier = Modifier.padding(5.dp))
        Text(
            text = "Pengumuman Utama",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF032B35),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(4.dp))
        VerticalCarousel()
    }
}

@Preview
@Composable
fun HomePagePreview() {
    MainHomePageScreeen()
}