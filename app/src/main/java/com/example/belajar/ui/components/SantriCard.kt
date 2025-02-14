package com.example.belajar.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.belajar.R

@Composable
fun SantriCard() {
    Column (modifier = Modifier.padding(5.dp)) {
        Text(text = "Data Santri",
            fontSize = 16.sp,
            color = Color(0xff032B35), // Warna teks putih
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold))
        OutlinedCard(
            colors = CardDefaults.cardColors(containerColor = Color(0xffAAD5A2)),
            border = BorderStroke(1.dp, Color.Black),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.profil_santri),
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                            .border(
                                width = 2.dp,
                                color = Color.Black,
                                shape = CircleShape
                            )
                    )
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Iska Puspa Dewi",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Divider(
                            color = Color(0xFFFCBB53),
                            thickness = 5.dp,
                            modifier = Modifier
                                .padding(vertical = 4.dp)
                                .fillMaxWidth()
                        )
                        Text(
                            text = "santriwati",
                            fontSize = 16.sp,
                            color = Color.Black,
                            letterSpacing = 15.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }

                Spacer(modifier = Modifier.height(5.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    InfoChip(
                        label = "MTs",
                        chipColor = Color(0xFF78D6C6), // Warna latar belakang chip
                        circleColor = Color(0xFFFCBB53), // Warna lingkaran
                        chipBorderColor = Color.Black, // Warna border chip
                        circleBorderColor = Color.Black // Warna border lingkaran
                    )
                    InfoChip(
                        label = "VIII.A",
                        chipColor = Color(0xFF032B35), // Warna latar belakang chip
                        circleColor = Color(0xFF78D6C6), // Warna lingkaran
                        chipBorderColor = Color(0xFF78D6C6), // Warna border chip
                        circleBorderColor = Color(0xFFFCBB53) // Warna border lingkaran
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    InfoElement(
                        label = "NIS     | 18.0958 \nNISN  | 0034136072",
                        chipColor = Color(0xFF032B35),
                        chipBorderColor = Color(0xFF78D6C6),
                        width = 150.dp, // Lebar chip
                        height = 75.dp // Tinggi chip
                    )
                    InfoElement(
                        label = "NSM     | 129827492 \nNPSM  | 1039248",
                        chipColor = Color(0xFF78D6C6),
                        chipBorderColor = Color(0xFF032B35),
                        width = 150.dp, // Lebar chip
                        height = 75.dp // Tinggi chip
                    )
                }
            }
        }
    }
}

@Composable
fun InfoChip(
    label: String,
    chipColor: Color = Color(0xFF78D6C6), // Warna default chip
    circleColor: Color = Color(0xFFFCBB53), // Warna default lingkaran
    chipBorderColor: Color = Color.Black, // Warna default border chip
    circleBorderColor: Color = Color.Black // Warna default border lingkaran
) {
    Surface(
        shape = androidx.compose.foundation.shape.RoundedCornerShape(50),
        color = chipColor, // Warna chip bisa diubah
        modifier = Modifier
            .padding(1.dp)
            .wrapContentSize(),
        border = BorderStroke(1.dp, chipBorderColor) // Warna border chip bisa diubah
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            // Lingkaran warna oranye
            Box(
                modifier = Modifier
                    .size(16.dp) // Ukuran lingkaran
                    .clip(CircleShape)
                    .background(circleColor) // Warna lingkaran bisa diubah
                    .border(
                        width = 1.dp, // Ketebalan garis tepi
                        color = circleBorderColor, // Warna border lingkaran bisa diubah
                        shape = CircleShape // Bentuk lingkaran
                    )
            )

            Spacer(modifier = Modifier.width(8.dp)) // Jarak antara lingkaran dan teks

            // Teks
            Text(
                text = label,
                color = Color.White, // Warna teks
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun InfoElement(
    label: String,
    chipColor: Color = Color.Black, // Warna default chip
    chipBorderColor: Color = Color.Black, // Warna default border chip
    width: Dp = 100.dp, // Lebar default chip
    height: Dp = 40.dp // Tinggi default chip
) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        color = chipColor, // Warna chip bisa diubah
        modifier = Modifier
            .padding(1.dp)
            .size(width = width, height = height), // Mengatur ukuran chip
        border = BorderStroke(1.dp, chipBorderColor) // Warna border chip bisa diubah
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                horizontal = 10.dp,
                vertical = 4.dp
            ).fillMaxWidth().fillMaxHeight() // Sesuaikan padding jika perlu
        ) {
            // Teks
            Text(
                text = label,
                color = Color.White, // Warna teks
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f) // Agar teks tetap rapi di tengah
            )
        }
    }
}


@Preview
@Composable
fun SantriCardPreview() {
    SantriCard()
}