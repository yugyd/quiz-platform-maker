package com.yugyd.quizmaker.core.network

import android.content.Context
import com.yugyd.quizmaker.core.network.api.NetworkConfig
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import okhttp3.Cache
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

actual class EngineFactory(
    private val context: Context
) {

    actual fun create(config: NetworkConfig): HttpClientEngine {
        val cache = Cache(
            directory = context.cacheDir,
            maxSize = config.cacheSizeBytes,
        )

        val client = OkHttpClient.Builder()
            .cache(cache)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

        return OkHttp.create { preconfigured = client }
    }
}
