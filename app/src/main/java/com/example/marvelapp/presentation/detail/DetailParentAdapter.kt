package com.example.marvelapp.presentation.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.marvelapp.databinding.ItemParentDetailBinding
import com.example.marvelapp.framework.imageloader.ImageLoader

class DetailParentAdapter(
    private val detailParentList: List<DetailParentVE>,
    private val imageLoader: ImageLoader
) : RecyclerView.Adapter<DetailParentAdapter.DetailParentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailParentViewHolder {
        return DetailParentViewHolder.create(parent, imageLoader)
    }

    override fun onBindViewHolder(holder: DetailParentViewHolder, position: Int) {
        holder.bind(detailParentList[position])
    }

    override fun getItemCount(): Int = detailParentList.size

    class DetailParentViewHolder(
        private val itemBinding: ItemParentDetailBinding,
        private val imageLoader: ImageLoader
    ) : ViewHolder(itemBinding.root) {

        private val recyclerChildDetail = itemBinding.recyclerChildDetail
        private val textItemCategory = itemBinding.textItemCategory

        fun bind(detailParentList: DetailParentVE) {
            textItemCategory.text = itemView.context.getString(detailParentList.categoryStringResId)

            recyclerChildDetail.apply {
                scrollToPosition(0)
                setHasFixedSize(true)
                adapter = DetailChildAdapter(detailParentList.detailChildList, imageLoader)
            }
        }

        companion object {
            fun create(
                parent: ViewGroup,
                imageLoader: ImageLoader
            ): DetailParentViewHolder {
                val itemBinding = ItemParentDetailBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
                return DetailParentViewHolder(itemBinding, imageLoader)
            }
        }
    }

}