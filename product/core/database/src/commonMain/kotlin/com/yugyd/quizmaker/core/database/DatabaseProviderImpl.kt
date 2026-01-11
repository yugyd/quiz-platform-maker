package com.yugyd.quizmaker.core.database

import com.yugyd.quizmaker.core.database.api.ContentDatabase
import com.yugyd.quizmaker.core.database.api.DatabaseProvider

expect class DatabaseProviderImpl : DatabaseProvider {
    override fun createDatabase(dbName: String): ContentDatabase
}
