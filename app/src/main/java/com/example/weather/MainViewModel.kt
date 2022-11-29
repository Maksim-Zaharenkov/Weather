package com.example.wheather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wheather.data.DataItem

class MainViewModel: ViewModel() {

    val liveDataCurrent = MutableLiveData<DataItem>()
    val liveDataList = MutableLiveData<List<DataItem>>()
}