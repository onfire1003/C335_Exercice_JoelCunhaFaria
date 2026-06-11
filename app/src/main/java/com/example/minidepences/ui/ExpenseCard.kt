package com.example.minidepences.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.minidepences.data.Expense
import com.example.minidepences.data.ExpenseCategories

fun iconForCategory(category: String): String = when (category) {
    ExpenseCategories.FOOD -> "🍔"
    ExpenseCategories.TRANSPORT -> "🚌"
    ExpenseCategories.LEISURE -> "🎮"
    ExpenseCategories.HEALTH -> "💊"
    else -> "📦"
}

@Composable
fun ExpenseCard(
    expense: Expense,
    onDeleteClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = expense.name,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "%.2f CHF".format(expense.amount)
            )
            Text(
                text = "${iconForCategory(expense.category)} ${expense.category}"
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedButton(onClick = onDeleteClick) {
                Text("Supprimer")
            }
        }
    }
}
