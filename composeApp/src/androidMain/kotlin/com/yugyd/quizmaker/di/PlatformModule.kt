package com.yugyd.quizmaker.di

import com.yugyd.quizmaker.api.AppBuildConfig
import com.yugyd.quizmaker.core.AppBuildConfigImpl
import org.koin.dsl.module

val platformModule = module {
    single<AppBuildConfig> { AppBuildConfigImpl() }
}
