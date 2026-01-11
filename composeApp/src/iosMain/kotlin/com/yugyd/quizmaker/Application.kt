package com.yugyd.quizmaker

import com.yugyd.quizmaker.delegates.KoinAppDelegate
import com.yugyd.quizmaker.delegates.LoggerAppDelegate

fun onCreate(isDebug: Boolean) {
    KoinAppDelegate().init()
    LoggerAppDelegate(isDebug = isDebug).init()
}
