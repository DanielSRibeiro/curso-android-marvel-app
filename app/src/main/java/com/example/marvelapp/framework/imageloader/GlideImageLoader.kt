package com.example.marvelapp.framework.imageloader

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import javax.inject.Inject

class GlideImageLoader @Inject constructor() : ImageLoader {

    override fun load(
        imageView: ImageView,
        imageUrl: String,
        @DrawableRes placeholder: Int,
        @DrawableRes fallback: Int
    ) {
        Glide.with(imageView)
            .load(imageUrl)
            .fallback(fallback)
            .placeholder(placeholder)
            .into(imageView)
    }
}