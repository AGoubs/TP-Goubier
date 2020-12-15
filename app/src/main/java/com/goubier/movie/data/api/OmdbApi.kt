package com.goubier.movie.data.api

import com.goubier.movie.data.model.OmdbMovieDetail
import com.goubier.movie.data.model.OmdbSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OmdbApi {
    companion object {
        const val BASE_URL = "https://www.omdbapi.com/"
        const val API_KEY = "d6eb7a46"
    }

    @GET("/")
    suspend fun searchMovie(
        @Query("s") title: String,
        @Query("apikey") apiKey: String
    ) : OmdbSearchResponse


    @GET("/")
    suspend fun getMovieDetail(
        @Query("i") id: String,
        @Query("apikey") apiKey: String
    ) : OmdbMovieDetail
}