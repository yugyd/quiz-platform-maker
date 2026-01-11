package com.yugyd.quizmaker.core.logger

import com.yugyd.quizmaker.core.logger.api.LoggerInitializer
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

actual class LoggerInitializerImpl : LoggerInitializer {
    actual override fun initialize() {
        Napier.base(DebugAntilog())
    }
}
