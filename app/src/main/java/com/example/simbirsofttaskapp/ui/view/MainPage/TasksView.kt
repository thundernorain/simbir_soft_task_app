package com.example.simbirsofttaskapp.ui.view.MainPage

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.simbirsofttaskapp.MainActivityViewModel
import com.example.simbirsofttaskapp.utils.DateUtils

@Composable
fun TasksView(
    navController: NavController,
    mainActivityViewModel: MainActivityViewModel = viewModel()
    ){
    val tasks = mainActivityViewModel.tasks.observeAsState()

    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(10.dp),horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item{ Text("Дела на день:", Modifier.padding(bottom = 8.dp)) }
        item{
            tasks.value?.tasks?.forEach { task ->
                TaskCardView(
                    name = task.name,
                    startTime = DateUtils().convertTimestampToTime(task.dateStart),
                    endTime = DateUtils().convertTimestampToTime(task.dateFinish,),
                    onClick = { navController.navigate("taskInfo/${task.id}") }
                )
            }
        }
    }
}