package com.example.simbirsofttaskapp

import android.os.Bundle
import android.provider.ContactsContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.simbirsofttaskapp.ui.theme.SimbirSoftTaskAppTheme
import com.example.simbirsofttaskapp.ui.view.DateView
import com.example.simbirsofttaskapp.ui.view.MainPage.TasksView
import com.example.simbirsofttaskapp.ui.view.TaskInfoPage.TaskInfoView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimbirSoftTaskAppTheme {
                val navController = rememberNavController()

                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    NavHost(navController = navController, startDestination = "mainView") {
                        composable("mainView") { MainView(navController) }
                        composable(
                            "taskInfo/{idTask}",
                            arguments = listOf(navArgument("idTask") { type = NavType.LongType })
                        ) { backStackEntry ->
                            TaskInfoView(
                                idTask = backStackEntry.arguments?.getLong("idTask")!!,
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MainView(
    navController: NavController
) {
    Column {
        DateView()
        TasksView(navController)
    }
}