package com.alex.carexpenses.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "expense")
data class Expense(
    @PrimaryKey (autoGenerate = true)
    val id: Int,
    val date: String,
    val name: String,
    val description: String,
    val partNumber: String,
    val type: Int,
    val quantity: Int,
    val prise: Double
)