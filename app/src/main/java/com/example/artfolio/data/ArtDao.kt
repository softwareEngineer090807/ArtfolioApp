package com.example.artfolio.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.artfolio.model.ArtItem

@Dao
interface ArtDao {
    @Query("SELECT * FROM art_table")
    fun getAllArt(): LiveData<List<ArtItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(artItems: List<ArtItem>)
}
