package com.sampleandroidapp.mobicomp.ui.reminder

import android.provider.CalendarContract.Reminders
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sampleandroidapp.mobicomp.Graph
import com.sampleandroidapp.mobicomp.data.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ReminderViewModel(
    private val reminderRepository: ReminderRepository = Graph.reminderRepository,
    private val categoryRepository: CategoryRepository = Graph.categoryRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(ReminderViewState())

    val state: StateFlow<ReminderViewState>
        get() = _state

    suspend fun saveReminder(reminder: Reminder): Long {
        return reminderRepository.addReminder(reminder)
    }

    init {
        viewModelScope.launch {
            categoryRepository.categories().collect { list ->
                _state.value = ReminderViewState(
                    categories = list
                )
            }
        }
    }
}

data class ReminderViewState(
    val categories: List<Category> = emptyList()
)