package com.example.labweek7soal2.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.labweek7.ui.model.AlbumDisplay
import com.example.labweek7.ui.model.ArtistDisplay
import com.example.labweek7soal2.data.dto.Artist

@Composable
fun AlbumDetailView(
    modifier: Modifier = Modifier,
    artist: ArtistDisplay,
    album: AlbumDisplay

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
            imageUrl = artist.fanartUrl ?: artist.bannerUrl ?: artist.thumbUrl,
            albumName = artist.name,
            releaseYear = album.year,
            genre = album.genre,
            description = album.description ?: "No description available."
        )


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
            id = "1",
            title = "First Album",
            year = "2000",
            thumbUrl = "TODO()",
            description = "TODO()",
            genre = "TODO()",
        )
    )
}