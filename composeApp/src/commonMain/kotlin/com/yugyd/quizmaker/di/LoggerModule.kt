package com.yugyd.quizmaker.di

import com.yugyd.quizmaker.core.logger.LoggerImpl
import com.yugyd.quizmaker.core.logger.api.Logger
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val loggerModule = module {
    factoryOf<Logger>(::LoggerImpl)
}
