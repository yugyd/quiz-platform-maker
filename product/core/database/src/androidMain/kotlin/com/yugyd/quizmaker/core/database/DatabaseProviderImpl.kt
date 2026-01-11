package com.yugyd.quizmaker.core.database

import android.content.Context
import com.yugyd.quizmaker.core.coroutines.DispatchersProvider
import com.yugyd.quizmaker.core.database.api.ContentDatabase
import com.yugyd.quizmaker.core.database.api.DatabaseProvider

actual class DatabaseProviderImpl(
    private val context: Context,
    private val dispatchersProvider: DispatchersProvider,
) : DatabaseProvider {

    actual override fun createDatabase(dbName: String): ContentDatabase {
        return getRoomDatabase(
            builder = getDatabaseBuilder(
                context = context,
                dbName = dbName,
            ),
            ioDispatcher = dispatchersProvider.io,
        )
    }
}
