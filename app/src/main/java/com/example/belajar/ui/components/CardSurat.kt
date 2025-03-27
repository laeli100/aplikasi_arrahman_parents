package com.example.belajar.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardSurat(
    nomor: Int,
    namaSurat: String,
    artiSurat: String,
    jumlahAyat: Int,
    tanggalSetoran: String,
    nilai: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF032B35))
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = nomor.toString(),
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(end = 8.dp)
            )

            Column(modifier = Modifier.weight(1f).padding(start = 20.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = namaSurat,
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "($artiSurat)",
                        color = Color.LightGray,
                        fontSize = 14.sp
                    )
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White)
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = "$jumlahAyat Ayat",
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Tanggal Setoran :\n$tanggalSetoran",
                    color = Color.LightGray,
                    fontSize = 12.sp,
                    lineHeight = 20.sp
                )
            }

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(getColorForGrade(nilai)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = nilai,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

fun getColorForGrade(grade: String): Color {
    return when (grade) {
        "A" -> Color(0xFF4E9F3D)
        "B" -> Color(0xFFFCBB53)
        "C" -> Color(0xFF78D6C6)
        "D" -> Color(0xFFAE0003)
        else -> Color.White
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCardSurat() {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        CardSurat(nomor = 1, namaSurat = "An-Naas", artiSurat = "Manusia", jumlahAyat = 6, tanggalSetoran = "14 Februari 2025", nilai = "A")
        CardSurat(nomor = 2, namaSurat = "Al-Falaq", artiSurat = "Waktu Subuh", jumlahAyat = 5, tanggalSetoran = "15 Februari 2025", nilai = "B")
        CardSurat(nomor = 3, namaSurat = "Al-Ikhlas", artiSurat = "Ikhlas", jumlahAyat = 4, tanggalSetoran = "16 Februari 2025", nilai = "C")
        CardSurat(nomor = 4, namaSurat = "Al-Kafirun", artiSurat = "Orang Kafir", jumlahAyat = 6, tanggalSetoran = "17 Februari 2025", nilai = "D")
    }
}
