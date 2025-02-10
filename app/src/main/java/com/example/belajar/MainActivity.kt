package com.example.belajar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.belajar.ui.screens.products.CreateProduct
import com.example.belajar.ui.screens.products.CustomBottomAppBar
import com.example.belajar.ui.screens.products.HistoryChat
import com.example.belajar.ui.screens.products.HomePage
import com.example.belajar.ui.screens.products.MainHistoryChartScreeen
import com.example.belajar.ui.screens.products.MainHomePageScreeen
import com.example.belajar.ui.screens.products.ProfileScreen
import com.example.belajar.ui.screens.products.VerticalCarousel
import com.example.belajar.ui.screens.products.eMading
import com.example.belajar.ui.theme.BelajarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BelajarTheme {
                Surface {
                    MainHomePageScreeen()
                }
            }
        }
    }
}