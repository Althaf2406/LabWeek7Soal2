package com.example.labweek7soal2.ui.view


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labweek7.ui.model.TrackDisplay

@Composable
fun TrackCard(
    track: TrackDisplay
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1C1C1C))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Nomor track
            Box(
                modifier = Modifier
                    .size(26.dp)
                    .background(Color(0xFFAEAC96), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = track.id.toString(),
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Judul lagu
            Text(
                text = track.title?: "Unknown Track",
                color = Color(0xFFAEAC96),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.weight(1f).padding(horizontal = 16.dp)
            )

            // Durasi lagu
            Text(
                text = track.duration?: "Unknown Duration",
                color = Color(0xFFAEAC96),
                fontSize = 14.sp
            )
        }
    }
}

@Composable
@Preview
fun TrackCardPreview() {
    TrackCard(
        track = TrackDisplay(
            id = "1",
            title = "Song Title",
            duration = "03:45"
        )
    )
}
