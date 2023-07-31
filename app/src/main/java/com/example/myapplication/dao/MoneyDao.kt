package com.example.myapplication.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.bean.Money

@Dao
interface MoneyDao {
    @Query("select * from Money ")
    fun query():MutableList<Money>

    @Insert
    fun add(money: Money)
}