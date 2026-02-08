package com.yugyd.quizmaker.content.domain.impl.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yugyd.quizmaker.content.domain.impl.data.models.ContentEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface ContentDao {

    @Query("SELECT * FROM content WHERE id = :id")
    fun observeById(id: String): Flow<ContentEntity?>

    @Query("SELECT * FROM content WHERE id = :id")
    suspend fun getById(id: String): ContentEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(entity: ContentEntity)
}
