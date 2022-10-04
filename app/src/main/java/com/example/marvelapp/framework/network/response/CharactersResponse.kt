package com.example.marvelapp.framework.network.response

import com.example.core.domain.model.Character

data class CharactersResponse(
    val id : Int,
    val name : String,
    val thumbnailResponse: ThumbnailResponse
)

fun CharactersResponse.toCharactersModel() : Character {
    return Character(
        name = this.name,
        imageUrl = "${this.thumbnailResponse.path}.${this.thumbnailResponse.extension}"
    )
}