package com.codingwithsalman.flowcollectorlimitationissue.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun FirstScreen(
    viewModel: FirstScreenViewModel = viewModel(),
    navController: NavController
) {
    val count by viewModel.count.collectAsStateWithLifecycle()
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "FirstScreen ===> $count",
            style = MaterialTheme.typography.titleLarge
        )

        Button(onClick = {
            viewModel.increase()
        }) {
            Text(text = "Increase")
        }

        Button(onClick = {
            navController.navigate("second")
        }) {
            Text(text = "Navigate To Second")
        }
    }
}