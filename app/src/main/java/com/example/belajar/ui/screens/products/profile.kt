package com.example.belajar.ui.screens.products

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.belajar.R

@Composable
fun ProfileScreen(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F7))
//            .padding(16.dp)
    ) {
        HeaderSection()
        Spacer(
            modifier = Modifier
                .height(5.dp)
                .padding(5.dp)
        )
        SantriCard()
        Spacer(modifier = Modifier.height(16.dp))
        ActionItems()
    }
}

@Composable
fun HeaderSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF7F7F7))
            .padding(vertical = 2.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painterResource(R.drawable.bgprofil), // Ganti dengan drawable daun Anda
                contentDescription = "Background Leaves",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(302.dp)
                    .width(461.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.height(130.dp)) // Spacer untuk memberikan jarak dari daun

                FotoProfilOrtu(modifier = Modifier.size(162.dp))

                Spacer(modifier = Modifier.height(8.dp))

                Box(
                    modifier = Modifier
                        .width(174.dp)
                        .height(50.dp)
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
                        text = "Siti Rahmi",
                        color = Color.White, // Warna teks putih
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}


@Composable
fun ActionItems() {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Notifikasi")
            Spacer(modifier = Modifier.weight(1f))
            Switch(checked = true, onCheckedChange = {})
        }
        Divider()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /* Handle edit profile */ }
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Edit Profil")
            Spacer(modifier = Modifier.weight(1f))
            Icon(Icons.Default.ArrowForward, contentDescription = null)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /* Handle edit child bio */ }
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Edit Biodata Anak")
            Spacer(modifier = Modifier.weight(1f))
            Icon(Icons.Default.ArrowForward, contentDescription = null)
        }
        Divider()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /* Handle logout */ }
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Logout")
            Spacer(modifier = Modifier.weight(1f))
            Icon(Icons.Default.ExitToApp, contentDescription = null)
        }
    }
}

@Composable
fun MainProfileScreenScreeen(){
    Scaffold(
        bottomBar = {CustomBottomAppBar()}
    ) { paddingValues ->
        ProfileScreen(paddingValues)
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    MainProfileScreenScreeen()
}
