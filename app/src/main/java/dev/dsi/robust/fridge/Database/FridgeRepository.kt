package dev.dsi.robust.fridge.Database

import androidx.annotation.WorkerThread

class FridgeRepository(private val fridgeDao: FridgeDao) {

    @WorkerThread
    suspend fun insert(items: FridgeItems) = fridgeDao.insert(items)

    @WorkerThread
    suspend fun delete(items: FridgeItems) = fridgeDao.delete(items)

    @WorkerThread
    suspend fun update(items: FridgeItems) = fridgeDao.update(items)

    fun getAllItems() = fridgeDao.getAllFridgeItems()
}