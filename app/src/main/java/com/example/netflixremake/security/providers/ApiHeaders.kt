package com.example.netflixremake.security.providers

import okhttp3.Headers
import okhttp3.Request

interface ApiHeaders {

    fun getHeaders(request: Request): Headers?
}