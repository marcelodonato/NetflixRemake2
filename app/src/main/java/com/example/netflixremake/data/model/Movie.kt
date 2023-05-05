package com.example.netflixremake.data.model

import androidx.annotation.DrawableRes

data class Movie(@DrawableRes val coverUrl: Int )

data class Category(val name: String? = null, val movies: List<Movie>)
