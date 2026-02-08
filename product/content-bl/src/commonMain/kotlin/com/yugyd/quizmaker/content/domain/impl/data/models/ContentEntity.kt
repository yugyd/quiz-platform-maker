package com.yugyd.quizmaker.content.domain.impl.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "content")
internal data class ContentEntity(
    @PrimaryKey @ColumnInfo("id") val id: String,
    @ColumnInfo("title") val title: String,
    @ColumnInfo("description") val description: String,
)
