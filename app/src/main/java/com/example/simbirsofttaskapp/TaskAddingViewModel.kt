package com.example.simbirsofttaskapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simbirsofttaskapp.model.Task
import com.example.simbirsofttaskapp.model.Tasks
import com.example.simbirsofttaskapp.utils.DateUtils
import java.io.File
import java.time.LocalDateTime

class TaskAddingViewModel(application: Application): AndroidViewModel(application) {
    private val _name: MutableLiveData<String> = MutableLiveData("")
    val name: LiveData<String> = _name

    private val _description: MutableLiveData<String> = MutableLiveData("")
    val description: LiveData<String> = _description

    private val _dateStart: MutableLiveData<LocalDateTime> = MutableLiveData(LocalDateTime.now())
    val dateStart: LiveData<LocalDateTime> = _dateStart

    private val _dateFinish: MutableLiveData<LocalDateTime> = MutableLiveData(LocalDateTime.now().plusHours(1))
    val dateFinish: LiveData<LocalDateTime> = _dateFinish

    private val context = application.applicationContext
    private val _jsonToString: String =
        context.assets.open("tasks.json").bufferedReader().use { it.readText() }

    fun setName(name: String){
        _name.value = name
    }
    fun setDescription(description: String){
        _description.value = description
    }
    fun setDateStart(date: LocalDateTime){
        _dateStart.value = date
        _dateFinish.value = date.plusHours(1)
    }
    fun setDateFinish(date: LocalDateTime){
        _dateFinish.value = date
    }

    /*fun rewriteJson(){
        addTaskToTasks()

    }
    private fun addTaskToTasks(){
        val tasksFromJson: Tasks? = Tasks.fromJson(_jsonToString)
        val id = tasksFromJson!!.tasks.size + 1
        val dateStartTimespan = DateUtils().getDateInTimespan(_dateStart.value!!).toString()
        val dateFinishTimespan = DateUtils().getDateInTimespan(_dateFinish.value!!).toString()

        tasksFromJson.tasks.add(Task(id.toLong(), dateStartTimespan, dateFinishTimespan, _name.value!!, _description.value!!))
    }
    private fun writeToJson(string: String){
        context.assets.
    }*/
}