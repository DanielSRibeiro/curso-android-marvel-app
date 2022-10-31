package com.example.marvelapp.framework.network

import com.example.marvelapp.framework.network.response.CharactersResponse
import com.example.marvelapp.framework.network.response.ComicResponse
import com.example.marvelapp.framework.network.response.DataWrapperResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface MarvelApi {

    @GET("characters")
    suspend fun getCharacters(
        @QueryMap queries: Map<String, String>
    ) : DataWrapperResponse<CharactersResponse>

    @GET("characters/{characterId}/comics")
    suspend fun getComics(
        @Path("characterId") characterId: Int
    ) : DataWrapperResponse<ComicResponse>
}