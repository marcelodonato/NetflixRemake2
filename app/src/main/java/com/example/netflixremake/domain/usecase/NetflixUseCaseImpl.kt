package com.example.netflixremake.domain.usecase

import com.example.netflixremake.R
import com.example.netflixremake.data.model.Category
import com.example.netflixremake.data.model.Movie
import com.example.netflixremake.domain.repository.NetflixRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import java.util.*

class NetflixUseCaseImpl(private val netflixRepository: NetflixRepository) : NetflixUseCase {
    override suspend fun getCategories(): Flow<List<Category>> = flow {

         fun mockMovies(): List<Movie> {
            return listOf(
                Movie(R.drawable.movie_4),
                Movie(R.drawable.placeholder_bg),
                Movie(R.drawable.movie),
                Movie(R.drawable.placeholder_bg),
                Movie(R.drawable.placeholder_bg),
                Movie(R.drawable.movie_4),
                Movie(R.drawable.movie),
            )
        }

         fun mockCategories(): List<Category> {
            return listOf(
                Category("Nome da categoria1", mockMovies()),
                Category("Nome da categoria2", mockMovies()),
                Category("Nome da categoria3", mockMovies()),
                Category("Nome da categoria4", mockMovies()),
                Category("Nome da categoria4", mockMovies()),
                Category("Nome da categoria4", mockMovies()),
            )
        }


        val body = mockCategories()
        netflixRepository.getCategories(body).collect{
            emit(it)
        }
    }
}