package com.example.belajar.ui.screens.products

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.belajar.R

@Composable
fun CustomBottomAppBar() {
    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        containerColor = Color(0xFF00283A) // Warna gelap dari background
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Ikon sebelah kiri
            IconButton(onClick = { /* TODO: Handle click */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.icchat), // Ganti dengan resource ikon Anda
                    contentDescription = "Chat Icon",
                    tint = Color.Unspecified
                )
            }

            // Logo di tengah
            Box(
                modifier = Modifier
                    .background(Color.Transparent)
                    .size(56.dp), // Ukuran logo
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ichome), // Ganti dengan logo Anda
                    contentDescription = "Logo",
                    tint = Color.Unspecified // Biarkan warna asli logo
                )
            }

            // Ikon sebelah kanan
            IconButton(onClick = { /* TODO: Handle click */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.icprofil), // Ganti dengan resource ikon profil Anda
                    contentDescription = "Profile Icon",
                    tint = Color.Unspecified
                )
            }
        }
    }
}

@Preview
@Composable
fun CustomBottomAppBarPreview(){
    CustomBottomAppBar()
}