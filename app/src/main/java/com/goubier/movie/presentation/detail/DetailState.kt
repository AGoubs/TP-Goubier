package com.goubier.movie.presentation.detail

import com.goubier.movie.domain.model.MovieDetail

sealed class DetailState {
    class SuccessState(val movie:MovieDetail) : DetailState()

    object ErrorState : DetailState()

    object LoadingState : DetailState()
}
