package com.sampleandroidapp.mobicomp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sampleandroidapp.mobicomp.data.Category
import com.sampleandroidapp.mobicomp.data.Reminder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*

class RemindersViewModel : ViewModel() {        // Glues screen-what-we-see and data together

    private val _state = MutableStateFlow(RemindersViewState())

    val state: StateFlow<RemindersViewState>
        get() = _state

    // Initial list of values, adds and creates 5pcs Reminders into list
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
        viewModelScope.launch {
            _state.value = RemindersViewState(
                reminders = list
            )
        }
    }
}

// Category is created for reminders "Time based reminder" and "Location based remindes"
data class RemindersViewState(
    //val categories: List<Category> = emptyList(),
    //val selectedCategory: Category? = null,

    val reminders: List<Reminder> = emptyList()
)