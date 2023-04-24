package com.alex.carexpenses.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alex.carexpenses.model.Expense


@Dao
interface RoomDao {

    @Query("SELECT * FROM expenses_table")
    fun getAllExpenses(): LiveData<List<Expense>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insetExpense(expense: Expense)

    @Delete
    suspend fun deleteExpense(expense: Expense)

}