package com.alex.carexpenses.database

import androidx.lifecycle.LiveData
import com.alex.carexpenses.model.Expense

interface Repository {

    val allExpenses: LiveData<List<Expense>>

    suspend fun insertExpense(expense: Expense, onSuccess:() -> Unit)
    suspend fun deleteExpense(expense: Expense, onSuccess:() -> Unit)

}