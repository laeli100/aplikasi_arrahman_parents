package com.example.belajar.ui.screens.products

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.belajar.R
import com.example.belajar.ui.components.CardHafalan
import com.example.belajar.ui.components.CardJuz
import com.example.belajar.ui.components.CardSurat
import com.example.belajar.ui.components.TopHeader

@Composable
fun HafalanScreen() {
    var selectedTab by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0FFEC)) // Background utama layar
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            TopHeader(
                logoRes = R.drawable.icmilestone,
                homeIconRes = R.drawable.ichome,
                namaFitur = "Catatan Hafalan"
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp)
        ) {
            Column {
                Spacer(modifier = Modifier.height(50.dp))

                Card(
                    shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                    border = BorderStroke(3.dp, Color(0xFF4E9F3D)),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceBright),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()

                    ) {
                        Image(
                            painter = rememberImagePainter(
                                ImageRequest.Builder(LocalContext.current)
                                    .data(R.drawable.bg1)
                                    .apply {
                                        crossfade(true)
                                    }
                                    .build()
                            ),
                            contentDescription = "Background Image",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CustomNavbar { index -> selectedTab = index }
                            com.example.belajar.ui.components.SearchBar(
                                modifier = Modifier.padding(
                                    vertical = 5.dp,
                                    horizontal = 10.dp
                                )
                            )
                            Spacer(modifier = Modifier.padding(10.dp))

                            when (selectedTab) {
                                0 -> AlQuranScreen()
                                1 -> FiqihScreen()
                                2 -> InggrisScreen()
                                3 -> ArabScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CustomNavbar(onTabSelected: (Int) -> Unit) {
    var selectedIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Al-Qur'an", "Fiqih", "Inggris", "Arab")

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clip(RoundedCornerShape(20.dp))
            .drawBehind {
                drawRect(color = Color(0x80032B35), alpha = 0.3f)
            }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            tabs.forEachIndexed { index, title ->
                val isSelected = index == selectedIndex
                val backgroundColor by animateColorAsState(
                    targetValue = if (isSelected) Color(0xFFFFA726) else Color(0x66D9D9D9)
                )

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(backgroundColor)
                        .clickable {
                            selectedIndex = index
                            onTabSelected(index)
                        }
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = title,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                }
            }
        }
    }
}

@Composable
fun AlQuranScreen() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Surat", "Tahfidz")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .drawBehind {
                val strokeWidth = 1.dp.toPx()
                drawLine(
                    color = Color.Gray,
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = strokeWidth
                )
                drawLine(
                    color = Color.Gray,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = strokeWidth
                )
            },
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            contentColor = Color(0xFF097E9B),
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                    color = Color(0xFF097E9B)
                )
            },
            containerColor = Color.Transparent // Hilangkan background TabRow
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = {
                        Text(
                            title,
                            color = if (selectedTabIndex == index) Color.Black else Color.DarkGray
                        )
                    },
                    modifier = Modifier.background(Color.Transparent)
                )
            }
        }
    }

    when (selectedTabIndex) {
        0 -> SuratScreen()
        1 -> TahfidzScreen()
    }
}

@Composable
fun SuratScreen() {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(10.dp).verticalScroll(rememberScrollState())){
        CardSurat(nomor = 1, namaSurat = "An-Naas", artiSurat = "Manusia", jumlahAyat = 6, tanggalSetoran = "14 Februari 2025", nilai = "A")
        CardSurat(nomor = 2, namaSurat = "Al-Falaq", artiSurat = "Waktu Subuh", jumlahAyat = 6, tanggalSetoran = "18 Februari 2025", nilai = "B")
        CardSurat(nomor = 3, namaSurat = "Al-Ikhlas", artiSurat = "Tulus Ikhlas", jumlahAyat = 6, tanggalSetoran = "14 Februari 2025", nilai = "C")
        CardSurat(nomor = 4, namaSurat = "An-Naas", artiSurat = "Manusia", jumlahAyat = 6, tanggalSetoran = "14 Februari 2025", nilai = "D")
        CardSurat(nomor = 5, namaSurat = "An-Naas", artiSurat = "Manusia", jumlahAyat = 6, tanggalSetoran = "14 Februari 2025", nilai = "")
    }
}

