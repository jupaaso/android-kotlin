package com.sampleandroidapp.mobicomp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sampleandroidapp.mobicomp.Graph
import com.sampleandroidapp.mobicomp.data.Reminder
import com.sampleandroidapp.mobicomp.data.ReminderRepository
import com.sampleandroidapp.mobicomp.data.ReminderToCategory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RemindersViewModel(
    private val categoryId: Long,
    private val reminderRepository: ReminderRepository = Graph.reminderRepository
) : ViewModel() {
    private val _state = MutableStateFlow(RemindersViewState())

    val state: StateFlow<RemindersViewState>
        get() = _state

    init {
        viewModelScope.launch {
            reminderRepository.remindersInCategory(categoryId).collect { list ->
                _state.value = RemindersViewState(
                    reminders = list
                )
            }
        }
    }
}

data class RemindersViewState(
    val reminders: List<ReminderToCategory> = emptyList()
)