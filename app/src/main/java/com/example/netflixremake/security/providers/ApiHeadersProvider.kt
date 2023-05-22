package com.example.netflixremake.security.providers

import kotlinx.coroutines.runBlocking
import okhttp3.Headers
import okhttp3.Headers.Companion.toHeaders
import okhttp3.Request

class ApiHeadersProvider : ApiHeaders {

    override fun getHeaders(request: Request): Headers? {
        return runBlocking {
            try {
                mapOf(Pair(CONTENT_TYPE, JSON)).toHeaders()
            } catch (e: Throwable) {
                return@runBlocking null
            }
        }
    }

     companion object {
        private const val CONTENT_TYPE = "Content-Type"
         private const val JSON = "application/json"
    }
}