package com.example.netflixremake.data.model

import com.example.netflixremake.presentation.adapter.NetflixGenericAdapter.Companion.CATEGORY
import com.example.netflixremake.presentation.adapter.NetflixGenericAdapter.Companion.MOVIE
import com.example.netflixremake.presentation.adapter.NetflixGenericAdapter.Companion.SIMILAR
import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("category") val category: List<CategoryItem>? = null,
)

data class CategoryItem(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("title") val name: String? = null,
    @SerializedName("movie") val movieList: List<Movie>? = null
) : AdaptableItem {


    override fun itemType() = CATEGORY
}

data class Movie(
    @SerializedName("id") val id: Int = 0,
    @SerializedName("cover_url") val coverUrl: Int
) : AdaptableItem {
    override fun itemType() = MOVIE
}

data class MovieSimilar(val coverSimilarUrl: Int) : AdaptableItem {
    override fun itemType() = SIMILAR
}

data class MovieDetails(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("desc") val desc: String? = null,
    @SerializedName("cast") val cast: String? = null,
    @SerializedName("cover_url") val coverMovie: Int? = null,
    @SerializedName("movie") val moviesSimilar: List<MovieSimilar>? = null,
)
