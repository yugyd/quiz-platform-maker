package com.yugyd.quizmaker

import android.app.Application
import com.yugyd.quizmaker.core.AppBuildConfigImpl
import com.yugyd.quizmaker.delegates.LoggerAppDelegate

internal class QuizMakerApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val appBuildConfig = AppBuildConfigImpl()
        LoggerAppDelegate(appBuildConfig).init()
    }
}
