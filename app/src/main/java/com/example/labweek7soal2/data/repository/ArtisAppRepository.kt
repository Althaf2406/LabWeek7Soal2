import com.example.labweek7soal2.data.dto.Album
import com.example.labweek7soal2.data.dto.Artist
import com.example.labweek7soal2.data.dto.Track


class ArtisAppRepository(private val service: AudioDbService) {

    suspend fun searchArtist(name: String): Result<List<Artist>> {
        return try {
            val resp = service.searchArtist(name)
            if (resp.isSuccessful) {
                val body = resp.body()
                Result.success(body?.artists ?: emptyList())
            } else {
                Result.failure(Exception("HTTP ${resp.code()} ${resp.message()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun searchAlbums(artistName: String): Result<List<Album>> {
        return try {
            val resp = service.searchAlbums(artistName)
            if (resp.isSuccessful) {
                val body = resp.body()
                Result.success(body?.album ?: emptyList())
            } else Result.failure(Exception("HTTP ${resp.code()} ${resp.message()}"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getAlbumById(albumId: String): Result<Album?> {
        return try {
            val resp = service.albumDetail(albumId)
            if (resp.isSuccessful) {
                val body = resp.body()
                Result.success(body?.album?.firstOrNull())
            } else Result.failure(Exception("HTTP ${resp.code()}"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getTracks(albumId: String): Result<List<Track>> {
        return try {
            val resp = service.tracks(albumId)
            if (resp.isSuccessful) {
                val body = resp.body()
                Result.success(body?.track ?: emptyList())
            } else Result.failure(Exception("HTTP ${resp.code()}"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

