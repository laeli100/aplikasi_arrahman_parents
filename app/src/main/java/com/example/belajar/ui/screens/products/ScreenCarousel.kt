import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.belajar.R

@Composable
fun VerticalCarousel() {
    val items = List(10) { "Card #$it" }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        items(items) { item ->
            CarouselCard(item)
        }
    }
}

@Composable
fun CarouselCard(text: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.boxpengumuman),
            contentDescription = "profil",
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp) // Adjust card height
                .padding()
        )
        Text(text = text, fontSize = 18.sp)
    }
}

@Composable
@Preview
fun VerticalListScreenPreview() {
    VerticalCarousel()
}