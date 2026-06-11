package com.example.minidepences.data

object ExpenseCategories {
    const val ALL = "Toutes"
    const val FOOD = "Alimentation"
    const val TRANSPORT = "Transport"
    const val LEISURE = "Loisirs"
    const val HEALTH = "Santé"
    const val OTHER = "Autres"

    val filters = listOf(ALL, FOOD, TRANSPORT, LEISURE, HEALTH, OTHER)

    val inputCategories = listOf(FOOD, TRANSPORT, LEISURE, HEALTH, OTHER)
}
