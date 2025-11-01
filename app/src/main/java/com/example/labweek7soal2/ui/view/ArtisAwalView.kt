package com.example.LabWeek7.ui.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.labweek7.ui.model.AlbumDisplay
import com.example.labweek7soal2.data.dto.Artist
import com.example.labweek7soal2.ui.view.AlbumCard

@Composable
fun ArtistAwalView(
    albums: List<AlbumDisplay>,
    modifier: Modifier = Modifier,
    onAlbumClick: (albumId: String) -> Unit,
    artist: Artist
) {
    Column (
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
            artist.strArtist?.let {
                Text(
                    it,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }


        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
        ) {
            Box {
                AsyncImage(
                    model = artist.strArtistFanart ?: artist.strArtistBanner ?: artist.strArtistThumb,
                    contentDescription = artist.strArtist,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(380.dp),
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .background(
                            Color.Black
                        )
                )
                Column(
                    Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    artist.strArtist?.let {
                        Text(
                            it,
                            style = MaterialTheme.typography.headlineMedium
                        )
                    }
                    Text(
                        artist.strGenre ?: "Unknown Genre",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(albums) { album ->
                AlbumCard(
                    album = album,
                    onClick = { onAlbumClick(album.id) }
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ArtisAwalViewPreview() {
    ArtistAwalView(
        artist = Artist(
            idArtist = "1",
            idLabel = "",
            intBornYear = "",
            intCharted = "",
            intDiedYear = "",
            intFormedYear = "",
            intMembers = "",
            strArtist = "LUIIIIII",
            strArtistAlternate = "",
            strArtistBanner = "",
            strArtistClearart = "",
            strArtistCutout = "",
            strArtistFanart = "",
            strArtistFanart2 = "",
            strArtistFanart3 = "",
            strArtistFanart4 = "",
            strArtistLogo = "",
            strArtistStripped = "",
            strArtistThumb = "",
            strArtistWideThumb = "",
            strBiographyCN = "",
            strBiographyDE = "",
            strBiographyEN = "",
            strBiographyES = "",
            strBiographyFR = "",
            strBiographyHU = "",
            strBiographyIL = "",
            strBiographyIT = "",
            strBiographyJP = "",
            strBiographyNL = "",
            strBiographyNO = "",
            strBiographyPL = "",
            strBiographyPT = "",
            strBiographyRU = "",
            strBiographySE = "",
            strCountry = "",
            strCountryCode = "",
            strDisbanded = "",
            strFacebook = "",
            strGender = "",
            strGenre = "Gacor!!!!",
            strISNIcode = "",
            strLabel = "",
            strLastFMChart = "",
            strLocked = "",
            strMood = "",
            strMusicBrainzID = "",
            strStyle = "",
            strTwitter = "",
            strWebsite = "",
        ),
        albums = listOf(
            AlbumDisplay(
                id = "1",
                title = "First Album",
                year = "2000",
                thumbUrl = "https://placehold.co/300x300",
                description = "First album description",
                genre = "Rock"
            ),
            AlbumDisplay(
                id = "2",
                title = "Second Album",
                year = "2002",
                thumbUrl = "https://placehold.co/300x300",
                description = "Second album description",
                genre = "Pop"
            ),
            AlbumDisplay(
                id = "2",
                title = "Second Album",
                year = "2002",
                thumbUrl = "https://placehold.co/300x300",
                description = "Second album description",
                genre = "Pop"
            ),
            AlbumDisplay(
                id = "2",
                title = "Second Album",
                year = "2002",
                thumbUrl = "https://placehold.co/300x300",
                description = "Second album description",
                genre = "Pop"
            ),
            AlbumDisplay(
                id = "2",
                title = "Second Album",
                year = "2002",
                thumbUrl = "https://placehold.co/300x300",
                description = "Second album description",
                genre = "Pop"
            ),
            AlbumDisplay(
                id = "2",
                title = "Second Album",
                year = "2002",
                thumbUrl = "https://placehold.co/300x300",
                description = "Second album description",
                genre = "Pop"
            ),
            AlbumDisplay(
                id = "2",
                title = "Second Album",
                year = "2002",
                thumbUrl = "https://placehold.co/300x300",
                description = "Second album description",
                genre = "Pop"
            ),
            AlbumDisplay(
                id = "2",
                title = "Second Album",
                year = "2002",
                thumbUrl = "https://placehold.co/300x300",
                description = "Second album description",
                genre = "Pop"
            ),
            AlbumDisplay(
                id = "2",
                title = "Second Album",
                year = "2002",
                thumbUrl = "https://placehold.co/300x300",
                description = "Second album description",
                genre = "Pop"
            ),
            AlbumDisplay(
                id = "2",
                title = "Second Album",
                year = "2002",
                thumbUrl = "https://placehold.co/300x300",
                description = "Second album description",
                genre = "Pop"
            ),
            AlbumDisplay(
                id = "2",
                title = "Second Album",
                year = "2002",
                thumbUrl = "https://placehold.co/300x300",
                description = "Second album description",
                genre = "Pop"
            )
        ),
        modifier = Modifier,
        onAlbumClick = { /* preview click */ }
    )
}
