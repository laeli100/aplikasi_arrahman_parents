package com.example.belajar

import CalendarScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import com.example.belajar.ui.screens.products.HafalanScreen
import com.example.belajar.ui.screens.products.KalenderAkademikScreen
import com.example.belajar.ui.screens.products.KasusScreen
import com.example.belajar.ui.screens.products.RincianBelajar
import com.example.belajar.ui.screens.products.eRaportScreen
import com.example.belajar.ui.theme.BelajarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BelajarTheme {
                Surface {
                    KalenderAkademikScreen()
                }
            }
        }
    }
}