package com.example.minidepences.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
@Dao
interface ExpenseDao {
    @Insert
    suspend fun insertExpense(expense: Expense)
    @Delete
    suspend fun deleteExpense(expense: Expense)
    @Query("SELECT * FROM expenses ORDER BY createdAt DESC")
    fun getAllExpenses(): Flow<List<Expense>>
    @Query("SELECT COUNT(*) FROM expenses")
    fun countExpenses(): Flow<Int>
    @Query("SELECT SUM(amount) FROM expenses")
    fun getTotalAmount(): Flow<Double?>
    @Query("SELECT COUNT(*) FROM expenses WHERE category = :category")
    fun countByCategory(category: String): Flow<Int>

    @Query("SELECT SUM(amount) FROM expenses WHERE category = :category")
    fun getTotalByCategory(category: String): Flow<Double?>
}