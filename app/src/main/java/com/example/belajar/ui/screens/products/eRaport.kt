package com.example.belajar.ui.screens.products

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.belajar.R
import com.example.belajar.ui.components.ActivityProgressBar
import com.example.belajar.ui.components.ActivityProgressContainer
import com.example.belajar.ui.components.ButtonBack
import com.example.belajar.ui.components.FilterMading
import com.example.belajar.ui.components.KelompokMapel
import com.example.belajar.ui.components.ListNilai
import com.example.belajar.ui.components.NilaiMapel
import com.example.belajar.ui.components.TopHeader

@Composable
fun eRaportScreen() {
    var selectedClass by remember { mutableStateOf("Kelas VII") }
    var selectedSemester by remember { mutableStateOf("Semester 1") }

    val classOptions = listOf("Kelas VII", "Kelas VIII", "Kelas IX")
    val semesterOptions = listOf("Semester 1", "Semester 2")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0FFEC))
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            TopHeader(
                logoRes = R.drawable.iceraport,
                homeIconRes = R.drawable.ichome,
                namaFitur = "e-Raport"
            )
            Spacer(modifier = Modifier.height(50.dp))
            Card(
                shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                border = BorderStroke(3.dp, Color(0xFF4E9F3D)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceBright)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
//                        .verticalScroll(rememberScrollState())
                ) {
                    Image(
                        painter = rememberImagePainter(
                            ImageRequest.Builder(LocalContext.current)
                                .data(R.drawable.bg1)
                                .crossfade(true)
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
                        Text(
                            text = "Capaian Hasil Belajar",
                            modifier = Modifier.padding(10.dp),
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF032B35)
                            )
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Row {
                            DropdownMenuComponent(
                                options = classOptions,
                                selectedOption = selectedClass,
                                onOptionSelected = { selectedClass = it }
                            )
                            Spacer(modifier = Modifier.width(25.dp))
                            DropdownMenuComponent(
                                options = semesterOptions,
                                selectedOption = selectedSemester,
                                onOptionSelected = { selectedSemester = it }
                            )
                        }

                        //Tab
                        var selectedTabIndex by remember { mutableStateOf(0) }
                        val tabs = listOf("Raport", "P5")

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
                                contentColor = Color(0xFF78D6C6),
                                indicator = { tabPositions ->
                                    TabRowDefaults.Indicator(
                                        Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                                        color = Color(0xFF78D6C6)
                                    )
                                },
                                containerColor = Color.Transparent
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
                            0 -> NilaiRaport()
                            1 -> p5()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun NilaiRaport() {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            ActivityProgressBar(
                "Pramuka",
                "B",
                0.5f,
                Color(0xFF76D7C4)
            ) // Tosca
            ActivityProgressBar(
                "Karate",
                "C",
                0.33f,
                Color(0xFFE74C3C)
            ) // Merah
            ActivityProgressBar(
                "Tilawatil Qur’an",
                "A",
                1.0f,
                Color(0xFF2ECC71)
            ) // Hijau
        }
    }

    Spacer(modifier = Modifier.height(5.dp))
    Card(
        shape = RoundedCornerShape(16.dp), // Sudut lengkung
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp), // Shadow
        colors = CardDefaults.cardColors(containerColor = Color(0xFFEDEDED)), // Warna putih
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(2.dp, Color.Black, RoundedCornerShape(16.dp))
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .verticalScroll(
                    rememberScrollState()
                ),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            KelompokMapel(title = "1. Pendidikan Agama Islam")
            ListNilai(title = "a. Al-Qur'an Hadist", score = 75)
            ListNilai(title = "b. Akidah Akhlak", score = 80)
            ListNilai(title = "c. Fiqih", score = 95)
            ListNilai(title = "d. SKI", score = 80)
            NilaiMapel(title = "2. Pendidikan Kewarganegaraan", score = 95)
            NilaiMapel(title = "3. Bahasa Indonesia", score = 100)
            NilaiMapel(title = "4. Bahasa Arab", score = 80)
            NilaiMapel(title = "5. Matematika", score = 80)
            NilaiMapel(title = "6. Sejarah", score = 85)
            NilaiMapel(title = "7. Bahasa Inggris", score = 75)
            KelompokMapel(title = "8. Kelompok Wajib (B)")
            ListNilai(title = "a. Seni Budaya", score = 85)
            ListNilai(title = "b. Penjaskes", score = 90)
            ListNilai(title = "c. Prakarya", score = 86)
            KelompokMapel(title = "9. Peminatan (Kelompok C)")
            ListNilai(title = "a. Matematika", score = 89)
            ListNilai(title = "b. Biologi", score = 100)
            ListNilai(title = "c. Kimia", score = 65)
        }
    }
}

@Composable
fun p5() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFFFFFFF))
    ) {
        Spacer(modifier = Modifier.height(2.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.imgprakarya),
                contentDescription = "Gambar berita",
                modifier = Modifier.fillMaxSize()
            )
        }
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Proyek Penguatan Profil Pelajar Pancasila",
                    color = Color(0xFF032B35),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold
                )

                Spacer(modifier = Modifier.padding(vertical = 5.dp))
                Divider(
                    color = Color.Gray,
                    thickness = 2.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 2.dp)
                )
                Spacer(modifier = Modifier.padding(vertical = 5.dp))
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Justify
                )
            }
        }

    }
}

@Composable
fun DropdownMenuComponent(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = Modifier.padding(horizontal = 3.dp)) {
        Row {
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { expanded = true },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF032B35),
                    contentColor = Color.White
                ), border = BorderStroke(2.dp, Color(0xFF78D6C6))
            ) {
                Text(text = selectedOption)
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.background(Color(0xFF032B35))
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option, color = Color.White) },
                        onClick = {
                            onOptionSelected(option)
                            expanded = false
                        },
                        colors = MenuDefaults.itemColors(
                            textColor = Color.White,
                            disabledTextColor = Color.Gray
                        )
                    )
                }
            }

        }
    }
}

@Preview
@Composable
fun eRaportScreenPreview() {
    eRaportScreen()
}