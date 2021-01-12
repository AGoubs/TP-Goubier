package com.goubier.movie.data.repository

import android.content.Context
import com.goubier.movie.data.database.AppDatabase
import com.goubier.movie.data.database.model.Bookmark
import com.goubier.movie.domain.model.MovieDetail
import com.goubier.movie.domain.model.MovieShort
import com.goubier.movie.domain.repository.BookmarkRepository

class DatabaseRepository : BookmarkRepository {

    override suspend fun getBookmark(context: Context): List<MovieShort> {
        return AppDatabase.getInstance(context)?.getBookmarkDao()?.getAllBookmark()?.map {
            it.toMovieShort()
        } ?: emptyList()
    }

    override suspend fun addBookmark(context: Context, movieDetail: MovieDetail) {
        val bookmark = movieDetail.toBookmark()

        AppDatabase.getInstance(context)?.getBookmarkDao()?.addBookmark(bookmark)
    }
}

fun Bookmark.toMovieShort() = MovieShort(id, title, poster)

fun MovieDetail.toBookmark() = Bookmark(id, title, poster)