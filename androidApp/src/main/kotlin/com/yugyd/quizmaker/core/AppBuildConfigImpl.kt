package com.yugyd.quizmaker.core

import com.yugyd.quizmaker.BuildConfig
import com.yugyd.quizmaker.api.AppBuildConfig

class AppBuildConfigImpl : AppBuildConfig {
    override fun isDebug() = BuildConfig.DEBUG
}
