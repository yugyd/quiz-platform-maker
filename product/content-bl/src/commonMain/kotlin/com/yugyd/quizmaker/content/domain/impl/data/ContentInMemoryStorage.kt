package com.yugyd.quizmaker.content.domain.impl.data

import com.yugyd.quizmaker.content.domain.api.models.ContentModel
import kotlinx.coroutines.flow.Flow

internal interface ContentInMemoryStorage {
    fun subscribeToContent(id: String): Flow<ContentModel?>
    suspend fun setContent(content: ContentModel)
    suspend fun getContent(id: String): ContentModel?
    suspend fun clearContent(id: String)
}
