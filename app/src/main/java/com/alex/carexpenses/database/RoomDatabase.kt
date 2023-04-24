package com.alex.carexpenses.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alex.carexpenses.model.Expense


@Database(entities = [Expense::class], version = 1)
abstract class RoomDatabase: RoomDatabase() {

    abstract fun getRoomDao(): RoomDao

    companion object {


        @Volatile
        private var database: com.alex.carexpenses.database.RoomDatabase? = null

        @Synchronized
        fun getInstance(context: Context): com.alex.carexpenses.database.RoomDatabase{
            if (database == null){
                database = Room.databaseBuilder(
                    context,
                    com.alex.carexpenses.database.RoomDatabase::class.java,
                    "database"
                ).build()
                return database as com.alex.carexpenses.database.RoomDatabase
            }
            else return database as com.alex.carexpenses.database.RoomDatabase
        }
    }
}