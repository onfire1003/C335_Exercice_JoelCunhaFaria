package com.example.minidepences.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun ExpenseApp() {
    var currentScreen by remember { mutableStateOf("list") }
    when (currentScreen) {
        "list" -> {
            ExpenseListScreen(
                onAddClick = {
                    currentScreen = "add"
                },
                onStatsClick = {
                    currentScreen = "stats"
                }
            )
        }
        "add" -> {
            AddExpenseScreen(
                onBack = {
                    currentScreen = "list"
                }
            )
        }
        "stats" -> {
            StatisticsScreen(
                onBack = {
                    currentScreen = "list"
                }
            )
        }
    }
}
