package com.yugyd.quizmaker.core.logger.api

interface Logger {
    fun print(message: String)
    fun print(tag: String, message: String)
    fun logError(error: Throwable)
    fun logError(tag: String, error: Throwable)
    fun recordError(error: Throwable)
    fun recordError(tag: String, error: Throwable)
}
