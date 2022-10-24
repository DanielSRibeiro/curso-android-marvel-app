package com.example.marvelapp.framework.network.response

import com.example.core.domain.model.Character
import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("id") val id : String,
    @SerializedName("name") val name : String,
    @SerializedName("thumbnail") val thumbnail: ThumbnailResponse
)

fun CharactersResponse.toCharacterModel() : Character {
    return Character(
        name = this.name,
        imageUrl = "${this.thumbnail.path}.${this.thumbnail.extension}"
            .replace("http","https")
    )
}