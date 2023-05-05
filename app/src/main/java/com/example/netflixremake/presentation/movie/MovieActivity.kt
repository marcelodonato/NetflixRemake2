package com.example.netflixremake.presentation.movie

import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.netflixremake.R
import com.example.netflixremake.base.BaseActivity
import com.example.netflixremake.base.BaseViewModel
import com.example.netflixremake.data.model.Movie
import com.example.netflixremake.databinding.ActivityMovieBinding
import com.example.netflixremake.extension.viewBinding

class MovieActivity : BaseActivity<BaseViewModel>() {

    override val binding by viewBinding(ActivityMovieBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupToolbar()
        setupView()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbarMovieDetails)
        supportActionBar?.title = null
        supportActionBar?.setHomeAsUpIndicator(R.drawable.arrow_back)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupView() {
        setupRecycler()
        val layerDrawable: LayerDrawable =
            ContextCompat.getDrawable(this, R.drawable.shadows) as LayerDrawable
        val movieCover = ContextCompat.getDrawable(this, R.drawable.movie_4)
        layerDrawable.setDrawableByLayerId(R.id.coverDrawable, movieCover)

        with(binding) {
            movieImg.setImageDrawable(layerDrawable)

            tvTitleMovie.text = "batman begins"
            tvMovieDescription.text = "this is the movie description"
            tvMovieCast.text = getString(R.string.cast, "actor A, actor B, actress A, actress B")
        }
    }

    private fun mockMovies(): List<Movie> {
        val movies = mutableListOf<Movie>()
        for (i in 0 until 15) {
            val movie = Movie(R.drawable.movie)
            movies.add(movie)
        }
        return movies
    }

    private fun setupRecycler() {
        binding.rvMovieSimilar.layoutManager = GridLayoutManager(this, 3)
        binding.rvMovieSimilar.adapter = MovieSimilarAdapter(mockMovies())
    }
}