
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.labweek7soal2.data.dto.Album
import com.example.labweek7soal2.data.dto.Artist
import com.example.labweek7soal2.data.dto.Track

data class ArtistUiState(
    val isLoading: Boolean = false,
    val artistList: List<Artist> = emptyList(),
    val albums: List<Album> = emptyList(),
    val tracks: List<Track> = emptyList(),
    val selectedArtist: Artist? = null,
    val selectedAlbum: Album? = null,
    val error: String? = null
)

class ArtisViewModel(private val repo: ArtisAppRepository): ViewModel() {
    var uiState by mutableStateOf(ArtistUiState())
        private set

    fun searchArtist(name: String) {
        uiState = uiState.copy(isLoading = true, error = null)
        viewModelScope.launch {
            val res = repo.searchArtist(name)
            uiState = if (res.isSuccess) {
                uiState.copy(isLoading = false, artistList = res.getOrDefault(emptyList()))
            } else {
                uiState.copy(isLoading = false, error = res.exceptionOrNull()?.localizedMessage)
            }
        }
    }

    fun loadAlbumsForArtist(artistName: String, artist: Artist) {
        uiState = uiState.copy(isLoading = true, error = null, selectedArtist = artist)
        viewModelScope.launch {
            val res = repo.searchAlbums(artistName)
            uiState = if (res.isSuccess) {
                uiState.copy(isLoading = false, albums = res.getOrDefault(emptyList()))
            } else {
                uiState.copy(isLoading = false, error = res.exceptionOrNull()?.localizedMessage)
            }
        }
    }

    fun loadAlbumDetail(albumId: String) {
        uiState = uiState.copy(isLoading = true, error = null)
        viewModelScope.launch {
            val albumRes = repo.getAlbumById(albumId)
            val tracksRes = repo.getTracks(albumId)
            uiState = if (albumRes.isSuccess && tracksRes.isSuccess) {
                uiState.copy(isLoading = false,
                    selectedAlbum = albumRes.getOrThrow(),
                    tracks = tracksRes.getOrDefault(emptyList()))
            } else {
                val err = albumRes.exceptionOrNull()?.message ?: tracksRes.exceptionOrNull()?.message
                uiState.copy(isLoading = false, error = err)
            }
        }
    }



}
