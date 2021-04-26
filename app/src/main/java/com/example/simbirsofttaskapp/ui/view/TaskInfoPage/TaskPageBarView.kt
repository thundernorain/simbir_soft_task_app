package com.example.simbirsofttaskapp.ui.view.TaskInfoPage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TaskPageBarView(
    onClick: () -> Unit
){
    Column(
        Modifier.padding(bottom = 20.dp)
            .clickable(onClick = onClick)
    ) {
        Row(
            Modifier.padding(20.dp)
        ){
            Icon(Icons.Default.ArrowBack, "Back")
            Text(
                "Описание дела",
                style = TextStyle(fontSize = 18.sp),
                modifier = Modifier.padding(start = 20.dp)
            )
        }
        Divider()
    }
}