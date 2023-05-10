package com.example.netflixremake.extension

import org.koin.core.scope.Scope
import retrofit2.Retrofit

fun Scope.getRetrofit() = get<Retrofit>()