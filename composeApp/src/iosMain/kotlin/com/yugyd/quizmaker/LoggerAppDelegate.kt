package com.yugyd.quizmaker

import com.yugyd.quizmaker.core.logger.LoggerInitializerImpl

internal class LoggerAppDelegate(private val isDebug: Boolean) : AppDelegate {

    override fun init() {
        if (isDebug) {
            LoggerInitializerImpl().initialize()
        }
    }
}
