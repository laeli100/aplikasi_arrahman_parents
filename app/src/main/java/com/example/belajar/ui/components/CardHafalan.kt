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
fun CardHafalan(
    nomor: Int,
    namaHafalan: String,
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

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 20.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = namaHafalan,
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(5.dp))

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


@Preview(showBackground = true)
@Composable
fun PreviewCardHafalan() {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        CardHafalan(
            nomor = 1,
            namaHafalan = "Tata Cara Berwudhu",
            tanggalSetoran = "14 Februari 2025",
            nilai = "A"
        )
        CardHafalan(
            nomor = 2,
            namaHafalan = "Al-Falaq",
            tanggalSetoran = "15 Februari 2025",
            nilai = "B"
        )
        CardHafalan(
            nomor = 3,
            namaHafalan = "Al-Ikhlas",
            tanggalSetoran = "16 Februari 2025",
            nilai = "C"
        )
        CardHafalan(
            nomor = 4,
            namaHafalan = "Al-Kafirun",
            tanggalSetoran = "17 Februari 2025",
            nilai = "D"
        )
    }
}
