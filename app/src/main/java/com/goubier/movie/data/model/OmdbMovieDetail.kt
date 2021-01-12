package com.goubier.movie.data.model

import com.google.gson.annotations.SerializedName

data class OmdbMovieDetail(
    @SerializedName("imdbID")
    val imdbId: String,
    @SerializedName("Title")
    val title: String,
    @SerializedName("Year")
    val year: String,
    @SerializedName("Director")
    val director: String,
    @SerializedName("Plot")
    val description: String,
    @SerializedName("Actors")
    val actors: String,
    @SerializedName("Poster")
    val poster:String,
)
