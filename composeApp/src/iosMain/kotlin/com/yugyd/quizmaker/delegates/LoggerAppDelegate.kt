package com.yugyd.quizmaker.delegates

import com.yugyd.quizmaker.AppDelegate
import com.yugyd.quizmaker.core.logger.LoggerInitializerImpl

internal class LoggerAppDelegate(private val isDebug: Boolean) : AppDelegate {

    override fun init() {
        if (isDebug) {
            LoggerInitializerImpl().initialize()
        }
    }
}
