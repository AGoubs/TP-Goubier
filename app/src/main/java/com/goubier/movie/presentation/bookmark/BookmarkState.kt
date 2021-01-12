package com.goubier.movie.presentation.bookmark

import com.goubier.movie.domain.model.MovieShort

sealed class BookmarkState {
    class SuccessState(val movies:List<MovieShort>) : BookmarkState()

    object ErrorState : BookmarkState()

    object LoadingState : BookmarkState()
}
