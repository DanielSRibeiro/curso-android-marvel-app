package com.example.marvelapp.framework.paging

import android.accounts.NetworkErrorException
import androidx.paging.PagingSource
import com.example.core.data.repository.CharactersRemoteDataSource
import com.example.core.domain.model.Character
import com.example.marvelapp.factory.response.DataWrapperResponseFactory
import com.example.marvelapp.framework.network.response.DataWrapperResponse
import com.example.testing.MainCoroutineRule
import com.example.testing.model.CharacterFactory
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.lang.RuntimeException

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class CharactersPagingSourceTest{

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var charactersPagingSource: CharactersPagingSource

    @Mock
    private lateinit var remoteDataSource: CharactersRemoteDataSource<DataWrapperResponse>

    private var dataWrapperResponseFactory = DataWrapperResponseFactory()

    private val characterFactory = CharacterFactory()

    @Before
    fun setUp() {
        charactersPagingSource = CharactersPagingSource(remoteDataSource,"")
    }

    @Test
    fun `should return a success load result when load is called`()
    = runBlockingTest {
        //Arrange
        whenever(remoteDataSource.fetchCharacters(any()))
            .thenReturn(dataWrapperResponseFactory.create())

        //Act
        val result = charactersPagingSource.load(
            PagingSource.LoadParams.Refresh(null, 2, false)
        )


        //Assert
        val expected = listOf(
            characterFactory.create(CharacterFactory.Hero.ThreeDMan),
            characterFactory.create(CharacterFactory.Hero.ABomb),
        )

        assertEquals(
            PagingSource.LoadResult.Page(
                data = expected,
                prevKey = null,
                20
            ),
            result
        )

    }

    @Test
    fun `should return an error load result when load is called`() = runBlockingTest{
        //arrange
        val exception = RuntimeException()
        whenever(remoteDataSource.fetchCharacters(any()))
            .thenThrow(exception)
        //act
        val result = charactersPagingSource.load(
            PagingSource.LoadParams.Refresh(
                key = null, 2, false
            )
        )

        //assert
        assertEquals(
            PagingSource.LoadResult.Error<Int, Character>(exception),
            result
        )
    }
}