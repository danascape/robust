package dev.dsi.robust.fridge.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "fridge_items")
data class FridgeItems (

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name="item_name")
    var itemName:String="",

    @ColumnInfo(name="expiry")
    var itemExpiry:String = "",

    @ColumnInfo(name="item_quantity")
    var itemQuantity:Long=0L,

    @ColumnInfo(name="item_tag")
    var itemTag:String="",

    @ColumnInfo(name = "bg_color")
    var bg: Int = 0

)

