package com.yugyd.quizmaker.core.localstorage

import com.yugyd.quizmaker.core.localstorage.api.LocalStorageProvider
import com.yugyd.quizmaker.core.localstorage.api.MutableLocalStorage
import com.yugyd.quizmaker.core.localstorage.api.ObservableLocalStorage
import kotlinx.atomicfu.atomic
import kotlinx.atomicfu.locks.SynchronizedObject
import kotlinx.atomicfu.locks.synchronized
import kotlinx.collections.immutable.persistentMapOf

actual class LocalStorageProviderImpl : LocalStorageProvider {

    private val dataStores = atomic(persistentMapOf<String, LocalStorageImpl>())
    private val lock = SynchronizedObject()

    actual override fun createStorageByKey(storageKey: String): ObservableLocalStorage {
        return createLocalStorage(storageKey)
    }

    actual override fun createMutableStorageByKey(storageKey: String): MutableLocalStorage {
        return createLocalStorage(storageKey)
    }

    private fun createLocalStorage(storageKey: String): LocalStorageImpl {
        val current = dataStores.value[storageKey]
        if (current != null) {
            return current
        }

        synchronized(lock) {
            val currentMap = dataStores.value
            val current = currentMap[storageKey]
            if (current != null) {
                return current
            }

            val dataStore = createDataStore(dataStoreFileName = createFileName(storageKey))
            val localStorage = LocalStorageImpl(dataStore = dataStore)
            val newMap = currentMap.put(storageKey, localStorage)
            dataStores.value = newMap
            return localStorage
        }
    }

    private fun createFileName(storageKey: String): String {
        return "$storageKey.preferences_pb"
    }
}
