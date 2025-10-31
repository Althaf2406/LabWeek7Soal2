import com.example.labweek7soal2.data.dto.AlbumApp
import com.example.labweek7soal2.data.dto.ArtisApp
import com.example.labweek7soal2.data.dto.TrackApp
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ArtisAppService {
    @GET("search.php")
    suspend fun searchArtist(@Query("s") artistName: String): Response<ArtisApp>
    @GET("searchalbum.php")
    suspend fun searchAlbums(@Query("s") artistName: String): Response<AlbumApp>
    @GET("album.php")
    suspend fun albumDetail(@Query("m") albumId: String): Response<AlbumApp>
    @GET("track.php")
    suspend fun tracks(@Query("m") albumId: String): Response<TrackApp>
}
