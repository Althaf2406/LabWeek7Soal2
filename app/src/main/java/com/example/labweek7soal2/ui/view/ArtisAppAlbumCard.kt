package com.example.labweek7soal2.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.labweek7soal2.data.dto.Album
import com.example.labweek7soal2.data.dto.Artist

@Composable
fun ArtisAppAlbumCard(
    artist: Artist,
    onClick: () -> Unit,
    album: Album
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }) {
        Row(
            modifier = Modifier
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                artist.strArtist ?: "Unknown",
                fontWeight = FontWeight.Bold)

            Spacer(Modifier.width(8.dp))

            Text(artist.strGenre ?: "",
                color = Color.Gray)
        }
    }
}

@Composable
@Preview
fun ArtisAppAlbumCardPreview() {
    ArtisAppAlbumCard(
        artist = Artist(
            idArtist = "1",
            strArtist = "Artist Name",
            strGenre = "Genre",
            strBiographyEN = "Biography",
            strArtistThumb = null,
            strArtistBanner = null,
            strArtistLogo = null,
            strArtistClearart = null,
            strArtistWideThumb = null,
            strArtistFanart = null,
            strArtistAlternate = null,
            strLabel = null,
            intFormedYear = null,
            strMood = null,
            strWebsite = null,
            strFacebook = null,
            strTwitter = null,
            strBiographyFR = null,
            strBiographyDE = null,
            strBiographyCN = null,
            strBiographyIT = null,
            strBiographyJP = null,
            strBiographyES = null,
            strBiographyPT = null,
            strBiographySE = null,
            strBiographyNL = null,
            strBiographyHU = null,
            strBiographyNO = null,
            strBiographyIL = null,
            strGender = null,
            strStyle = null,
            strCountry = null,
            strLocked = null,
            strCountryCode = null,
            idLabel = null,
            intBornYear = null,
            intCharted = null,
            intDiedYear = null,
            intMembers = null,
            strArtistCutout = null,
            strArtistFanart2 = null,
            strArtistFanart3 = null,
            strArtistFanart4 = null,
            strArtistStripped = null,
            strBiographyPL = null,
            strBiographyRU = null,
            strDisbanded = null,
            strISNIcode = null,
            strLastFMChart = null,
            strMusicBrainzID = null,
        ),
        onClick = {},
        album = Album(
            idAlbum = "1",
            strAlbum = "Album Name",
            strArtist = "Artist Name",
            strAlbumThumb ="",
            intYearReleased =  "",
            strGenre = "",
            strDescriptionEN = "",
        )

    )

}
