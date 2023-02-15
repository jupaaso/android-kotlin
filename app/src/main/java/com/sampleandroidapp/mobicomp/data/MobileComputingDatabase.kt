package com.sampleandroidapp.mobicomp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sampleandroidapp.mobicomp.data.Category
import com.sampleandroidapp.mobicomp.data.Reminder

// The RoomDatabase for this app

@Database(
    entities = [Category::class, Reminder::class],
    version = 2,
    exportSchema = false
)

abstract class MobileComputingDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun reminderDao(): ReminderDao
}

