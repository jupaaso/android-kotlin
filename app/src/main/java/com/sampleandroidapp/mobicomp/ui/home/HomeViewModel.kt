package com.sampleandroidapp.mobicomp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sampleandroidapp.mobicomp.Graph
import com.sampleandroidapp.mobicomp.data.Category
import com.sampleandroidapp.mobicomp.data.CategoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

/** Example for this is "HomeViewModel.kt" */

class HomeViewModel(
    private val categoryRepository: CategoryRepository = Graph.categoryRepository
) : ViewModel() {        // Glues screen-what-we-see and data together

    private val _state = MutableStateFlow(HomeViewState())
    private val _selectedCategory = MutableStateFlow<Category?>(null)

    val state: StateFlow<HomeViewState>
        get() = _state

    fun onCategorySelected(category: Category) {
        _selectedCategory.value = category
    }
    // Initial list of values
    init {
        viewModelScope.launch {

            combine(
                categoryRepository.categories().onEach { list ->
                    if (list.isNotEmpty() && _selectedCategory.value == null) {
                        _selectedCategory.value = list[0]
                    }
                },
                _selectedCategory
            ) { categories, selectedCategory ->
                HomeViewState(
                    categories = categories,
                    selectedCategory = selectedCategory
                )
            }.collect { _state.value = it }
        }
        loadCategoriesFromDb()
    }
    /** My category list has "Time based" and "Location based" categories*/
    private fun loadCategoriesFromDb() {
        val list = mutableListOf(
            Category(name = "Time based"),
            Category(name = "Location based")
        )
        viewModelScope.launch {
            list.forEach { category -> categoryRepository.addCategory(category) }
        }
    }
}

// Category is created for reminders "Time based reminder" and "Location based remindes"
data class HomeViewState(
    val categories: List<Category> = emptyList(),
    val selectedCategory: Category? = null,
)