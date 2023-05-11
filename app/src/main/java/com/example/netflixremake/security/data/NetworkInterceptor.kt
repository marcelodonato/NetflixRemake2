package com.example.netflixremake.security.data

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.example.netflixremake.security.extensions.buildResponseError
import com.example.netflixremake.security.providers.ApiHeaders
import java.io.IOException
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class NetworkInterceptor : Interceptor, KoinComponent {

    private val headersProvider: ApiHeaders by inject()
    private val idleAPI: MutableLiveData<Boolean> by inject()

    @SuppressLint("HardwareIds")
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.request().run {
            try {
                val headers = getHeaders(this) ?: return buildResponseError(Throwable())
                newBuilder().headers(headers).build().let {
                    idleAPI.postValue(true)
                    val returnValue = chain.proceed(it)
                    idleAPI.postValue(false)
                    returnValue
                }

            } catch (ioe: IOException) {
                idleAPI.postValue(false)
                buildResponseError(ioe)
            }
        }
    }

    private fun getHeaders(request: Request) = headersProvider.getHeaders(request)
}