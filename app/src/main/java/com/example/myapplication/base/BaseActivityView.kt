package com.example.myapplication.base

import androidx.viewbinding.ViewBinding

interface BaseActivityView<BV : ViewBinding> {
    fun onCreate()

    fun destroy()

    fun getViewBinding(): BV

}
