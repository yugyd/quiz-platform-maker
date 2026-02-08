package com.yugyd.quizmaker.content.domain.impl

import com.yugyd.quizmaker.content.domain.api.models.ContentModel
import kotlinx.coroutines.flow.Flow

internal interface ContentRepository {

    // Only remote samples
    suspend fun getRemoteData(id: String): ContentModel

    // Remote + Database samples
    fun subscribeToData(id: String): Flow<ContentModel?>

    suspend fun getCachedData(id: String): ContentModel?

    suspend fun fetchData(id: String)

    // Remote + Local storage samples
    fun subscribeToLocalData(id: String): Flow<ContentModel?>

    suspend fun getLocalCachedData(id: String): ContentModel?

    suspend fun fetchLocalData(id: String)

    // Remote + In-memory storage samples
    fun subscribeToInMemoryData(id: String): Flow<ContentModel?>

    suspend fun getInMemoryData(id: String): ContentModel?

    suspend fun fetchInMemoryData(id: String)
}

