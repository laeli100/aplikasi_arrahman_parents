package com.example.belajar.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.belajar.R

@Composable
fun FotoProfilOrtu(modifier: Modifier = Modifier, size: Int = 150, showBorder: Boolean = true) {
    val borderWidth = (size * 0.05f).dp // Border menyesuaikan ukuran
    val imageSize = size.dp // Ukuran gambar tanpa border

    Box(
        modifier = Modifier
            .size(imageSize + (if (showBorder) borderWidth * 2 else 0.dp)) // Total ukuran termasuk border jika ada
            .then(modifier) // Menggabungkan modifier tambahan jika ada
            .drawBehind {
                if (showBorder) { // Hanya menggambar border jika showBorder = true
                    val gradientBrush = Brush.linearGradient(
                        colors = listOf(Color(0xFFFCBB53), Color(0xFF78D6C6)),
                        start = Offset(0f, 0f),
                        end = Offset(0f, this.size.height) // Gunakan `this.size.height`
                    )
                    val radius = (this.size.width / 2) - (borderWidth.toPx() / 2)

                    drawCircle(
                        brush = gradientBrush,
                        radius = radius,
                        style = Stroke(width = borderWidth.toPx()),
                        center = Offset(this.size.width / 2, this.size.height / 2)
                    )
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.profilortu),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(imageSize) // Ukuran gambar di dalam border
                .clip(CircleShape)
        )
    }
}

@Preview
@Composable
fun FotoProfilOrtuPreview() {
    FotoProfilOrtu(Modifier, 162, showBorder = true) // Bisa diubah ukurannya dan border bisa disembunyikan
}

@Preview
@Composable
fun FotoProfilOrtuNoBorderPreview() {
    FotoProfilOrtu(Modifier, 120, showBorder = false) // Versi tanpa border
}