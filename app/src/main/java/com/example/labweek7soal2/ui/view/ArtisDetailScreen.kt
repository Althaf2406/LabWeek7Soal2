package com.example.labweek7soal2.ui.view

import ArtisViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labweek7soal2.data.dto.Album

@Composable
fun ArtistDetailScreen(
    aVM: ArtisViewModel,
    onAlbumClick: (Album) -> Unit) {
    val state = aVM.uiState

    Column(
        modifier = Modifier
            .fillMaxSize().padding(16.dp)
    ) {
        state.selectedArtist?.let { a ->
            Text(
                a.strArtist ?: "",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold)

            Text(
                a.strGenre ?: "",
                color = Color.Gray)

            Spacer(Modifier.height(12.dp))

            Text(a.strBiographyEN ?: "",
                maxLines = 6,
                overflow = TextOverflow.Ellipsis)

            Spacer(Modifier.height(12.dp))

        }
        Text(
            "Albums", fontWeight = FontWeight.Medium)
        Spacer(Modifier.height(8.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxWidth(),
            content = {
                items(state.albums) { album ->
                    ArtisAppAlbumCard (album = album, onClick = { onAlbumClick(album) })
                }
            }
        )
    }
}
