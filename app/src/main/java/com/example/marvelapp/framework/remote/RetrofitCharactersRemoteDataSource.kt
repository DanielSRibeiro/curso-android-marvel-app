package com.example.marvelapp.framework.remote

import com.example.core.data.repository.CharactersRemoteDataSource
import com.example.marvelapp.framework.network.MarvelApi
import com.example.marvelapp.framework.network.response.DataWrapperResponse
import javax.inject.Inject

class RetrofitCharactersRemoteDataSource  @Inject constructor(
    private var marvelApi: MarvelApi
) : CharactersRemoteDataSource<DataWrapperResponse> {

    override suspend fun fetchCharacters(queries: Map<String, String>): DataWrapperResponse {
        return marvelApi.getCharacters(queries)
    }
}