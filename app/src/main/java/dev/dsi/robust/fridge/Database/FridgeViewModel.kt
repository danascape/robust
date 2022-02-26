package dev.dsi.robust.fridge.Database

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FridgeViewModel (private val repository: FridgeRepository):ViewModel(){

    fun insert(items:FridgeItems)=GlobalScope.launch {
        repository.insert(items)
    }

    fun delete(items:FridgeItems)=GlobalScope.launch {
        repository.delete(items)
    }

    fun update(items:FridgeItems)=GlobalScope.launch {
        repository.update(items)
    }

fun getAllFridgeItems() = repository.getAllItems()
}
