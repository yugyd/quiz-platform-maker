package com.yugyd.quizmaker.content.domain.impl.data

import com.yugyd.quizmaker.content.domain.impl.data.models.ContentLocalEntity
import com.yugyd.quizmaker.core.coroutines.result
import com.yugyd.quizmaker.core.localstorage.api.LocalStorageProvider
import com.yugyd.quizmaker.core.localstorage.api.MutableLocalStorage
import com.yugyd.quizmaker.core.logger.api.Logger
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.json.Json

internal class ContentLocalStorageImpl(
    storageProvider: LocalStorageProvider,
    private val json: Json,
    private val logger: Logger,
) : ContentLocalStorage {

    private val storage: MutableLocalStorage = storageProvider.createMutableStorageByKey(
        "content",
    )

    override suspend fun update(content: ContentLocalEntity) {
        val key = contentKey(content.id)
        val serialized = json.encodeToString(content)
        storage.putPrimitive(key, serialized)
    }

    override fun subscribeToContent(id: String): Flow<ContentLocalEntity?> {
        val key = contentKey(id)

        return storage
            .subscribeToString(key)
            .map { serialized ->
                if (serialized == null) return@map null

                result {
                    json.decodeFromString<ContentLocalEntity>(serialized)
                }
                    .getOrElse {
                        logger.logError(it)
                        // Failed migration, remove broken data
                        storage.remove(key)
                        null
                    }
            }
    }

    override suspend fun getContent(id: String): ContentLocalEntity? {
        val key = contentKey(id)

        val serialized = storage.getString(key, null) ?: return null

        return result {
            json.decodeFromString<ContentLocalEntity>(serialized)
        }
            .getOrElse {
                logger.logError(it)
                // Failed migration, remove broken data
                storage.remove(key)
                null
            }
    }

    private companion object {
        private fun contentKey(id: String) = "content_$id"
    }
}
