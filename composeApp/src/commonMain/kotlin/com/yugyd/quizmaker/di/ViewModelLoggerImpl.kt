package com.yugyd.quizmaker.di

import com.yugyd.quizmaker.core.logger.api.Logger
import com.yugyd.viewmodeldelegates.ViewModelLogger

class ViewModelLoggerImpl(
    private val logger: Logger,
) : ViewModelLogger {

    override fun log(message: String) {
        logger.print(message)
    }

    override fun throwIfDebug(error: Throwable) {
        logger.logError(error)
    }
}
