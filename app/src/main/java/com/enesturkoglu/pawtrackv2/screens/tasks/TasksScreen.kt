package com.enesturkoglu.pawtrackv2.screens.tasks

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.enesturkoglu.pawtrackv2.data.model.TaskEntity
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(viewModel: TaskScreenViewModel) {
    var selectedTask by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val taskOptions = listOf("Su iç", "Egzersiz yap", "İlaç al", "Toplantı")

    var reminderMinutes by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Görev Seç", style = MaterialTheme.typography.titleLarge)

        Spacer(Modifier.height(8.dp))

        // Görev Dropdown (Spinner)
        Box {
            OutlinedTextField(
                value = selectedTask,
                onValueChange = { selectedTask = it },
                readOnly = true,
                label = { Text("Görev seç") },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = "Dropdown Arrow",
                        modifier = Modifier.clickable { expanded = !expanded }
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                taskOptions.forEach { task ->
                    DropdownMenuItem(
                        text = { Text(task) },
                        onClick = {
                            selectedTask = task
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        // Hatırlatma süresi
        OutlinedTextField(
            value = reminderMinutes,
            onValueChange = { reminderMinutes = it.filter { c -> c.isDigit() } },
            label = { Text("Kaç dakika önce hatırlatılsın?") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(24.dp))

        // Kaydet butonu
        Button(
            onClick = {
                viewModel.addTask(TaskEntity(petId = 1, taskName = selectedTask, taskDate = reminderMinutes, timestamp = 5 ))
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Kaydet")
        }
    }
}