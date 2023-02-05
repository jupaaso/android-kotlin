package com.sampleandroidapp.mobicomp.data

import java.util.*

data class Reminder(
    val reminderId: Long,
    val reminderTitle: String,
    val reminderDate: Date?
)