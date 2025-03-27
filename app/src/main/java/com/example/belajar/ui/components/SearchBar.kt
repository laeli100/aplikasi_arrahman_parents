package com.example.belajar.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    var searchText by remember { mutableStateOf("") }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp) // Tinggi search bar
            .background(Color(0xFFA7D7A9), shape = RoundedCornerShape(20.dp)) // Warna hijau muda & rounded
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search Icon",
            tint = Color(0xFF4E6C50), // Warna ikon hijau gelap
            modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.width(8.dp)) // Jarak antara ikon dan teks

        Box(Modifier.weight(1f)) {
            if (searchText.isEmpty()) {
                Text(
                    text = "Cari",
                    color = Color(0xFF4E6C50), // Warna teks placeholder
                    fontSize = 16.sp, // Ukuran teks diperbaiki
                    fontWeight = FontWeight.Medium
                )
            }

            BasicTextField(
                value = searchText,
                onValueChange = { searchText = it },
                singleLine = true,
                textStyle = TextStyle(
                    color = Color.Black, // Warna teks input
                    fontSize = 16.sp, // Ukuran teks input yang lebih proporsional
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchBar() {
    SearchBar()
}
