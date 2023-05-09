package com.example.netflixremake.data.model

import androidx.annotation.DrawableRes
import com.example.netflixremake.R
import com.example.netflixremake.presentation.adapter.NetflixGenericAdapter.Companion.CATEGORY
import com.example.netflixremake.presentation.adapter.NetflixGenericAdapter.Companion.MOVIE

data class Movie(val coverUrl: Int) : AdaptableItem {
    override fun itemType() = MOVIE
}

data class Category(val name: String? = null, val movies: List<Movie>) : AdaptableItem {
    override fun itemType() = CATEGORY
}