@Composable
fun TahfidzScreen() {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(10.dp)){
        CardSurat(nomor = 1, namaSurat = "Al-Baqarah", artiSurat = "Sapi Betina", jumlahAyat = 70, tanggalSetoran = "-", nilai = "")
        CardHafalan(nomor = 2, namaHafalan = "Khutbah Jum'at", tanggalSetoran = "17 Februari 2025", nilai = "D")
        CardJuz(no = 3, namaSurat = "Juz Pilihan", jumlahAyat = 3, tanggalSetoran = "25 Februari 2025", nilai = "B")
        CardJuz(no = 4, namaSurat = "Juz Pilihan", jumlahAyat = 10, tanggalSetoran = "-", nilai = "")
    }
}

@Composable
fun FiqihScreen() {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(10.dp)){
        CardHafalan(nomor = 1, namaHafalan = "Tata Cara Berwudhu", tanggalSetoran = "17 Februari 2025", nilai = "A")
        CardHafalan(nomor = 2, namaHafalan = "Tata Cara Bertayamum", tanggalSetoran = "14 Februari 2025", nilai = "B")
        CardHafalan(nomor = 3, namaHafalan = "Niat Sholat Wajib", tanggalSetoran = "25 Februari 2025", nilai = "A")
        CardHafalan(nomor = 4, namaHafalan = "Bacaan Sholat", tanggalSetoran = "17 Februari 2025", nilai = "C")
        CardHafalan(nomor = 5, namaHafalan = "Sholat Jenazah", tanggalSetoran = "17 Februari 2025", nilai = "D")
        CardHafalan(nomor = 6, namaHafalan = "Doa Sesudah Sholat", tanggalSetoran = "17 Februari 2025", nilai = "A")
    }
}

@Composable
fun InggrisScreen() {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(10.dp)){
        CardHafalan(nomor = 1, namaHafalan = "Vocabulary", tanggalSetoran = "17 Februari 2025", nilai = "A")
        CardHafalan(nomor = 2, namaHafalan = "Conversation", tanggalSetoran = "14 Februari 2025", nilai = "B")
        CardHafalan(nomor = 3, namaHafalan = "Grammar", tanggalSetoran = "25 Februari 2025", nilai = "A")
        CardHafalan(nomor = 4, namaHafalan = "Translate", tanggalSetoran = "17 Februari 2025", nilai = "C")
        CardHafalan(nomor = 5, namaHafalan = "Memorizing", tanggalSetoran = "17 Februari 2025", nilai = "D")
        CardHafalan(nomor = 6, namaHafalan = "Reading", tanggalSetoran = "17 Februari 2025", nilai = "A")
    }
}

@Composable
fun ArabScreen() {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(10.dp)){
        CardHafalan(nomor = 1, namaHafalan = "Al Mufradat", tanggalSetoran = "17 Februari 2025", nilai = "A")
        CardHafalan(nomor = 2, namaHafalan = "Muhadatsah", tanggalSetoran = "14 Februari 2025", nilai = "B")
        CardHafalan(nomor = 3, namaHafalan = "Nahwu", tanggalSetoran = "25 Februari 2025", nilai = "A")
        CardHafalan(nomor = 4, namaHafalan = "Shorof", tanggalSetoran = "17 Februari 2025", nilai = "C")
        CardHafalan(nomor = 5, namaHafalan = "Terjemah Bahasa Arab", tanggalSetoran = "17 Februari 2025", nilai = "D")
        CardHafalan(nomor = 6, namaHafalan = "Tarkib Bahasa Arab", tanggalSetoran = "17 Februari 2025", nilai = "A")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomNavbar() {
    HafalanScreen()
}
