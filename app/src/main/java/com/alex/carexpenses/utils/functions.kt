package com.alex.carexpenses.utils

import android.widget.Toast


fun showToast(text: String){

    Toast.makeText(APP_ACTIVITY, text, Toast.LENGTH_LONG).show()
}