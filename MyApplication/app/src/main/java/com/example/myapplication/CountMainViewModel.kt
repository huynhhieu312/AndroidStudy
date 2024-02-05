package com.example.myapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountMainViewModel: ViewModel() {
    private val _count = MutableLiveData(0)
    val count: LiveData<Int> = _count

    fun onCountChanged(newCount: Int){
        Log.d(" new Count ", newCount.toString())
        _count.value = _count.value?.plus(newCount)
    }
}