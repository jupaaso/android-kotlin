package com.sampleandroidapp.mobicomp

import android.content.Context
import androidx.room.Room
import com.sampleandroidapp.mobicomp.data.CategoryRepository
import com.sampleandroidapp.mobicomp.data.MobileComputingDatabase
import com.sampleandroidapp.mobicomp.data.ReminderRepository

/**
 * A simple singleton dependency graph
 *
 * For a real app, please use something like Koin/Dagger/Hilt instead
 */
object Graph {

    lateinit var database: MobileComputingDatabase

    lateinit var appContext: Context

    val categoryRepository by lazy {
        CategoryRepository(
            categoryDao = database.categoryDao()
        )
    }

    val reminderRepository by lazy {
        ReminderRepository(
            reminderDao = database.reminderDao()
        )
    }

    fun provide(context: Context) {
        appContext = context
        database = Room.databaseBuilder(context, MobileComputingDatabase::class.java, "mcDataJuha.db")
            .fallbackToDestructiveMigration()
            .build()
    }
}