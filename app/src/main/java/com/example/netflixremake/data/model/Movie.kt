package com.example.netflixremake.data.model

import com.example.netflixremake.presentation.adapter.NetflixGenericAdapter.Companion.CATEGORY
import com.example.netflixremake.presentation.adapter.NetflixGenericAdapter.Companion.MOVIE
import com.example.netflixremake.presentation.adapter.NetflixGenericAdapter.Companion.SIMILAR
import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("title") val name: String? = null,
    @SerializedName("movie") val movieList: List<Movie>? = null
) : AdaptableItem {
    override fun itemType() = CATEGORY
}

data class Movie(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("cover_url") val coverUrl: Int
) : AdaptableItem {
    override fun itemType() = MOVIE
}


data class MovieSimilar(val coverSimilarUrl: Int) : AdaptableItem {
    override fun itemType() = SIMILAR
}

data class MovieDetails(
    val coverMovie: Int? = null,
    val title: String? = null,
    val desc: String? = null,
    val cast: String? = null,
    val moviesSimilar: List<MovieSimilar>? = null,
)
