package com.yugyd.quizmaker.core.localstorage.api

interface LocalStorageProvider {
    fun createStorageByKey(storageKey: String): ObservableLocalStorage
    fun createMutableStorageByKey(storageKey: String): MutableLocalStorage
}
