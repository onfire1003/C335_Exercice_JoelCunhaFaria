package com.example.minidepences.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.minidepences.data.CategoryStat

@Composable
fun CategoryBarChart(stats: List<CategoryStat>) {
    val maxTotal = stats.maxOfOrNull { it.total } ?: 0.0

    Column {
        Text(
            text = "Total par catégorie :",
            style = MaterialTheme.typography.headlineSmall
        )
        stats.forEach { stat ->
            val fraction = if (maxTotal > 0.0) {
                (stat.total / maxTotal).toFloat()
            } else {
                0f
            }
            Row(
                modifier = Modifier.fillMaxWidth()
            )
            {
                Text(
                    text = iconForCategory(stat.category) + stat.category,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "%.2f CHF".format(stat.total ?: 0.0),
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .background(Color.LightGray)
                        .weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(fraction)
                            .fillMaxHeight()
                            .background(colorForCategory(stat.category))
                    )
                }
            }
        }
    }
}