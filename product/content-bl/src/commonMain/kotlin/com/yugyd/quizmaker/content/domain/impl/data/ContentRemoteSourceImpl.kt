package com.yugyd.quizmaker.content.domain.impl.data

import com.yugyd.quizmaker.content.domain.impl.data.models.ContentDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class ContentRemoteSourceImpl(
    private val client: HttpClient,
) : ContentRemoteSource {

    override suspend fun getContent(id: String): ContentDto {
        return client.get("/content/$id").body<ContentDto>()
    }
}
