package com.yugyd.quizmaker.content.domain.impl.data.mappers

import com.yugyd.quizmaker.content.domain.api.models.ContentModel
import com.yugyd.quizmaker.content.domain.impl.data.models.ContentDto
import com.yugyd.quizmaker.content.domain.impl.data.models.ContentEntity

internal class ContentEntityMapper {

    fun toDomain(entity: ContentEntity): ContentModel {
        return ContentModel(
            id = entity.id,
            title = entity.title,
            description = entity.description,
        )
    }

    fun toEntity(dto: ContentDto): ContentEntity {
        return ContentEntity(
            id = dto.id,
            title = dto.title,
            description = dto.description,
        )
    }
}
