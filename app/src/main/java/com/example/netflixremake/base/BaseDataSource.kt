package com.example.netflixremake.base

import com.example.netflixremake.data.model.BaseResponseModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow

abstract class BaseDataSource {

    protected fun <T> call(block: suspend FlowCollector<T>.() -> T): Flow<T> = flow {
        emit(block())
    }

    protected fun <T> callApi(block: suspend FlowCollector<T>.() -> BaseResponseModel<T>): Flow<T> =
        flow {
            emit(block().result)
        }
}