package com.yugyd.quizmaker.core.database.api.entities

enum class QuestTypeEntity(val databaseValue: String) {
    SIMPLE(databaseValue = QuestTypeEntityConstants.SIMPLE_TYPE_DATABASE_VALUE),
    SIMPLE_LATEX(databaseValue = "simple_latex"),
    ENTER(databaseValue = "enter"),
    ENTER_WITH_HINT(databaseValue = "enter_with_hint"),
    SELECT_MANUAL(databaseValue = "select_manual"),
    SELECT(databaseValue = "select"),
    ENTER_AI(databaseValue = "enter_ai"),
    SELECT_BOOL(databaseValue = "select_bool"),
    NONE(databaseValue = ""),
}
