package com.yugyd.quizmaker.core.localstorage.api

interface LocalStorage {
    suspend fun getInt(key: String, defaultValue: Int): Int
    suspend fun getLong(key: String, defaultValue: Long): Long
    suspend fun getFloat(key: String, defaultValue: Float): Float
    suspend fun getString(key: String, defaultValue: String?): String?
    suspend fun getBoolean(key: String, defaultValue: Boolean): Boolean
    suspend fun hasValue(key: String): Boolean
}
