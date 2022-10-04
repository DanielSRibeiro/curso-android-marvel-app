package com.example.marvelapp.presentation.characters

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter

class CharactersLoadStateAdapter(
    private val retry: () -> Unit
) : LoadStateAdapter<CharactersLoadStateViewHolderAdapter>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ) = CharactersLoadStateViewHolderAdapter.create(parent, retry)

    override fun onBindViewHolder(
        holder: CharactersLoadStateViewHolderAdapter,
        loadState: LoadState
    ) = holder.bind(loadState)

}