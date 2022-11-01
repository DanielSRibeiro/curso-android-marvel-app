package com.example.core.data.repository

import com.example.core.domain.model.CharacterPaging
import com.example.core.domain.model.Comic
import com.example.core.domain.model.Event
import com.example.core.usecase.base.ResultStatus
import retrofit2.Call

interface CharactersRemoteDataSource {

    suspend fun fetchCharacters(queries: Map<String, String>) : CharacterPaging

    suspend fun fetchComics(characterId: Int) : List<Comic>

    suspend fun fetchEvents(characterId: Int) : List<Event>
}