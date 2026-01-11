package com.yugyd.quizmaker.core.database.api.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quest")
data class QuestEntity(
    @PrimaryKey @ColumnInfo(name = "_id") val id: Int,
    @ColumnInfo(name = "quest") val quest: String,
    @ColumnInfo(name = "image") val image: String?,
    @ColumnInfo(name = "true_answer") val trueAnswer: String,
    @ColumnInfo(name = "answer2") val answer2: String?,
    @ColumnInfo(name = "answer3") val answer3: String?,
    @ColumnInfo(name = "answer4") val answer4: String?,
    @ColumnInfo(name = "answer5") val answer5: String?,
    @ColumnInfo(name = "answer6") val answer6: String?,
    @ColumnInfo(name = "answer7") val answer7: String?,
    @ColumnInfo(name = "answer8") val answer8: String?,
    @ColumnInfo(name = "complexity") val complexity: Int,
    @ColumnInfo(name = "category") val category: Int,
    @ColumnInfo(name = "section") val section: Int,
    @ColumnInfo(
        name = "type",
        defaultValue = QuestTypeEntityConstants.SIMPLE_TYPE_DATABASE_VALUE,
    ) val type: QuestTypeEntity,
)
