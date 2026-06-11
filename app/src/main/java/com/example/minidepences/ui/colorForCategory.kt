package com.example.minidepences.ui

import androidx.compose.ui.graphics.Color
import com.example.minidepences.data.ExpenseCategories

fun colorForCategory(category: String): Color =
    when (category) {
        ExpenseCategories.FOOD -> Color.Red
        ExpenseCategories.TRANSPORT -> Color.Magenta
        ExpenseCategories.LEISURE -> Color.Blue
        ExpenseCategories.HEALTH -> Color.Green
        else -> Color.Yellow
    }