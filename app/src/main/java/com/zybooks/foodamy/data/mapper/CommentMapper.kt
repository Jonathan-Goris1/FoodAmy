package com.zybooks.foodamy.data.mapper

import com.zybooks.foodamy.data.local.local_dto.CommentDb
import com.zybooks.foodamy.data.remote.response.CommentResponse
import com.zybooks.foodamy.domain.model.Comment


fun CommentDb.toDomainModel(): Comment = Comment(
        id = this.id,
        text = this.text,
        user = this.user.toDomainModel(),
        difference = this.difference
    )


fun CommentResponse.toLocalDto(recipeId: Int): CommentDb = CommentDb(
        id = this.id,
        text = this.text,
        difference = this.difference,
        user = this.user.toLocalDto(),
        recipeId = recipeId
    )

fun CommentResponse.toDomainModel(): Comment =
        Comment(
                id = this.id,
                text = this.text,
                user = this.user.toDomainModel(),
                difference = this.difference
        )
