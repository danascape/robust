package dev.dsi.robust.fridge.Database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class FridgeViewModel (application: Application):AndroidViewModel(Application()){

    private var parentJob = Job()
    private val scope = CoroutineScope(parentJob + Dispatchers.Main)

    private val repository: FridgeRepository
    val allLists: LiveData<List<FridgeItems>>

    init {
        val fridgeDao = FridgeDatabase.getDatabase(application).getFridgeDao()
        repository = FridgeRepository(fridgeDao)
        allLists = getAllFridgeItems()
    }

    fun insert(items:FridgeItems)=scope.launch {
        repository.insert(items)
    }

    fun delete(items:FridgeItems)=scope.launch {
        repository.delete(items)
    }

    fun update(items:FridgeItems)=scope.launch {
        repository.update(items)
    }

fun getAllFridgeItems() = repository.getAllItems()
}
