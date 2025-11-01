package com.example.labweek7soal2.ui.view

import ArtisViewModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.labweek7.ui.routes.ArtisAppRoutes

@Composable
fun ArtisAppView(aVM: ArtisViewModel) {
    var currentRoute by remember { mutableStateOf(ArtisAppRoutes.OPEN) }

    when (currentRoute) {
        ArtisAppRoutes.AWAL -> SearchArtistScreen(
            aVM = aVM,
            onArtistClick = { artist ->
                aVM.loadAlbumsForArtist(
                    artist.strArtist ?: "",
                    artist = artist
                )
                currentRoute = ArtisAppRoutes.ARTIST_DETAIL
            }
        )

        ArtisAppRoutes.ARTIST_DETAIL -> ArtistDetailScreen(
            aVM = aVM,
            onAlbumClick = { album ->
                aVM.loadAlbumDetail(album.idAlbum ?: "")
                currentRoute = ArtisAppRoutes.ALBUM_DETAIL
            },
            onBack = { currentRoute = ArtisAppRoutes.SEARCH }
        )

        ArtisAppRoutes.ALBUM_DETAIL -> AlbumDetailScreen(
            aVM = aVM,
            onBack = { currentRoute = ArtisAppRoutes.ARTIST_DETAIL }
        )
    }
}
