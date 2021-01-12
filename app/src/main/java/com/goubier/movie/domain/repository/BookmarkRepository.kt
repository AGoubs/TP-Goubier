package com.goubier.movie.domain.repository

import android.content.Context
import com.goubier.movie.domain.model.MovieDetail
import com.goubier.movie.domain.model.MovieShort

interface BookmarkRepository {

    suspend fun getBookmark(context: Context): List<MovieShort>

    suspend fun addBookmark(context: Context, movieDetail: MovieDetail)
}