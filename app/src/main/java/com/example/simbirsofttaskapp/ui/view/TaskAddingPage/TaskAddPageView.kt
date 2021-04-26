package com.example.simbirsofttaskapp.ui.view.TaskAddingPage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.simbirsofttaskapp.TaskAddingViewModel
import com.example.simbirsofttaskapp.ui.view.TaskInfoPage.Bar
import com.example.simbirsofttaskapp.utils.DateUtils
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.datetimepicker
import com.vanpra.composematerialdialogs.datetime.timepicker.timepicker
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun TaskAddPage(
    taskAddingViewModel: TaskAddingViewModel = viewModel(),
    navController: NavController
) {
    val name = taskAddingViewModel.name.observeAsState()
    val description = taskAddingViewModel.description.observeAsState()
    val dateStart = taskAddingViewModel.dateStart.observeAsState()
    val dateFinish = taskAddingViewModel.dateFinish.observeAsState()

    val date = dateStart.value?.format(DateTimeFormatter.ofPattern("dd.MM.yy")).toString()
    val timeStart = dateStart.value?.format(DateTimeFormatter.ofPattern("HH:mm")).toString()
    val timeFinish = dateFinish.value?.format(DateTimeFormatter.ofPattern("HH:mm")).toString()


    val maxDescriptionLength = 100
    val focusManager = LocalFocusManager.current

    val dialogDateStart = MaterialDialog()
    dialogDateStart.build {
        datetimepicker { date ->
            taskAddingViewModel.setDateStart(date)
        }
    }

    val dialogDateFinish = MaterialDialog()
    dialogDateFinish.build {
        datetimepicker{ date ->
            val newDate = dateStart.value!!.with(LocalTime.of(date.hour, date.minute))
            taskAddingViewModel.setDateFinish(newDate)
        }
    }

    Column(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Bar(label = "Добавление дела", onClick = { navController.navigateUp() })
        OutlinedTextField(
            value = name.value!!,
            onValueChange = { taskAddingViewModel.setName(it) },
            label = { Text("Название дела") },
            singleLine = true,
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() })
        )
        OutlinedTextField(
            value = description.value!!,
            onValueChange = {
                if (it.length <= maxDescriptionLength)
                    taskAddingViewModel.setDescription(it)
            },
            label = { Text("Описание дела") },
            singleLine = true,
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() })
        )
        Spacer(Modifier.padding(top = 15.dp))
        Text(
            "Запланировано на ${date}\nс ${timeStart} до ${timeFinish}",
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.padding(top = 15.dp))
        TextButton(onClick = { dialogDateStart.show() }) {
            Text("Выбрать дату и начальное время")
        }
        Spacer(Modifier.padding(top = 15.dp))
        TextButton(onClick = { dialogDateFinish.show() }) {
            Text("Выбрать дату и конечное время")
        }
        Spacer(Modifier.padding(top = 80.dp))
        Button(onClick = { }) {
            Text("Добавить дело")
        }
    }
}