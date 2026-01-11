package com.yugyd.quizmaker.core.database.api

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yugyd.quizmaker.core.database.api.entities.ThemeEntity

@Dao
interface ThemeDao {

    @Query("SELECT * FROM category ORDER BY ordinal ASC")
    suspend fun getAll(): List<ThemeEntity>

    @Query("SELECT * FROM category WHERE _id = :id")
    suspend fun getThemeById(id: Int): ThemeEntity

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertAll(themes: List<ThemeEntity>)
}
