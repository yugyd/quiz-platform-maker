package com.yugyd.quizmaker.content.domain.impl.data

import com.yugyd.quizmaker.content.domain.api.models.ContentModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

internal class ContentInMemoryStorageImpl : ContentInMemoryStorage {

    private val mutex = Mutex()
    private val state = MutableStateFlow<Map<String, ContentModel>>(emptyMap())

    override fun subscribeToContent(id: String): Flow<ContentModel?> =
        state
            .map { it[id] }
            .distinctUntilChanged()

    override suspend fun setContent(content: ContentModel) {
        mutex.withLock {
            val currentMap = state.value
            val newMap = currentMap.plus(content.id to content)
            state.value = newMap
        }
    }

    override suspend fun getContent(id: String): ContentModel? {
        return state.value[id]
    }

    override suspend fun clearContent(id: String) {
        mutex.withLock {
            val currentMap = state.value
            val newMap = currentMap.minus(id)
            state.value = newMap
        }
    }
}
