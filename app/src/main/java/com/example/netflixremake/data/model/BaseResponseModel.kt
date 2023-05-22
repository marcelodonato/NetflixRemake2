package com.example.netflixremake.data.model

import com.google.gson.annotations.SerializedName

data class BaseResponseModel<T>(
    @SerializedName("StartTime")
    val startTime: String? = null,

    @SerializedName("EndTime")
    val endTime: String? = null,

    @SerializedName("StatusTransacao")
    val transactionStatus: String? = null,

    @SerializedName("IdTransacao")
    val transactionId: Float? = null,

    @SerializedName("Result")
    val result: T
)
