package com.example.belajar.ui.screens.products

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.belajar.R

@Composable
fun CustomBottomAppBar() {
    // State untuk menyimpan bar yang aktif
    val activeBar = remember { mutableStateOf("Home") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp) // Meningkatkan tinggi untuk ruang animasi
            .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
            .background(Color(0xFF00283A))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Ikon Kiri (Chat)
            IconWithAnimation(
                isActive = activeBar.value == "Chat",
                onClick = { activeBar.value = "Chat" },
                iconRes = R.drawable.icchat,
                description = "Chat Icon"
            )

            // Logo Tengah (Home)
            Box(
                modifier = Modifier
                    .size(72.dp) // Membuat lingkaran sedikit lebih besar
                    .clip(CircleShape)
                    .background(Color.White), // Latar belakang tetap putih
//                    .align(Alignment.TopCenter), // Selalu berada di tengah atas
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ichome),
                    contentDescription = "Home Icon",
                    modifier = Modifier.size(48.dp), // Ikon besar di tengah
                    tint = Color.Unspecified // Tidak ada efek perubahan warna
                )
            }

            // Ikon Kanan (Profile)
            IconWithAnimation(
                isActive = activeBar.value == "Profile",
                onClick = { activeBar.value = "Profile" },
                iconRes = R.drawable.icprofil,
                description = "Profile Icon"
            )
        }
    }
}

@Composable
fun IconWithAnimation(
    isActive: Boolean,
    onClick: () -> Unit,
    iconRes: Int,
    description: String
) {
    // Animasi posisi vertikal
//    val verticalOffset by animateDpAsState(
//        targetValue = if (isActive) (-10).dp else 0.dp, // Naik 10 dp jika aktif
//        animationSpec = tween(durationMillis = 300) // Durasi animasi
//    )

    IconButton(
        onClick = onClick,
//        modifier = Modifier.padding(top = verticalOffset) // Efek gerakan vertikal
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = description,
            tint = Color.Unspecified // Tetap menggunakan warna asli ikon
        )
    }
}

@Preview
@Composable
fun CustomBottomAppBarPreview() {
    CustomBottomAppBar()
}
