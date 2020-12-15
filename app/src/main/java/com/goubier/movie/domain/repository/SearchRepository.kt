package com.goubier.movie.domain.repository

import com.goubier.movie.domain.model.MovieShort

interface SearchRepository {

   suspend fun searchMovie(search : String) : List<MovieShort>
}