package dev.dsi.robust.fridge.Database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "fridge_items")
class Fridge: Serializable {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

}