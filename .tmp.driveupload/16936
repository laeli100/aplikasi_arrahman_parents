package com.example.belajar.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.belajar.R

@Composable
fun ButtonBack() {
    Row(
        modifier = Modifier.fillMaxWidth().height(50.dp).background(color = Color(0xFFffffff)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.btnback3),
            contentDescription = "Profile Picture",
            modifier = Modifier.size(60.dp)
        )

        Spacer(modifier = Modifier.padding(horizontal = 5.dp))

        Text(
            text = "Kembali",
            color = Color.DarkGray,
            fontSize = 18.sp,
            fontFamily = FontFamily.SansSerif
        )
    }
}

@Preview
@Composable
fun PreviewButtonBack() {
    ButtonBack()
}