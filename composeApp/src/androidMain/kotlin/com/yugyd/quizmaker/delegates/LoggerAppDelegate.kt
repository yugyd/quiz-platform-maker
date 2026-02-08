package com.yugyd.quizmaker.delegates

import com.yugyd.quizmaker.api.AppBuildConfig
import com.yugyd.quizmaker.core.logger.LoggerInitializerImpl

class LoggerAppDelegate(
    private val appBuildConfig: AppBuildConfig,
) : AppDelegate {

    override fun init() {
        if (appBuildConfig.isDebug()) {
            LoggerInitializerImpl().initialize()
        }
    }
}
