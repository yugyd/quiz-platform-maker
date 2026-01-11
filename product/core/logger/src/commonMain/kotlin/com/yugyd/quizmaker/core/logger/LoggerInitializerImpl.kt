package com.yugyd.quizmaker.core.logger

import com.yugyd.quizmaker.core.logger.api.LoggerInitializer

expect class LoggerInitializerImpl : LoggerInitializer {
    override fun initialize()
}
