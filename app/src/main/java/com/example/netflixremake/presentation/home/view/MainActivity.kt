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
    with(binding) {
        rvMainComponent.setupWith(Category("Nome da categoria",mockMovies())) {

        }
    }
}
}