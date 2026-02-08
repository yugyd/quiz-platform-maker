package com.yugyd.quizmaker.core.network.api

import io.ktor.client.HttpClient

interface NetworkClientProvider {
    fun client(config: NetworkConfig): HttpClient
}
