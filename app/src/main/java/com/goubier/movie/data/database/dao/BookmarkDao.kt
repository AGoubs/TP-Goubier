package com.goubier.movie.data.database.dao

import androidx.room.*
import com.goubier.movie.data.database.model.Bookmark

@Dao
interface BookmarkDao {

    @Query("SELECT * FROM bookmark")
    suspend fun getAllBookmark(): List<Bookmark>

    @Query("SELECT * FROM bookmark WHERE id = :id")
    suspend fun getBookmark(id: String): Bookmark

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBookmark(bookmark: Bookmark)

    @Delete
    suspend fun deleteBookmark(bookmark: Bookmark)
}