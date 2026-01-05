package com.example.artfolio.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.artfolio.model.ArtItem

@Database(entities = [ArtItem::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun artDao(): ArtDao
}
