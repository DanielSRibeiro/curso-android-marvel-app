package com.example.marvelapp.framework.network.response

data class CharactersResponse(
    val id : Int,
    val name : String,
    val thumbnailResponse: ThumbnailResponse
)