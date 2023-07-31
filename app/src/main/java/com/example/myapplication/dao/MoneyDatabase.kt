package com.example.myapplication.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.bean.Money

@Database(entities = [Money::class], version = 1)
abstract class MoneyDatabase : RoomDatabase() {
    abstract fun getMoney(): MoneyDao
}