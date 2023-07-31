package com.example.myapplication.bean

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Money(
    @PrimaryKey(autoGenerate = true)
    var number: Long = 0,
    var money: String
)
