package com.codingwithsalman.flowcollectorlimitationissue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codingwithsalman.flowcollectorlimitationissue.ui.FirstScreen
import com.codingwithsalman.flowcollectorlimitationissue.ui.SecondScreen
import com.codingwithsalman.flowcollectorlimitationissue.ui.theme.FlowCollectorLimitationIssueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlowCollectorLimitationIssueTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "first"
                    ) {
                        composable("first") {
                            FirstScreen(navController = navController)
                        }

                        composable("second") {
                            SecondScreen()
                        }
                    }
                }
            }
        }
    }
}