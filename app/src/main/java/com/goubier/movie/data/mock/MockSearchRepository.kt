package com.goubier.movie.data.mock

import com.goubier.movie.domain.model.MovieShort
import com.goubier.movie.domain.repository.SearchRepository

class MockSearchRepository : SearchRepository {

    override suspend fun searchMovie(search: String): List<MovieShort> {
        return listOf(
            MovieShort("1", "Titre 1", "https://i.kym-cdn.com/entries/icons/mobile/000/020/147/drake.jpg"),
            MovieShort("2", "Titre 2", "https://cdn.discordapp.com/attachments/774960721901518858/786254732728598598/Alex.PNG"),
            MovieShort("3", "Titre 3", "https://cdn.discordapp.com/attachments/774960721901518858/786254732728598598/Alex.PNG"),
            MovieShort("4", "Titre 4", "https://cdn.discordapp.com/attachments/774960721901518858/786254732728598598/Alex.PNG"),
        )
    }
}