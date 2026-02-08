package com.yugyd.quizmaker.content.domain.impl.data.mappers

import com.yugyd.quizmaker.content.domain.api.models.ContentModel
import com.yugyd.quizmaker.content.domain.impl.data.models.ContentDto

internal class ContentRemoteMapper {

    fun toDomain(dto: ContentDto): ContentModel {
        return ContentModel(
            id = dto.id,
            title = dto.title,
            description = dto.description,
        )
    }
}
