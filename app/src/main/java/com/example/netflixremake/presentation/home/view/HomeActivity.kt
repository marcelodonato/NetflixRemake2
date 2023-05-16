package com.example.netflixremake.presentation.home.view

import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.example.netflixremake.base.BaseActivity
import com.example.netflixremake.data.model.Category
import com.example.netflixremake.databinding.ActivityMainBinding
import com.example.netflixremake.di.NetflixInitializer
import com.example.netflixremake.extension.viewBinding
import com.example.netflixremake.presentation.adapter.NetflixGenericAdapter
import com.example.netflixremake.presentation.home.viewmodel.HomeViewModel
import com.example.netflixremake.presentation.movie.view.MovieDetailsActivity
import kotlin.random.Random

class HomeActivity : BaseActivity<HomeViewModel>() {

    override val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getCategories()
        setupView()
    }

    private fun setupObservable() = with(viewModel) {
        onCategoriesResult.observe(this@HomeActivity, ::onCategoriesResult)
    }

    private fun onCategoriesResult(categoriesList: Category?) {
        binding.load.visibility = View.GONE
        setupRecyclerView(categoriesList)
    }

    private fun setupView() {
        binding.load.visibility = View.VISIBLE
        setupObservable()
    }

    private fun randomIndex(): String {

        return Random.nextInt(1, 4).toString()
    }

    private fun setupRecyclerView(categories: Category?) {
        with(binding) {
            val mainAdapter = NetflixGenericAdapter()
            mainAdapter.clickListener = {
                setMovieDetails(randomIndex())
            }
            mainAdapter.items = categories?.category.orEmpty()
            rvMain.adapter = mainAdapter

        }
    }

    private fun setMovieDetails(id: String) {
        val intent = Intent(this@HomeActivity, MovieDetailsActivity::class.java).apply {
            this.putExtra("ID_MOVIE", id)
        }
        startActivity(intent)
    }
}