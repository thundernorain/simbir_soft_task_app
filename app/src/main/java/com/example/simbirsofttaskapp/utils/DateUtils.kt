package com.example.simbirsofttaskapp.utils

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.ZoneOffset

class DateUtils {
    fun convertTimestampToTime(time: String): String {
        val date = getDateObj(time)

        return SimpleDateFormat("HH:mm").format(date)
    }
    fun convertTimestampToDate(time: String): String {
        val date = getDateObj(time)

        return SimpleDateFormat("dd.MM.yy").format(date)
    }

    fun getDateInTimespan(date: LocalDateTime): Long = date.atZone(ZoneOffset.UTC).toEpochSecond()

    private fun getDateObj(time: String) = java.util.Date(time.toLong() * 1000)
}