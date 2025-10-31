package com.example.labweek7.ui.model


import com.example.labweek7soal2.data.dto.Album
import com.example.labweek7soal2.data.dto.Artist
import com.example.labweek7soal2.data.dto.Track

data class ArtistDisplay(
    val id: String,
    val name: String,
    val genre: String,
    val biography: String,
    val thumbUrl: String?,
    val bannerUrl: String?
) {
    companion object {
        fun from(api: Artist): ArtistDisplay {
            return ArtistDisplay(
                id = api.idArtist ?: "",
                name = api.strArtist ?: "Unknown Artist",
                genre = api.strGenre ?: "Unknown Genre",
                biography = api.strBiographyEN ?: "No biography available.",
                thumbUrl = api.strArtistThumb,
                bannerUrl = api.strArtistBanner
            )
        }
    }
}

data class AlbumDisplay(
    val id: String,
    val title: String,
    val year: String?,
    val thumbUrl: String?,
    val description: String?
) {
    companion object {
        fun from(api: Album): AlbumDisplay {
            return AlbumDisplay(
                id = api.idAlbum ?: "",
                title = api.strAlbum ?: "Untitled Album",
                year = api.intYearReleased,
                thumbUrl = api.strAlbumThumb,
                description = api.strDescriptionEN
            )
        }
    }
}

data class TrackDisplay(
    val id: String,
    val title: String,
    val duration: String?
) {
    companion object {
        fun from(api: Track): TrackDisplay {
            return TrackDisplay(
                id = api.idTrack ?: "",
                title = api.strTrack ?: "Unknown Track",
                duration = api.intDuration
            )
        }
    }
}
