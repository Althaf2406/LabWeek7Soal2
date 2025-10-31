package com.example.labweek7.data.container

import ArtisAppRepository
import ArtisViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ArtisAppContainer {

    companion object {
        const val BASE_URL = "https://www.theaudiodb.com/api/v1/json/123/"
    }

    val retrofit = Retrofit.Builder()
        .baseUrl("https://www.theaudiodb.com/api/v1/json/123/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(ArtisAppService::class.java)
    val repo = ArtisAppRepository(service)
    val aVM = ArtisViewModel(repo)
}
