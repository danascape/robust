package dev.dsi.robust.fridge.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FridgeItems::class], version = 1)
abstract class FridgeDatabase : RoomDatabase() {

    abstract fun getFridgeDao(): FridgeDao

    companion object {
        @Volatile
        private var instance: FridgeDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                FridgeDatabase::class.java,
                "Fridge.db"
            ).build()
    }
}
