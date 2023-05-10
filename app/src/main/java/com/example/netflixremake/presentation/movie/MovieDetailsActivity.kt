package com.example.netflixremake.presentation.movie

import android.content.Intent
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.netflixremake.R
import com.example.netflixremake.base.BaseActivity
import com.example.netflixremake.base.BaseViewModel
import com.example.netflixremake.data.model.MovieSimilar
import com.example.netflixremake.databinding.ActivityMovieDetailsBinding
import com.example.netflixremake.extension.viewBinding
import com.example.netflixremake.presentation.adapter.NetflixGenericAdapter
import com.example.netflixremake.presentation.home.view.HomeActivity

class MovieDetailsActivity : BaseActivity<BaseViewModel>() {

    override val binding by viewBinding(ActivityMovieDetailsBinding::inflate)

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
    private fun mockMovies(): List<MovieSimilar> {
        return listOf(
            MovieSimilar(R.drawable.movie_4),
            MovieSimilar(R.drawable.placeholder_bg),
            MovieSimilar(R.drawable.movie),
            MovieSimilar(R.drawable.placeholder_bg),
            MovieSimilar(R.drawable.placeholder_bg),
            MovieSimilar(R.drawable.movie_4),
            MovieSimilar(R.drawable.movie),
        )
    }

    private fun setupRecycler() {
        with(binding) {
            rvMovieSimilar.apply{
                val adapterMovies = NetflixGenericAdapter()
                adapterMovies.clickListener = {
                    setMainActivity()
                }
                layoutManager = GridLayoutManager(this@MovieDetailsActivity, 3)
                adapterMovies.items = mockMovies()
                adapter = adapterMovies

            }
        }
    }

    private fun setMainActivity(){
        val intent = Intent(this@MovieDetailsActivity, HomeActivity::class.java)
        startActivity(intent)
    }
}