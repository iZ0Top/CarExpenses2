package com.alex.carexpenses.utils

import com.alex.carexpenses.MainActivity
import com.alex.carexpenses.database.Repository
import kotlin.properties.Delegates


lateinit var APP_ACTIVITY: MainActivity
lateinit var REPOSITORY: Repository

var maxOdometer = 0

const val LOG_TAG = "tag"