package com.yugyd.quizmaker.core.localstorage.api

import kotlinx.coroutines.flow.Flow

interface ObservableLocalStorage : LocalStorage {
    fun subscribeToInt(key: String): Flow<Int?>
    fun subscribeToLong(key: String): Flow<Long?>
    fun subscribeToFloat(key: String): Flow<Float?>
    fun subscribeToString(key: String): Flow<String?>
    fun subscribeToBoolean(key: String): Flow<Boolean?>
}
