package com.example.labweek7soal2.ui.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun AlbumDetailCard(
    modifier: Modifier = Modifier,
    imageUrl: String?,
    albumName: String?,
    releaseYear: String?,
    genre: String?,
    description: String?
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(BorderStroke(1.dp, Color.Gray.copy(alpha = 0.4f)), RoundedCornerShape(8.dp)),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF212121))
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = imageUrl,
                contentDescription = albumName,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF212121))
                    .padding(14.dp)
            ) {
                Text(
                    text = albumName ?: "Unknown Album",
                    color = Color(0xFFAEAC96),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "$releaseYear • $genre",
                    color = Color(0xFFAEAC96),
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = description ?: "No description available.",
                    color = Color(0xFFAEAC96),
                    fontSize = 13.sp,
                    lineHeight = 20.sp
                )
            }
        }
    }
}

@Composable
@Preview
fun AlbumDetailCardPreview() {
    AlbumDetailCard(
        imageUrl = "",
        albumName = "Room for Squares",
        releaseYear = "2001",
        genre = "Pop Rock",
        description = "Debut album by John Mayer featuring hits like 'No Such Thing' and 'Your Body Is a Wonderland.'"
    )
}
