package dev.dsi.robust.fridge.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "fridge_items")
class FridgeItems: Serializable {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    @ColumnInfo(name="item_name")
    var itemName:String?=null

    @ColumnInfo(name="expiry")
    var itemExpiry:Int?=null

    @ColumnInfo(name="item_quantity")
    var itemQuantity:Int?=null

    @ColumnInfo(name="item_tag")
    var itemTag:String?=null

}

