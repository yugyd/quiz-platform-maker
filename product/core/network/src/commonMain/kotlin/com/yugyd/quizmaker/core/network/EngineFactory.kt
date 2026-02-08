package com.yugyd.quizmaker.core.network

import com.yugyd.quizmaker.core.network.api.NetworkConfig
import io.ktor.client.engine.*

expect class EngineFactory {
    fun create(config: NetworkConfig): HttpClientEngine
}
