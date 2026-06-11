package com.example.minidepences.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.example.minidepences.data.CategoryStat

@Composable
fun CategoryDonutChart(stats: List<CategoryStat>) {
    val total = stats.sumOf { it.total }

    Column() {
        Text(
            text = "Répartition :",
            style = MaterialTheme.typography.headlineSmall
        )
        if (total == 0.0) {
            Text("Aucune donnée à afficher.")
            return
        }
        Spacer(modifier = Modifier.height(8.dp))
        Canvas(
            modifier = Modifier.size(160.dp)
        ) {
            var startAngle = -90f

            stats.forEach { stat ->
                val sweepAngle = ((stat.total / total) * 360.0).toFloat()

                drawArc(
                    color = colorForCategory(stat.category),
                    startAngle = startAngle,
                    sweepAngle = sweepAngle,
                    useCenter = false,
                    style = Stroke(width = 40f)
                )

                startAngle += sweepAngle
            }
        }
    }
}