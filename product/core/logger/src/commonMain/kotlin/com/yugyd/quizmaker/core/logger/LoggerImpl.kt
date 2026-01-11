package com.yugyd.quizmaker.core.logger

import com.yugyd.quizmaker.core.logger.api.Logger
import io.github.aakira.napier.Napier

class LoggerImpl : Logger {
    override fun print(message: String) {
        Napier.d(message = message)
    }

    override fun print(tag: String, message: String) {
        Napier.d(tag = tag, message = message)
    }

    override fun logError(error: Throwable) {
        Napier.e(throwable = error) {
            error.message ?: ""
        }
    }

    override fun logError(tag: String, error: Throwable) {
        Napier.e(tag = tag, throwable = error) {
            error.message ?: ""
        }
    }

    override fun recordError(error: Throwable) {
        logError(error)
    }

    override fun recordError(tag: String, error: Throwable) {
        logError(tag, error)
    }
}
