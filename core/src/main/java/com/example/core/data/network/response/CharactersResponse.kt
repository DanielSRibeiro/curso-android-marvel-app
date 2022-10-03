package com.example.core.data.network.response

data class CharactersResponse(
    val id : Int,
    val name : String,
    val thumbnailResponse: ThumbnailResponse
)