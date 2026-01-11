package com.yugyd.quizmaker.core.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import com.yugyd.quizmaker.core.database.api.ContentDatabase
import com.yugyd.quizmaker.core.database.api.QuestDao
import com.yugyd.quizmaker.core.database.api.ThemeDao
import com.yugyd.quizmaker.core.database.api.entities.QuestEntity
import com.yugyd.quizmaker.core.database.api.entities.ThemeEntity

private const val CONTENT_DB_VERSION = 7

@Database(
    entities = [
        QuestEntity::class,
        ThemeEntity::class,
    ],
    version = CONTENT_DB_VERSION,
)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase(), ContentDatabase {
    abstract override fun themeDao(): ThemeDao
    abstract override fun questDao(): QuestDao
}
