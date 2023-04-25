package com.alex.carexpenses.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alex.carexpenses.model.Expense


@Database(entities = [Expense::class], version = 1)
abstract class RoomDB: RoomDatabase() {

    abstract fun getRoomDao(): RoomDao

    companion object {

        @Volatile
        private var database: RoomDB? = null

        @Synchronized
        fun getInstance(context: Context): RoomDB{
            return if (database == null){
                database = Room.databaseBuilder(context, RoomDB::class.java,"database").build()
                database as RoomDB
            } else database as RoomDB
        }
    }
}