package dev.dsi.robust.fridge.Database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FridgeDao {

    @Query("SELECT * FROM fridge_items")
    fun getAllFridgeItems(): LiveData<List<Fridge>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Fridge)

    @Delete
    suspend fun delete(item: Fridge)

    @Update
    suspend fun update(item: Fridge)

}