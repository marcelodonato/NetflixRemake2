package com.example.netflixremake.presentation.home.view

import android.content.Intent
import android.os.Bundle
import com.example.netflixremake.R
import com.example.netflixremake.base.BaseActivity
import com.example.netflixremake.base.BaseViewModel
import com.example.netflixremake.data.model.Category
import com.example.netflixremake.data.model.Movie
import com.example.netflixremake.databinding.ActivityMainBinding
import com.example.netflixremake.extension.viewBinding
import com.example.netflixremake.presentation.adapter.NetflixGenericAdapter
import com.example.netflixremake.presentation.movie.MovieDetailsActivity

class MainActivity : BaseActivity<BaseViewModel>() {
    override val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
    }

    private fun mockCategories(): List<Category> {
        return listOf(
            Category("Nome da categoria1", mockMovies()),
            Category("Nome da categoria2", mockMovies()),
            Category("Nome da categoria3", mockMovies()),
            Category("Nome da categoria4", mockMovies()),
            Category("Nome da categoria4", mockMovies()),
            Category("Nome da categoria4", mockMovies()),
        )
    }

    private fun mockMovies(): List<Movie> {
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

    private fun setupView() {
        setupRecyclerView(mockCategories())
    }

    private fun setupRecyclerView(categories: List<Category>) {
        with(binding) {
            val mainAdapter = NetflixGenericAdapter()
            mainAdapter.clickListener = {
                setMovieDetails()
            }
            mainAdapter.items = categories
            rvMain.adapter = mainAdapter

        }
    }

    private fun setMovieDetails(){
        val intent = Intent(this@MainActivity, MovieDetailsActivity::class.java)
        startActivity(intent)
    }
}