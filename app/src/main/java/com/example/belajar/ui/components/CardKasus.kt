import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CaseTitle(caseNumber: Int) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .width(165.dp)
                .height(30.dp)
                .clip(shape = RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp))
                .background(Color.White)
                .border(
                    2.dp,
                    Color.Black,
                    RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Kasus $caseNumber",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.Black
            )
        }
    }
}

@Composable
fun ViolationCard(
    caseNumber: Int,
    violationType: String,
    date: String,
    violationDetail: String,
    resolution: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, Color.Black, RoundedCornerShape(12.dp)),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF89D3C8))
    ) {
        CaseTitle(caseNumber)
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
            Spacer(modifier = Modifier.height(2.dp))
            Row {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Pelanggaran",
                        color = Color.Red,
                        fontWeight = FontWeight.Bold
                    )
                    Box(
                        modifier = Modifier
                            .width(116.dp)
                            .height(21.dp)
                            .clip(
                                shape = RoundedCornerShape(4.dp)
                            )
                            .background(Color(0xFFFCBB53)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = violationType,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box(
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(
                                    shape = RoundedCornerShape(4.dp)
                                )
                                .background(Color(0xFF097E9B))
                        )
                        Spacer(
                            modifier = Modifier.padding(horizontal = 5.dp)
                        )
                        Text(
                            text = buildAnnotatedString {
                                append("Tanggal Kejadian\n")
                                pushStyle(SpanStyle(fontWeight = FontWeight.ExtraBold))
                                append(date)
                                pop()
                            },
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box(
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(
                                    shape = RoundedCornerShape(4.dp)
                                )
                                .background(Color(0xFF032B35))
                        )
                        Spacer(
                            modifier = Modifier.padding(horizontal = 5.dp)
                        )
                        Text(
                            text = buildAnnotatedString {
                                append("Jenis Pelanggaran\n")
                                pushStyle(SpanStyle(fontWeight = FontWeight.ExtraBold))
                                append(violationDetail)
                                pop()
                            },
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                    }
                }
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.Start

                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF008000)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "\u2714",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Penyelesaian",
                            color = Color(0xFF032B35),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp
                        )
                    }
                    Text(
                        text = resolution,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Start,
                        color = Color.Black
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewViolationCard() {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        ViolationCard(
            caseNumber = 3,
            violationType = "PERIBADATAN",
            date = "22 Februari 2025",
            violationDetail = "Tidak Sholat",
            resolution = "Setoran hafalan 3 Surah (Al-Ikhlas, An-Naas, Al-Kafirun)"
        )
    }
}