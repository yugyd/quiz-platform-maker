package com.yugyd.quizmaker.core.network

import com.yugyd.quizmaker.core.network.api.NetworkConfig
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin

actual class EngineFactory {

    actual fun create(config: NetworkConfig): HttpClientEngine =
        Darwin.create()
}