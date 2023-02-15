package com.sampleandroidapp.mobicomp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.sampleandroidapp.mobicomp.data.Category
import kotlinx.coroutines.flow.Flow

@Dao
abstract class CategoryDao {

    //@TypeConverters(MyConverter::class)
    @Query(value = "SELECT * FROM categories WHERE name = :name")
    abstract fun getCategoryWithName(name: String): Category?

    @Query("SELECT * FROM categories WHERE id = :categoryId")
    abstract fun getCategoryWithId(categoryId: Long): Category?

    @Query("SELECT * FROM categories LIMIT 15")
    abstract fun categories(): Flow<List<Category>>

    // Annotations (selitys) Insert, Update, Delete perform CUD operations
    // We mark these functions as suspend
    // (so that we can call them inside coroutines)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(entity: Category): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertAll(entities: Collection<Category>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun update(entity: Category)

    @Delete
    abstract suspend fun delete(entity: Category): Int

    /**
    @Query("DELETE FROM categories")
    abstract suspend fun deleteAll(entities: Collection<Category>)  */
}