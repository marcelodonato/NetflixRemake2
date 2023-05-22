package com.example.netflixremake.security.extensions

import com.example.netflixremake.security.data.SecurityConstants.DEFAULT_ERROR_CODE
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody

fun Request.buildResponseError(e: Throwable): Response = Response.Builder()
    .request(this)
    .protocol(Protocol.HTTP_1_1)
    .code(DEFAULT_ERROR_CODE)
    .message(e.stackTraceToString())
    .body(ResponseBody.create(null, "$e"))
    .build()


fun Request.urlToString(): String = url.toString()