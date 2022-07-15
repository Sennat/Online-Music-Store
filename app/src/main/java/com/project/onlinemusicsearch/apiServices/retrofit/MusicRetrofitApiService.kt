package com.project.onlinemusicsearch.apiServices.retrofit

import com.project.onlinemusicsearch.data.SongsResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicRetrofitApiService {

    @GET("/search")
    fun getSongsCatalog (
        // Get dynamic parameters
        //https://itunes.apple.com/search?term=classick&amp;media=music&amp;entity=song&amp;limit=50
        @Query("term") term: String,
        @Query("amp;media") media: String = "music",
        @Query("amp;entity") entity: String = "song",
        @Query("amp;limit") limit: Int = 50
    ): Call<SongsResponse>

    companion object {
        private val BASE_URL: String = "https://itunes.apple.com"
        private var retrofit: Retrofit? = null

        // Create a singleton instance of Retrofit object
        fun getRetrofitInstance(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return  retrofit
        }
    }
}