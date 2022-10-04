package com.example.marvelapp.framework.di

import com.example.core.data.repository.CharactersRemoteDataSource
import com.example.core.data.repository.CharactersRepository
import com.example.marvelapp.framework.CharactersRepositoryImp
import com.example.marvelapp.framework.network.response.DataWrapperResponse
import com.example.marvelapp.framework.remote.RetrofitCharactersRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindCharactersRepository(repositoryImp: CharactersRepositoryImp) : CharactersRepository

    @Binds
    fun bindRemoteDataSource(
        dataSource: RetrofitCharactersRemoteDataSource
    ) : CharactersRemoteDataSource<DataWrapperResponse>
}