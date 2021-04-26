package com.example.simbirsofttaskapp.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.PlusOne
import androidx.compose.material.icons.rounded.CalendarToday
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.simbirsofttaskapp.MainActivityViewModel
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.datetimepicker
import java.time.format.DateTimeFormatter

@Composable
fun DateView(
    mainActivityViewModel: MainActivityViewModel = viewModel(),
    navController: NavController
) {
    val selectedDate = mainActivityViewModel.date.observeAsState()

    val dialog = MaterialDialog()
    dialog.build {
        datetimepicker { date ->
            mainActivityViewModel.setDate(date)
        }
    }

    Column() {
        Row(
            Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Spacer(Modifier.padding(end = 100.dp))
            IconButton(onClick = { dialog.show() }) {
                Icon(
                    imageVector = Icons.Rounded.CalendarToday,
                    contentDescription = "Календарь",
                )
            }
            Text(
                selectedDate.value?.format(DateTimeFormatter.ofPattern("dd.MM.yy")).toString(),
                style = TextStyle(fontSize = 20.sp)
            )
            Spacer(Modifier.padding(end = 80.dp))
            IconButton(onClick = { navController.navigate("taskAddPage") }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
        Divider()
    }
}