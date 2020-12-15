package com.goubier.movie.domain.repository

import com.goubier.movie.domain.model.MovieDetail
import com.goubier.movie.domain.model.MovieShort

interface MovieRepository {

   suspend fun searchMovie(search : String) : List<MovieShort>

   suspend fun getMovieDetail(id :String) : MovieDetail
}