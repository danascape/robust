package dev.dsi.robust.fridge.Database

import android.view.ViewGroupOverlay
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FridgeViewModelFactory(private val repository: FridgeRepository):ViewModelProvider.NewInstanceFactory() {

    override fun <T: ViewModel?>cretae(modelClass: Class<T>):T{
        return FridgeViewModel(repository) as T
    }
}
