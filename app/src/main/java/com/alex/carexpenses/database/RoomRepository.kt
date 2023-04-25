package com.alex.carexpenses.database

import androidx.lifecycle.LiveData
import com.alex.carexpenses.model.Expense

class RoomRepository(private val roomDao: RoomDao): Repository {

    override val allExpenses: LiveData<List<Expense>>
        get() = roomDao.getAllExpenses()
    override suspend fun insertExpense(expense: Expense, onSuccess: () -> Unit) {
        roomDao.insetExpense(expense)
        onSuccess()
    }
    override suspend fun deleteExpense(expense: Expense, onSuccess: () -> Unit) {
        roomDao.deleteExpense(expense)
        onSuccess()
    }
}