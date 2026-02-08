package com.yugyd.quizmaker.content.domain.impl.data

import com.yugyd.quizmaker.content.domain.api.models.ContentModel
import com.yugyd.quizmaker.content.domain.impl.ContentRepository
import com.yugyd.quizmaker.content.domain.impl.data.mappers.ContentEntityMapper
import com.yugyd.quizmaker.content.domain.impl.data.mappers.ContentLocalEntityMapper
import com.yugyd.quizmaker.content.domain.impl.data.mappers.ContentRemoteMapper
import com.yugyd.quizmaker.core.coroutines.DispatchersProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

internal class ContentRepositoryImpl(
    private val contentRemoteSource: ContentRemoteSource,
    private val contentDao: ContentDao,
    private val contentLocalStorage: ContentLocalStorage,
    private val contentInMemoryStorage: ContentInMemoryStorage,
    private val contentRemoteMapper: ContentRemoteMapper,
    private val contentEntityMapper: ContentEntityMapper,
    private val contentLocalEntityMapper: ContentLocalEntityMapper,
    private val dispatchersProvider: DispatchersProvider,
) : ContentRepository {

    // Only remote samples
    override suspend fun getRemoteData(id: String): ContentModel {
        val dto = contentRemoteSource.getContent(id)
        return contentRemoteMapper.toDomain(dto)
    }

    // Remote + Database samples
    override fun subscribeToData(id: String): Flow<ContentModel?> {
        return contentDao.observeById(id)
            .map { entity ->
                entity?.let(contentEntityMapper::toDomain)
            }
            .flowOn(dispatchersProvider.io)
    }

    override suspend fun getCachedData(id: String): ContentModel? {
        return withContext(dispatchersProvider.io) {
            val entity = contentDao.getById(id)
            entity?.let(contentEntityMapper::toDomain)
        }
    }

    override suspend fun fetchData(id: String) {
        withContext(dispatchersProvider.io) {
            val dto = contentRemoteSource.getContent(id)
            val entity = contentEntityMapper.toEntity(dto)
            contentDao.update(entity)
        }
    }

    // Remote + Local storage samples
    override fun subscribeToLocalData(id: String): Flow<ContentModel?> {
        return contentLocalStorage.subscribeToContent(id)
            .map { entity ->
                entity?.let(contentLocalEntityMapper::toDomain)
            }
            .flowOn(dispatchersProvider.io)
    }

    override suspend fun getLocalCachedData(id: String): ContentModel? {
        return withContext(dispatchersProvider.io) {
            val entity = contentLocalStorage.getContent(id)
            entity?.let(contentLocalEntityMapper::toDomain)
        }
    }

    override suspend fun fetchLocalData(id: String) {
        withContext(dispatchersProvider.io) {
            val dto = contentRemoteSource.getContent(id)
            val entity = contentLocalEntityMapper.toEntity(dto)
            contentLocalStorage.update(entity)
        }
    }

    // Remote + In-memory storage samples
    override fun subscribeToInMemoryData(id: String): Flow<ContentModel?> {
        return contentInMemoryStorage.subscribeToContent(id)
            .flowOn(dispatchersProvider.io)
    }

    override suspend fun getInMemoryData(id: String): ContentModel? {
        return withContext(dispatchersProvider.io) {
            contentInMemoryStorage.getContent(id)
        }
    }

    override suspend fun fetchInMemoryData(id: String) {
        withContext(dispatchersProvider.io) {
            val dto = contentRemoteSource.getContent(id)
            val domain = contentRemoteMapper.toDomain(dto)
            contentInMemoryStorage.setContent(domain)
        }
    }
}
