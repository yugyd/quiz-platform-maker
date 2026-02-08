package com.yugyd.quizmaker.content.domain.impl.data

import com.yugyd.quizmaker.content.domain.impl.data.models.ContentLocalEntity
import kotlinx.coroutines.flow.Flow

internal interface ContentLocalStorage {
    suspend fun update(content: ContentLocalEntity)
    fun subscribeToContent(id: String): Flow<ContentLocalEntity?>
    suspend fun getContent(id: String): ContentLocalEntity?
}
