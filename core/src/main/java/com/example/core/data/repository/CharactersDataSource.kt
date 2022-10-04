package com.example.core.data.repository

interface CharactersDataSource<T> {

    suspend fun fetchCharacters(queries: Map<String, String>) : T
}