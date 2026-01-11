package com.yugyd.quizmaker.core.localstorage.api

interface MutableLocalStorage : ObservableLocalStorage {
    suspend fun putPrimitive(key: String, value: Any)
    suspend fun remove(key: String)
    suspend fun clearAll()
}
