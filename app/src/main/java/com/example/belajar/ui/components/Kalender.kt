import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.YearMonth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalendarScreen()
        }
    }
}

fun getEventDetails(year: Int, month: Int): Map<LocalDate, Pair<Color, String>> {
    return mapOf(
        LocalDate.of(year, month, 10) to Pair(Color(0xFF88C67D), "Acara Khusus"), // Hijau muda
        LocalDate.of(year, month, 15) to Pair(Color(0xFF78D6C6), "PTS"), // Tosca
        LocalDate.of(year, month, 30) to Pair(Color(0xFFAE0003), "PAS"), // Merah
        LocalDate.of(year, month, 20) to Pair(Color(0xFF4E9F3D), "Hari Libur") // Hijau tua
    )
}

@Composable
fun CalendarScreen() {
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
    var yearMonth by remember { mutableStateOf(YearMonth.now()) }

    val daysInMonth = yearMonth.lengthOfMonth()
    val firstDayOfMonth = yearMonth.atDay(1).dayOfWeek.value % 7 // 0 = Minggu

    // 🔹 Mendapatkan informasi event dari fungsi getEventDetails()
    val eventDetails = getEventDetails(yearMonth.year, yearMonth.monthValue)

    Box(
        modifier = Modifier
            .padding(16.dp)
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .padding(5.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // 🔹 Header Pilihan Bulan
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { yearMonth = yearMonth.minusMonths(1) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xffFCBB53),
                        contentColor = Color.White
                    )
                ) {
                    Text("<")
                }
                Text(
                    text = "${yearMonth.month} ${yearMonth.year}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(8.dp)
                )
                Button(
                    onClick = { yearMonth = yearMonth.plusMonths(1) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xffFCBB53),
                        contentColor = Color.White
                    )
                ) {
                    Text(">")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // 🔹 Header Hari (Baris Nama Hari)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                    .background(Color(0xFFFCBB53)), // Latar belakang oranye
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                listOf("Su", "Mo", "Tu", "We", "Th", "Fr", "Sa").forEachIndexed { index, day ->
                    Text(
                        text = day,
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        fontWeight = if (index == 0) FontWeight.Bold else FontWeight.Normal,
                        color = if (index == 0) Color(0xFFD32F2F) else Color.Black
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // 🔹 Grid Kalender (Tanggal)
            val days = (1..daysInMonth).map { it.toString() }
            val blankDays = List(firstDayOfMonth) { "" } + days

            LazyVerticalGrid(columns = GridCells.Fixed(7)) {
                items(blankDays) { day ->
                    val date = if (day.isNotEmpty()) {
                        LocalDate.of(yearMonth.year, yearMonth.month, day.toInt())
                    } else null

                    val backgroundColor = eventDetails[date]?.first ?: Color.Transparent

                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(backgroundColor, shape = CircleShape)
                            .clickable {
                                if (date != null) {
                                    selectedDate = date
                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = day,
                            textAlign = TextAlign.Center,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (backgroundColor != Color.Transparent) Color.White else Color.Black
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 🔹 Menampilkan Keterangan Event di Bawah Kalender
            eventDetails[selectedDate]?.let { event ->
                Text(
                    text = "📅 ${selectedDate.dayOfMonth} ${selectedDate.month} ${selectedDate.year}: ${event.second}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            } ?: Text(
                text = "Tidak ada acara pada tanggal ini.",
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CalendarPreview() {
    CalendarScreen()
}
