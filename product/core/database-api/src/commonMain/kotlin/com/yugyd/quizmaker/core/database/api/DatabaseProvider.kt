package com.yugyd.quizmaker.core.database.api

interface DatabaseProvider {
    fun createDatabase(dbName: String): ContentDatabase
}
