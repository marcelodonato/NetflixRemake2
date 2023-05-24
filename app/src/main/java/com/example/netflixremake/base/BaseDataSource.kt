package com.example.netflixremake.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow

abstract class BaseDataSource {

    protected fun <T> call(block: suspend FlowCollector<T>.() -> T): Flow<T> = flow {
        emit(block())
    }
}