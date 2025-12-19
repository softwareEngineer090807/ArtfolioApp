package com.example.artfolio.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "art_table")
data class ArtItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String,
    val imageResId: Int // Storing resource ID for simplicity with local drawables
)
