package com.yugyd.quizmaker.core.database.api

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yugyd.quizmaker.core.database.api.entities.QuestEntity

@Dao
interface QuestDao {

    @Query("SELECT * FROM quest")
    suspend fun getAll(): List<QuestEntity>

    @Query("SELECT _id FROM quest")
    suspend fun getIds(): List<Int>

    @Query("SELECT _id FROM quest WHERE category = :themeId")
    suspend fun getIdsByTheme(themeId: Int): List<Int>

    @Query("SELECT _id FROM quest WHERE category = :themeId AND section = :sectionId")
    suspend fun getIdsBySection(themeId: Int, sectionId: Int): List<Int>

    @Query("SELECT * FROM quest WHERE _id = :id")
    suspend fun getQuestById(id: Int): QuestEntity

    @Query("SELECT * FROM quest WHERE _id IN (:questIds)")
    suspend fun loadAllByIds(questIds: IntArray): List<QuestEntity>

    @Query("SELECT MAX(section) FROM quest WHERE category = :themeId")
    suspend fun getSectionCountByTheme(themeId: Int): Int

    @Query("SELECT MIN(section) FROM quest WHERE category = :themeId")
    suspend fun getMinSectionByTheme(themeId: Int): Int

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertAll(quests: List<QuestEntity>)
}
