package com.example.netflixremake.data.model

import androidx.annotation.DrawableRes
import com.example.netflixremake.R
import com.example.netflixremake.presentation.adapter.NetflixGenericAdapter.Companion.CATEGORY
import com.example.netflixremake.presentation.adapter.NetflixGenericAdapter.Companion.MOVIE
import com.example.netflixremake.presentation.adapter.NetflixGenericAdapter.Companion.SIMILAR

data class Movie(val coverUrl: Int) : AdaptableItem {
    override fun itemType() = MOVIE
}

data class MovieSimilar(val coverSimilarUrl: Int) : AdaptableItem {
    override fun itemType() = SIMILAR
}

data class Category(val name: String? = null, val movies: List<Movie>) : AdaptableItem {
    override fun itemType() = CATEGORY
}

data class MovieDetails(
    val coverMovie : Int? = null,
    val title: String? = null,
    val desc: String? = null,
    val cast: String? = null,
    val moviesSimilar : List<MovieSimilar>? = null,
)
