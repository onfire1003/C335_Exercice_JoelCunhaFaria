package com.example.minidepences

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.example.minidepences.ui.ExpenseApp
import com.example.minidepences.ui.theme.MiniDepencesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiniDepencesTheme {
                Surface {
                    ExpenseApp()
                }
            }
        }
    }
}
