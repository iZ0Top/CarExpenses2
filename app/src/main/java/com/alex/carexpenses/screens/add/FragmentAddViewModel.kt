package com.alex.carexpenses.screens.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.alex.carexpenses.model.Expense
import com.alex.carexpenses.utils.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FragmentAddViewModel(application: Application): AndroidViewModel(application) {

    fun insertExpense(expense: Expense, onSuccess:() -> Unit) {
        viewModelScope.launch(Dispatchers.IO){
            REPOSITORY.insertExpense(expense) {
                viewModelScope.launch(Dispatchers.Main){
                    onSuccess()
                }
            }
        }
    }
}