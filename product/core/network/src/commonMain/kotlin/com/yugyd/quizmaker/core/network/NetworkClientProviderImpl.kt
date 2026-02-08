package com.yugyd.quizmaker.core.network

import com.yugyd.quizmaker.core.network.api.NetworkClientProvider
import com.yugyd.quizmaker.core.network.api.NetworkConfig
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import com.yugyd.quizmaker.core.logger.api.Logger as AppLogger

class NetworkClientProviderImpl(
    private val engineFactory: EngineFactory,
    private val appLogger: AppLogger,
) : NetworkClientProvider {

    override fun client(config: NetworkConfig): HttpClient {
        return HttpClient(
            engine = engineFactory.create(config),
        ) {
            expectSuccess = false

            defaultRequest {
                url(config.baseUrl)
            }

            install(HttpCache)

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        appLogger.print(TAG, message)
                    }
                }
                level = LogLevel.ALL
            }

            install(HttpTimeout) {
                requestTimeoutMillis = config.timeoutMills
                connectTimeoutMillis = config.timeoutMills
                socketTimeoutMillis = config.timeoutMills
            }
        }
    }

    private companion object {
        private const val TAG = "NetworkClient"
    }
}
