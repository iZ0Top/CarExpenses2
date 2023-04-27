package com.alex.carexpenses.screens.list

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alex.carexpenses.database.RoomDB
import com.alex.carexpenses.database.RoomRepository
import com.alex.carexpenses.model.Expense
import com.alex.carexpenses.utils.APP_ACTIVITY
import com.alex.carexpenses.utils.LOG_TAG
import com.alex.carexpenses.utils.REPOSITORY

class FragmentListViewModel(application: Application): AndroidViewModel(application) {
    init {
        val dao = RoomDB.getInstance(APP_ACTIVITY).getRoomDao()
        REPOSITORY = RoomRepository(dao)
        Log.d(LOG_TAG, "FragmentListViewModel. init")
    }

    var allExpenses = REPOSITORY.allExpenses
}