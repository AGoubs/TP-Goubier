package com.goubier.movie.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.goubier.movie.data.mock.MockSearchRepository
import com.goubier.movie.domain.repository.SearchRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class SearchViewModel : ViewModel() {
    private val repository: SearchRepository = MockSearchRepository()

    private val _state = MutableLiveData<SearchState>()
    val state : LiveData<SearchState> get() = _state

    fun searchMovie(text: String) {
        _state.value = SearchState.LoadingState

        viewModelScope.launch {
            try {
                _state.value = SearchState.SuccessState(repository.searchMovie(text))
            } catch (e: Exception) {
                _state.value = SearchState.ErrorState
            }
        }
    }
}