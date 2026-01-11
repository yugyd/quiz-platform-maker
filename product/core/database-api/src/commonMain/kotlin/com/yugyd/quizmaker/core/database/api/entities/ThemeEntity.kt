package com.yugyd.quizmaker.core.database.api.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class ThemeEntity(
    @PrimaryKey @ColumnInfo(name = "_id") val id: Int,
    @ColumnInfo(name = "ordinal") val ordinal: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "info") val info: String,
    @ColumnInfo(name = "image") val image: String?,
    @ColumnInfo(name = "count") val count: Int
)
