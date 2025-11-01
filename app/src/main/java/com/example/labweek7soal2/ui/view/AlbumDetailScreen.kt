package com.example.labweek7soal2.ui.view

import ArtisViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labweek7soal2.data.dto.Track

@Composable
fun AlbumDetailScreen(aVM: ArtisViewModel, onBack: ()->Unit) {
    val state = aVM.uiState
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        IconButton(
            onClick = onBack
        ) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription=null)
        }
        state.selectedAlbum?.let { album ->
            Text(album.strAlbum ?: "",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)
            Text("Released: ${album.intYearReleased ?: "-"}")

            Spacer(Modifier.height(12.dp))

            Text(album.strDescriptionEN ?: "",
                maxLines = 6,
                overflow = TextOverflow.Ellipsis)

            Spacer(Modifier.height(12.dp))
        }

        Divider()
        Text("Tracks", fontWeight = FontWeight.Medium)
        LazyColumn {
            items(state.tracks) { track ->
                TrackRow(track)
            }
        }
    }
}

@Composable
fun TrackRow(track: Track) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
        Text(
            text = track.strTrack ?: "Unknown Track",
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
        Text(
            text = "Duration: ${track.intDuration ?: "Unknown"} sec",
            fontSize = 13.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
@Preview
fun AlbumDetailScreenPreview() {
    AlbumDetailScreen
}

