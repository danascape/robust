package dev.dsi.robust.fridge.Database

class FridgeRepository(private val db: FridgeDatabase) {

    suspend fun insert(items: FridgeItems) = db.getFridgeDao().insert(items)
    suspend fun delete(items: FridgeItems) = db.getFridgeDao().delete(items)
    suspend fun update(items: FridgeItems) = db.getFridgeDao().update(items)

    fun getAllItems() = db.getFridgeDao().getAllFridgeItems()
}