package com.yugyd.quizmaker.core.localstorage

import android.content.Context
import com.yugyd.quizmaker.core.localstorage.api.LocalStorageProvider
import com.yugyd.quizmaker.core.localstorage.api.MutableLocalStorage
import com.yugyd.quizmaker.core.localstorage.api.ObservableLocalStorage
import kotlinx.collections.immutable.persistentMapOf

actual class LocalStorageProviderImpl(
    private val context: Context,
) : LocalStorageProvider {

    @Volatile
    private var dataStores = persistentMapOf<String, LocalStorageImpl>()

    actual override fun createStorageByKey(storageKey: String): ObservableLocalStorage {
        return createLocalStorage(storageKey)
    }

    actual override fun createMutableStorageByKey(storageKey: String): MutableLocalStorage {
        return createLocalStorage(storageKey)
    }

    private fun createLocalStorage(storageKey: String): LocalStorageImpl {
        val current = dataStores[storageKey]
        if (current != null) {
            return current
        }

        synchronized(this) {
            val current = dataStores[storageKey]
            if (current != null) {
                return current
            }

            val dataStore = createDataStore(
                context = context,
                dataStoreFileName = createFileName(storageKey),
            )
            val localStorage = LocalStorageImpl(dataStore = dataStore)
            dataStores = dataStores.put(key = storageKey, value = localStorage)
            return localStorage
        }
    }

    private fun createFileName(storageKey: String): String {
        return "$storageKey.preferences_pb"
    }
}
