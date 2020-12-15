package com.goubier.movie.presentation.search

import com.goubier.movie.domain.model.MovieShort

sealed class SearchState {
    class SuccessState(val movies:List<MovieShort>) : SearchState()

    object ErrorState : SearchState()

    object LoadingState : SearchState()
}
