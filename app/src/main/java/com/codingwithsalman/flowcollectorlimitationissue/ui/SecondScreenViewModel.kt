package com.codingwithsalman.flowcollectorlimitationissue.ui

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithsalman.flowcollectorlimitationissue.repository.MainRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SecondScreenViewModel : ViewModel() {
    private val repository = MainRepository
    private val _count = MutableStateFlow(0)
    val count = _count.asStateFlow()

    init {
        viewModelScope.launch {
            repository.data().collect { value ->
                Log.d(TAG, "SecondScreenViewModel: value = $value")
                _count.value = value
            }
        }
    }

    fun increase() {
        viewModelScope.launch {
            repository.increase()
        }
    }
}