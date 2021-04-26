package com.example.simbirsofttaskapp.ui.view.MainPage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TaskCardView(
    name: String,
    startTime: String,
    endTime: String,
    onClick: () -> Unit
){
    Card(
        Modifier.padding(4.dp)
            .clickable(onClick = { onClick() })
        ,
        backgroundColor = MaterialTheme.colors.primary
    ){
        Row(
            Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                name,
                style = TextStyle(fontSize = 20.sp, color = Color.Black)
            )
            Text("$startTime - $endTime", style = TextStyle(color = Color.Black))
        }
    }
}
