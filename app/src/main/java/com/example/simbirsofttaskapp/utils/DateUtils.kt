package com.example.simbirsofttaskapp.utils

import java.text.SimpleDateFormat

class DateUtils {
    fun convertTimestampToTime(time: String): String {
        val time = getDateObj(time)

        return SimpleDateFormat("HH:mm").format(time)
    }
    fun convertTimestampToDate(time: String): String {
        val time = getDateObj(time)

        return SimpleDateFormat("dd.MM.yy").format(time)
    }
    private fun getDateObj(time: String) = java.util.Date(time.toLong() * 1000)
}