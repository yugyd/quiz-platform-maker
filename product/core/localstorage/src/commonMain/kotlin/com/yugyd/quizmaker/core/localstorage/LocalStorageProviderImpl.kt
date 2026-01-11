package com.yugyd.quizmaker.core.localstorage

import com.yugyd.quizmaker.core.localstorage.api.LocalStorageProvider
import com.yugyd.quizmaker.core.localstorage.api.MutableLocalStorage
import com.yugyd.quizmaker.core.localstorage.api.ObservableLocalStorage

expect class LocalStorageProviderImpl : LocalStorageProvider {
    override fun createStorageByKey(storageKey: String): ObservableLocalStorage
    override fun createMutableStorageByKey(storageKey: String): MutableLocalStorage
}
