package com.example.marvelapp.presentation.characters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.core.domain.model.Character
import com.example.marvelapp.R
import com.example.marvelapp.databinding.ItemCharacterBinding
import com.example.marvelapp.framework.imageloader.ImageLoader
import com.example.marvelapp.util.OnCharacterItemClick

class CharactersViewHolder(
    itemCharacterBinding: ItemCharacterBinding,
    private val onItemClick: OnCharacterItemClick,
    private val imageLoader: ImageLoader
) : RecyclerView.ViewHolder(itemCharacterBinding.root) {

    private val textName = itemCharacterBinding.textName
    private val imageCharacter = itemCharacterBinding.imageCharacter

    fun bind(character: Character) {
        textName.text = character.name
        imageCharacter.transitionName = character.name
        imageLoader.load(
            imageView = imageCharacter,
            imageUrl = character.imageUrl,
            fallback = R.drawable.ic_img_loading_error
        )

        itemView.setOnClickListener {
            onItemClick(character, imageCharacter)
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            onItemClick: OnCharacterItemClick,
            imageLoader: ImageLoader,
        ): CharactersViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val itemCharacterBinding = ItemCharacterBinding.inflate(inflater, parent, false)
            return CharactersViewHolder(itemCharacterBinding, onItemClick, imageLoader)
        }
    }
}