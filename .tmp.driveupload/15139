package com.example.belajar.ui.screens.products

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.belajar.R
import com.example.belajar.ui.components.ButtonBack

@Composable
fun RincianBelajar() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Gambaran", "Kandungan")

    Column(modifier = Modifier.fillMaxSize()) {
        ButtonBack()
        Image(
            painter = painterResource(R.drawable.profil_ust),
            contentDescription = "Gambar berita",
            modifier = Modifier.fillMaxWidth()
        )
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(title) }
                )
            }
        }

        when (selectedTabIndex) {
            0 -> DailyMissionsScreen()
            1 -> VoucherScreen()
        }
    }
}

@Composable
fun DailyMissionsScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text("Daily Missions Content", style = MaterialTheme.typography.displayLarge)
    }
}

@Composable
fun VoucherScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text("Voucher Content", style = MaterialTheme.typography.displayLarge)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRincianBelajar() {
    RincianBelajar()
}
