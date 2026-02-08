package com.yugyd.quizmaker

import android.app.Application
import com.yugyd.quizmaker.delegates.KoinAppDelegate
import com.yugyd.quizmaker.delegates.LoggerAppDelegate
import org.koin.android.ext.android.get

class QuizMakerApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        KoinAppDelegate().init()
        LoggerAppDelegate(get()).init()
    }
}
