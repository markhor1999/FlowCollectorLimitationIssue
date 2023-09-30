package com.codingwithsalman.flowcollectorlimitationissue.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow


object MainRepository {
    private val _flow = MutableSharedFlow<Int>()
    private var count = 1

    fun data(): Flow<Int> = _flow.asSharedFlow()

    suspend fun increase() {
        _flow.emit(++count)
    }
}