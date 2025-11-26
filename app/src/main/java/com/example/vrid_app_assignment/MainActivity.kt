package com.example.vrid_app_assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.vrid_app_assignment.ui.BlogDetailScreen
import com.example.vrid_app_assignment.ui.BlogListScreen
import com.example.vrid_app_assignment.ui.theme.Vrid_app_assignmentTheme
import com.example.vrid_app_assignment.viewmodel.BlogViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Vrid_app_assignmentTheme {
                val navController = rememberNavController()
                val blogViewModel: BlogViewModel = viewModel()

                var showExitDialog by remember { mutableStateOf(false) }

                val backStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = backStackEntry?.destination?.route

                if (currentRoute == "blog_list") {
                    BackHandler(enabled = true) {
                        showExitDialog = true
                    }
                }

                if (showExitDialog) {
                    AlertDialog(
                        onDismissRequest = { showExitDialog = false },
                        title = { Text("Exit App") },
                        text = { Text("Are you sure you want to exit?") },
                        confirmButton = {
                            TextButton(onClick = {
                                finish()
                            }) {
                                Text("Yes")
                            }
                        },
                        dismissButton = {
                            TextButton(onClick = {
                                showExitDialog = false
                            }) {
                                Text("No")
                            }
                        }
                    )
                }

                NavHost(navController = navController, startDestination = "blog_list") {
                    composable("blog_list") {
                        BlogListScreen(navController = navController, blogViewModel = blogViewModel)
                    }
                    composable(
                        "blog_detail/{blogUrl}",
                        arguments = listOf(navArgument("blogUrl") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val blogUrl = backStackEntry.arguments?.getString("blogUrl") ?: ""
                        BlogDetailScreen(blogUrl)
                    }
                }
            }
        }
    }
}