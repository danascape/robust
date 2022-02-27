package dev.dsi.robust.fridge.Database

import android.app.Application
import android.view.ViewGroupOverlay
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FridgeViewModelFactory(private val repository: FridgeRepository):ViewModelProvider.NewInstanceFactory() {

    override fun <T: ViewModel>create(modelClass: Class<T>):T{
        return FridgeViewModel(Application()) as T
    }
}
