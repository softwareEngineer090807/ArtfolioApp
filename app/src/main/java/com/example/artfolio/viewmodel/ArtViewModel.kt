package com.example.artfolio.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.artfolio.R
import com.example.artfolio.data.AppDatabase
import com.example.artfolio.data.ArtDao
import com.example.artfolio.model.ArtItem
import kotlinx.coroutines.launch

class ArtViewModel(application: Application) : AndroidViewModel(application) {
    private val db: AppDatabase = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "art-database"
    ).build()
    private val artDao: ArtDao = db.artDao()

    val allArt: LiveData<List<ArtItem>> = artDao.getAllArt()

    fun insertDummyData() {
        viewModelScope.launch {
            artDao.insertAll(listOf(
                ArtItem(title = "Abstract Fire", description = "A fiery abstract composition", imageResId = R.drawable.art1),
                ArtItem(title = "Blue Circle", description = "Minimalist blue circle study", imageResId = R.drawable.art2),
                ArtItem(title = "Green Square", description = "Geometric nature patterns", imageResId = R.drawable.art3),
                ArtItem(title = "Abstract Fire 2", description = "Variation on fire theme", imageResId = R.drawable.art1),
                ArtItem(title = "Blue Circle 2", description = "Deep ocean vibes", imageResId = R.drawable.art2),
                ArtItem(title = "Green Square 2", description = "Forest canopy abstraction", imageResId = R.drawable.art3)
            ))
        }
    }
}
