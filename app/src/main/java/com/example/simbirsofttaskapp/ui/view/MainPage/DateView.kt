package com.example.simbirsofttaskapp.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CalendarToday
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.simbirsofttaskapp.MainActivityViewModel
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.datetimepicker
import java.time.format.DateTimeFormatter

@Composable
fun DateView(mainActivityViewModel: MainActivityViewModel = viewModel()) {
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
                .clickable(onClick = { dialog.show() })
                .padding(15.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                imageVector = Icons.Rounded.CalendarToday,
                contentDescription = "Календарь",
                Modifier.padding(end = 8.dp)
            )
            Text(
                selectedDate.value?.format(DateTimeFormatter.ofPattern("dd.MM.yy")).toString(),
                style = TextStyle(fontSize = 20.sp)
            )
        }
        Divider()
    }
}