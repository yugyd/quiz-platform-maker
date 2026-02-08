package com.yugyd.quizmaker.content.domain.impl.data

import com.yugyd.quizmaker.content.domain.impl.data.models.ContentDto

internal interface ContentRemoteSource {
    suspend fun getContent(id: String): ContentDto
}
