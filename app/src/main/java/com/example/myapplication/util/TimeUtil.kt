package com.example.myapplication.util

object TimeUtil {

    fun getTime(time: Int): String? {

        var day = time / (60 * 60 * 24)
        var hour = (time % (60 * 60 * 24)) / (60 * 60)
        var second = time % (60 * 60) / 60
        var mill = time % 60

        if (day > 0) {
            return "$day 天" + "$hour 时" + "$second 分" + "$mill 秒"
        } else {
            if (hour > 0) {
                return "$hour 时" + "$second 分" + "$mill 秒"
            } else {
                if (second > 0) {
                    return "$second 分" + "$mill 秒"
                } else {
                    if (mill > 0) {
                        return "$mill 秒"
                    }
                }

            }
        }
        return null

    }
}