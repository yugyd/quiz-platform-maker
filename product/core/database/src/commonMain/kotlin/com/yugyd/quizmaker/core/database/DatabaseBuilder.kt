package com.yugyd.quizmaker.core.database

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.CoroutineDispatcher

fun getRoomDatabase(
    builder: RoomDatabase.Builder<AppDatabase>,
    ioDispatcher: CoroutineDispatcher,
): AppDatabase {
    return builder
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(ioDispatcher)
        .build()
}
