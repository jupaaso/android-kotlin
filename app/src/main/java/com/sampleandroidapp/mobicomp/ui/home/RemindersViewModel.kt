package com.sampleandroidapp.mobicomp.ui.home

import androidx.lifecycle.ViewModel
import com.sampleandroidapp.mobicomp.data.Category
import com.sampleandroidapp.mobicomp.data.Reminder
import java.util.*

class RemindersViewModel : ViewModel() {        // Glues screen-what-we-see and data together

    init {
        val list = mutableListOf<Reminder>()
        for (x in 1 .. 5) {
            list.add(
                Reminder(
                    reminderId = x.toLong(),
                    reminderTitle = "$x reminder",
                    reminderDate = Date()
                )
            )
        }
    }
}

// Category is created for reminders "Time based reminder" and "Location based remindes"
data class ReminderViewState(
    val categories: List<Category> = emptyList(),
    val selectedCategory: Category? = null,

    val reminders: List<Reminder> = emptyList()
)