package com.example.netflixremake.presentation.home.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.netflixremake.base.BaseActivity
import com.example.netflixremake.data.model.Category
import com.example.netflixremake.databinding.ActivityMainBinding
import com.example.netflixremake.extension.viewBinding
import com.example.netflixremake.presentation.adapter.NetflixGenericAdapter
import com.example.netflixremake.presentation.home.viewmodel.HomeViewModel
import com.example.netflixremake.presentation.login.view.LoginActivity
import com.example.netflixremake.presentation.movie.view.MovieDetailsActivity
import kotlin.random.Random

class HomeActivity : BaseActivity<HomeViewModel>() {

    companion object {
        fun getStartIntent(context: Context) = Intent(context, HomeActivity::class.java)
    }

    override val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getCategories()
        setupView()
    }

    private fun setupObservable() = with(viewModel) {
        onCategoriesResult.observe(this@HomeActivity, ::onCategoriesResult)
        onLogoutResult.observe(this@HomeActivity, ::onLogoutResult)
    }

    private fun onCategoriesResult(categoriesList: Category?) {
        binding.load.visibility = View.GONE
        setupRecyclerView(categoriesList)
    }

    private fun setupView() {
        with(binding) {
            setupObservable()
            load.visibility = View.VISIBLE
            logout.setOnClickListener {
                viewModel.logoutUser()
            }
        }
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

    private fun onLogoutResult(result: Boolean) {
        if (result) {
            startActivity(LoginActivity.getStartIntent(this@HomeActivity))
        }
    }

    private fun setMovieDetails(id: String) {
        startActivity(MovieDetailsActivity.getStartIntent(this@HomeActivity).apply {
            this.putExtra("ID_MOVIE", id)
        })
    }
}