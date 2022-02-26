package dev.dsi.robust.fridge.Database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FridgeDao {

    @Query("SELECT * FROM fridge_items")
    fun getAllFridgeItems(): LiveData<List<FridgeItems>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: FridgeItems)

    @Delete
    suspend fun delete(item: FridgeItems)

    @Update
    suspend fun update(item: FridgeItems)

}