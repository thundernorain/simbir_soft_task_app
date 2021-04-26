package com.example.simbirsofttaskapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.simbirsofttaskapp.model.Task
import com.example.simbirsofttaskapp.model.Tasks
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneOffset

class MainActivityViewModel(application: Application): AndroidViewModel(application) {
    private val _date: MutableLiveData<LocalDateTime> = MutableLiveData(LocalDateTime.now())
    val date: LiveData<LocalDateTime> = _date

    private val context = application.applicationContext
    private val _jsonToString: String =
        context.assets.open("tasks.json").bufferedReader().use { it.readText() }

    private val _tasksFromJson: Tasks? = Tasks.fromJson(_jsonToString)
    private val _tasks: MutableLiveData<Tasks> = MutableLiveData()
    val tasks: LiveData<Tasks> = _tasks


    fun setDate(date: LocalDateTime){
        _date.value = date
        onDateChange()
    }
    fun onDateChange(){
        _tasks.value = getTasksByDate()
    }
    fun getTaskById(idTask: Long): Task?{
        _tasksFromJson!!.tasks.forEach { task ->
            if(task.id == idTask) return task
        }
        return null
    }
    private fun getTasksByDate() : Tasks{
        val taskList: ArrayList<Task> = arrayListOf()
        val dayStart = getDateInTimespan(_date.value!!.with(LocalTime.MIDNIGHT))
        val dayEnd = getDateInTimespan(_date.value!!.with(LocalTime.MAX))

        for (task in _tasksFromJson!!.tasks) {
            if(task.dateStart.toLong() <= dayEnd && task.dateFinish.toLong() >= dayStart)
                taskList.add(task)
        }
        return Tasks(taskList)
    }
    private fun getDateInTimespan(date: LocalDateTime): Long = date.atZone(ZoneOffset.UTC).toEpochSecond()
}