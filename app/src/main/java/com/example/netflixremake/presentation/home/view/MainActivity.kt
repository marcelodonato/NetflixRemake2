package com.example.netflixremake.presentation.home.view

import android.os.Bundle
import com.example.netflixremake.R
import com.example.netflixremake.base.BaseActivity
import com.example.netflixremake.base.BaseViewModel
import com.example.netflixremake.data.model.Category
import com.example.netflixremake.data.model.Movie
import com.example.netflixremake.databinding.ActivityMainBinding
import com.example.netflixremake.extension.viewBinding

class MainActivity : BaseActivity<BaseViewModel>() {
    override val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
    }

    private fun mockTest(): MutableList<Category> {

        val categories = mutableListOf<Category>()
        for (j in 0 until 5) {
            val movies = mutableListOf<Movie>()
            for (i in 0 until 15) {
                val movie = Movie(R.drawable.movie)
                movies.add(movie)
            }
            val category = Category("cat $j", movies)
            categories.add(category)
        }
        return categories
    }

    private fun mockMovies(): List<Movie> {
        val movies = mutableListOf<Movie>()
        repeat(15) {
            movies.add(Movie(R.drawable.placeholder_bg))
        }
        return movies
    }

    private fun setupView() {
        with(binding) {
            rvMainComponent.setupWith(Category("category movies", mockMovies())) {

            }
        }
    }

    private fun setRecycler() {}
}