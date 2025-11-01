package com.example.labweek7soal2.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labweek7.ui.model.AlbumDisplay
import com.example.labweek7.ui.model.ArtistDisplay
import com.example.labweek7.ui.model.TrackDisplay
import com.example.labweek7soal2.data.dto.Artist

@Composable
fun AlbumDetailView(
    modifier: Modifier = Modifier,
    artist: ArtistDisplay,
    album: AlbumDisplay,
    tracks: TrackDisplay

) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .height(100.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            artist.name?.let {
                Text(
                    it,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }


        Spacer(modifier = Modifier.height(16.dp))

        AlbumDetailCard(
            album = AlbumDisplay(
                id = album.id,
                title = album.title,
                year = album.year,
                thumbUrl = album.thumbUrl,
                description =  album.description,
                genre = album.genre
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(modifier = modifier) {

            Text(
                text = "Tracks",
                color = Color(0xFFAEAC96),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn {
                items(tracks) { index -> track
                    TrackCard(
                        track = TrackDisplay(
                            id = index.id,
                            title = index.title,
                            duration = index.duration
                        )
                    )
            }
        }

    }
}
}



@Composable
@Preview
fun AlbumDetailViewPreview() {
    AlbumDetailView(
        modifier = Modifier,
        artist = ArtistDisplay(
            id = "TODO()",
            name = "Bjahihadahd",
            genre = "Bob",
            biography = "Tuyl",
            thumbUrl = "TODO()",
            bannerUrl = "TODO()",
            fanartUrl = "TODO()"
        ),
        album = AlbumDisplay(
            id = "TODO()",
            title = "Best Hits",
            year = "2002",
            thumbUrl = "TODO()",
            description = "Classic album",
            genre = "Pop"
        ),
        tracks = TrackDisplay(
            id = "TODO()",
            title = "Best Hits",
            duration = "20:02"
        )
    )
}
