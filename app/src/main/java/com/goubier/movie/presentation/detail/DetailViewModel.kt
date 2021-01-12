package com.goubier.movie.presentation.detail

import android.app.Application
import androidx.lifecycle.*
import com.goubier.movie.data.repository.DatabaseRepository
import com.goubier.movie.data.repository.OmdbRepository
import com.goubier.movie.domain.model.MovieDetail
import com.goubier.movie.domain.repository.BookmarkRepository
import com.goubier.movie.domain.repository.MovieRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class DetailViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: MovieRepository = OmdbRepository()

    private val repositoryBookmark: BookmarkRepository = DatabaseRepository()

    private val _state = MutableLiveData<DetailState>()
    val state: LiveData<DetailState> get() = _state

    fun getMovieDetail(id: String) {
        _state.value = DetailState.LoadingState

        viewModelScope.launch {
            try {
                _state.value = DetailState.SuccessState(repository.getMovieDetail(id))
            } catch (e: Exception) {
                _state.value = DetailState.ErrorState
            }
        }
    }

    fun addBookmark(movieDetail: MovieDetail) {
        viewModelScope.launch {
            repositoryBookmark.addBookmark(getApplication(), movieDetail)
        }
    }
}