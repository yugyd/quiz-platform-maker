package com.yugyd.quizmaker.core.network.api

data class NetworkConfig(
    val baseUrl: String,
    val timeoutMills: Long = 30_000L,
    val cacheSizeBytes: Long = 50L * 1024 * 1024 // 50 MB
)