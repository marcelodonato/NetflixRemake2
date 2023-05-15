package com.example.netflixremake.presentation.home.view

import android.content.Intent
import android.os.Bundle
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
        NetflixInitializer.init()
        viewModel.getCategories()
        setupView()
    }

    private fun setupObservable() = with(viewModel) {
        onCategoriesResult.observe(this@HomeActivity, ::onCategoriesResult)
    }

    private fun onCategoriesResult(categoriesList: Category?) {
        setupRecyclerView(categoriesList)
    }

    private fun setupView() {
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