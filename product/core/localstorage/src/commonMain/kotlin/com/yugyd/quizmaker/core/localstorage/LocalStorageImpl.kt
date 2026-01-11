package com.yugyd.quizmaker.core.localstorage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.yugyd.quizmaker.core.localstorage.api.MutableLocalStorage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class LocalStorageImpl(
    private val dataStore: DataStore<Preferences>,
) : MutableLocalStorage {

    override suspend fun putPrimitive(key: String, value: Any) {
        dataStore.edit { prefs ->
            when (value) {
                is String -> prefs[stringPreferencesKey(key)] = value
                is Int -> prefs[intPreferencesKey(key)] = value
                is Long -> prefs[longPreferencesKey(key)] = value
                is Float -> prefs[floatPreferencesKey(key)] = value
                is Boolean -> prefs[booleanPreferencesKey(key)] = value
                else -> throw IllegalArgumentException("$value isn't a primitive type")
            }
        }
    }

    override suspend fun remove(key: String) {
        dataStore.edit { preferences ->
            preferences.remove(stringPreferencesKey(key))
            preferences.remove(intPreferencesKey(key))
            preferences.remove(longPreferencesKey(key))
            preferences.remove(floatPreferencesKey(key))
            preferences.remove(booleanPreferencesKey(key))
        }
    }

    override suspend fun clearAll() {
        dataStore.edit { prefs ->
            prefs.clear()
        }
    }

    override fun subscribeToInt(key: String): Flow<Int?> {
        return dataStore.data.map { preferences ->
            preferences[intPreferencesKey(key)]
        }
    }

    override fun subscribeToString(key: String): Flow<String?> {
        return dataStore.data.map { preferences ->
            preferences[stringPreferencesKey(key)]
        }
    }

    override fun subscribeToLong(key: String): Flow<Long?> {
        return dataStore.data.map { preferences ->
            preferences[longPreferencesKey(key)]
        }
    }

    override fun subscribeToFloat(key: String): Flow<Float?> {
        return dataStore.data.map { preferences ->
            preferences[floatPreferencesKey(key)]
        }
    }

    override fun subscribeToBoolean(key: String): Flow<Boolean?> {
        return dataStore.data.map { preferences ->
            preferences[booleanPreferencesKey(key)]
        }
    }

    override suspend fun getInt(key: String, defaultValue: Int): Int {
        return dataStore.data.map { preferences ->
            preferences[intPreferencesKey(key)] ?: defaultValue
        }
            .first()
    }

    override suspend fun getString(key: String, defaultValue: String?): String? {
        return dataStore.data.map { preferences ->
            preferences[stringPreferencesKey(key)] ?: defaultValue
        }
            .first()
    }

    override suspend fun getLong(key: String, defaultValue: Long): Long {
        return dataStore.data.map { preferences ->
            preferences[longPreferencesKey(key)] ?: defaultValue
        }
            .first()
    }

    override suspend fun getFloat(key: String, defaultValue: Float): Float {
        return dataStore.data.map { preferences ->
            preferences[floatPreferencesKey(key)] ?: defaultValue
        }
            .first()
    }

    override suspend fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return dataStore.data.map { preferences ->
            preferences[booleanPreferencesKey(key)] ?: defaultValue
        }
            .first()
    }

    override suspend fun hasValue(key: String): Boolean {
        return dataStore.data.map { prefs ->
            prefs
                .asMap()
                .keys
                .any {
                    it.name == key
                }
        }
            .first()
    }
}
