package com.yugyd.quizmaker

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform