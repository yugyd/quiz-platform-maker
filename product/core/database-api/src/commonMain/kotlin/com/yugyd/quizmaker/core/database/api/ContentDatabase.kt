package com.yugyd.quizmaker.core.database.api

interface ContentDatabase {
    fun themeDao(): ThemeDao
    fun questDao(): QuestDao
}
