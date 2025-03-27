package com.example.belajar.ui.screens.products

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.belajar.R
import com.example.belajar.ui.components.ButtonBack
import com.example.belajar.ui.components.FilterMading

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RincianBelajar() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Gambaran", "Kandungan")

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                        Text(
                            "Rincian Belajar",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                    }
                },
                navigationIcon = { ButtonBack() },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Transparent,
                    titleContentColor = Color(0xFF392A19),
                    navigationIconContentColor = Color(0xFF392A19)
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(top = 15.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.imgrincianbelajar),
                contentDescription = "Gambar berita",
                modifier = Modifier.fillMaxWidth()
            )
            Box(modifier = Modifier.padding(10.dp)) {
                Column {
                    Text(
                        "Fardhu Ain",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF392A19)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    FilterMading(
                        modifier = Modifier
                            .width(150.dp)
                            .height(20.dp),
                        text = "Asas Fardhu Ain",
                        fontSize = 15
                    )
                }
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                TabRow(
                    selectedTabIndex = selectedTabIndex,
                    contentColor = Color(0xFF392A19),
                    indicator = { tabPositions ->
                        TabRowDefaults.Indicator(
                            Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                            color = Color(0xFF392A19)
                        )
                    }
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTabIndex == index,
                            onClick = { selectedTabIndex = index },
                            text = {
                                Text(
                                    title,
                                    color = if (selectedTabIndex == index) Color(0xFF392A19) else Color.Gray
                                )
                            }
                        )
                    }
                }
            }

            when (selectedTabIndex) {
                0 -> GambaranScreen()
                1 -> KandunganScreen()
            }
        }
    }
}

@Composable
fun GambaranScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(
            "Ayo memperkukuhkan asas ilmu agama melalui pendidikan Fardu Ain. Modul ini menguraikan tuntutan-tuntutan kewajiban ke atas setiap individu Muslim agar akidah dan hukum-hukum asas yang bersifat Fardu Ain dapat dipraktikkan secara menyeluruh demi mendorong kesungguhan dalam mengamalkan cara hidup agama Islam.\n" +
                    "\n" +
                    "Penyampai:\n" +
                    "\n" +
                    "1. Sahibus Samahah Dato' Setia Prof. Madya Dr. Haji Anhar bin Haji Opir\n" +
                    "\n" +
                    "2. Dato' Haji Badli Shah bin Haji Alauddin\n" +
                    "\n" +
                    "3. Dr. Syed Shahridzan bin Syed Mohamed",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Justify,
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
        Row {
            Image(
                painter = painterResource(id = R.drawable.ceklisbar),
                contentDescription = "Ustadz Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            Text(
                "Memperkukuh asas-asas agama Islam menerusi pendidikan Fardu Ain.",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Justify
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        Row {
            Image(
                painter = painterResource(id = R.drawable.ceklisbar),
                contentDescription = "Ustadz Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            Text(
                "Mengetahui rukun-rukun Iman dan Islam.",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Justify
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        Row {
            Image(
                painter = painterResource(id = R.drawable.ceklisbar),
                contentDescription = "Ustadz Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            Text(
                "Memahami asas bersuci dan beribadah.",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Justify
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        Row {
            Image(
                painter = painterResource(id = R.drawable.ceklisbar),
                contentDescription = "Ustadz Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            Text(
                "Menghuraikan tuntutan-tuntuan kewajipan ke atas setiap individu Muslim agar hukum hakam asas yang bersifat fardu 'ain dapat dipraktikkan secara menyeluruh.",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Composable
fun KandunganScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 5.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.icdoc),
                contentDescription = "Ikon Dokumen",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            Text(
                "Ilmu Asas Fardhu Ain",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Start,
                modifier = Modifier.weight(1f)
            )
            Image(
                painter = painterResource(id = R.drawable.icdownload),
                contentDescription = "Ikon download",
                modifier = Modifier
                    .size(50.dp)
                    .clickable {
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRincianBelajar() {
    RincianBelajar()
}
