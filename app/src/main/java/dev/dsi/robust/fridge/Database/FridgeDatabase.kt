package dev.dsi.robust.fridge.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FridgeItems::class], version = 1, exportSchema = false)
abstract class FridgeDatabase : RoomDatabase() {

    abstract fun getFridgeDao(): FridgeDao

    companion object {
        @Volatile
        private var INSTANCE: FridgeDatabase? = null

        fun getDatabase(context: Context): FridgeDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FridgeDatabase::class.java,
                    "Fridge_Database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}