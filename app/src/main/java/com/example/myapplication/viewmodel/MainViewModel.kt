package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.base.BaseViewModel

class MainViewModel : BaseViewModel() {
    var moneyData = MutableLiveData<String>("")
    var timeData = MutableLiveData<String>("")
}
