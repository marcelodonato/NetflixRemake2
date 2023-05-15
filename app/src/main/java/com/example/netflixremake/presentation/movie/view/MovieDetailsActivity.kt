package com.example.netflixremake.presentation.movie.view

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.netflixremake.R
import com.example.netflixremake.base.BaseActivity
import com.example.netflixremake.data.model.MovieDetails
import com.example.netflixremake.data.model.MovieSimilar
import com.example.netflixremake.databinding.ActivityMovieDetailsBinding
import com.example.netflixremake.extension.viewBinding
import com.example.netflixremake.presentation.adapter.NetflixGenericAdapter
import com.example.netflixremake.presentation.movie.viewModel.MovieDetailsViewModel
import com.squareup.picasso.Picasso

class MovieDetailsActivity : BaseActivity<MovieDetailsViewModel>() {

    override val binding by viewBinding(ActivityMovieDetailsBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
        val extra = intent.extras

        if (extra != null) {
            val id = extra.getString("ID_MOVIE")
            viewModel.getMovieDetails(id)
        }
    }

    private fun setupView() {
        setupObservable()
        setSupportActionBar(binding.toolbarMovieDetails)
        supportActionBar?.title = null
        supportActionBar?.setHomeAsUpIndicator(R.drawable.arrow_back)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupObservable() = with(viewModel) {
        onDetailsResult.observe(this@MovieDetailsActivity, ::onMovieDetailsResult)
    }

    private fun onMovieDetailsResult(movieDetails: MovieDetails?) {
        movieDetails.let {
            setupRecycler(it?.moviesSimilar.orEmpty())
            with(binding) {
                Picasso.get().load(it?.coverMovie).placeholder(R.drawable.placeholder_bg)
                    .error(R.drawable.placeholder_bg).into(movieImg)
                tvTitleMovie.text = it?.title
                tvMovieDescription.text = it?.desc
                tvMovieCast.text = it?.cast
            }
        }
    }

    private fun setupRecycler(moviesSimilar: List<MovieSimilar>) {
        with(binding) {
            rvMovieSimilar.apply {
                val adapterMovies = NetflixGenericAdapter()
                layoutManager = GridLayoutManager(this@MovieDetailsActivity, 3)
                adapterMovies.items = moviesSimilar
                adapter = adapterMovies

            }
        }
    }
}