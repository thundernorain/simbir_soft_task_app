package com.example.simbirsofttaskapp.model

import com.beust.klaxon.Json
import com.beust.klaxon.Klaxon

// To parse the JSON, install Klaxon and do:
//
//   val tasks = Tasks.fromJson(jsonString)

private val klaxon = Klaxon()

data class Tasks (
    val tasks: ArrayList<Task>
) {
    fun toJson() = klaxon.toJsonString(this)

    companion object {
        fun fromJson(json: String) = klaxon.parse<Tasks>(json)
    }
}

data class Task (
    val id: Long,

    @Json(name = "date_start")
    val dateStart: String,

    @Json(name = "date_finish")
    val dateFinish: String,

    val name: String,
    val description: String
)