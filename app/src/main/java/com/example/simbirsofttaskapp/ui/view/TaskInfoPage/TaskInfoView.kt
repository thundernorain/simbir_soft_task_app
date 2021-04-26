package com.example.simbirsofttaskapp.ui.view.TaskInfoPage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.simbirsofttaskapp.MainActivityViewModel
import com.example.simbirsofttaskapp.utils.DateUtils

@Composable
fun TaskInfoView(
    idTask: Long,
    navController: NavController,
    mainActivityViewModel: MainActivityViewModel = viewModel()
) {
    val task = mainActivityViewModel.getTaskById(idTask)
    val date = DateUtils().convertTimestampToDate(task!!.dateStart)
    val timeStart = DateUtils().convertTimestampToTime(task.dateStart)
    val timeFinish = DateUtils().convertTimestampToTime(task.dateFinish)

    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TaskPageBarView(onClick = { navController.navigateUp() })
        Text(
            task.name,
            Modifier.padding(bottom = 20.dp),
            style = TextStyle(fontSize = 20.sp, textAlign = TextAlign.Center)
        )
        Text(
            task.description,
            Modifier.padding(bottom = 20.dp),
            style = TextStyle(fontSize = 20.sp, textAlign = TextAlign.Center),
        )
        Text(
            "Запланировано на ${date}\nс ${timeStart} до ${timeFinish}",
            style = TextStyle(textAlign = TextAlign.Center)
        )
    }
}