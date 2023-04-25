package com.alex.carexpenses.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity (tableName = "expenses_table")
data class Expense(
    @PrimaryKey (autoGenerate = true)
    val id: Int = 0,
    val date: String = "",
    val name: String = "",
    val description: String = "",
    val partNumber: String = "",
    val type: Int = 0,
    val quantity: Int = 0,
    val prise: Double = 0.0
): Serializable
