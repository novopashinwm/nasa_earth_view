package com.skillbox.android.nasa_earth_view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.skillbox.android.nasa_earth_view.R
import com.skillbox.android.nasa_earth_view.data.PhotoDTO
import com.skillbox.android.nasa_earth_view.other.inflate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_photo.*

class ListPhotosAdapterDelegate(
    private val onItemClick: (position: Int) -> Unit
) :
    AbsListItemAdapterDelegate<PhotoDTO, PhotoDTO, ListPhotosAdapterDelegate.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup): Holder {
        return Holder(
            parent.inflate(R.layout.item_photo),
            onItemClick
        )
    }

    override fun isForViewType(
        item: PhotoDTO,
        items: MutableList<PhotoDTO>,
        position: Int
    ): Boolean {
        return true
    }

    override fun onBindViewHolder(item: PhotoDTO, holder: Holder, payloads: MutableList<Any>) {
        holder.bind(item)
    }

    class Holder(
        override val containerView: View,
        onItemClick: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        init {
            containerView.setOnClickListener {
                onItemClick(adapterPosition)
                true
            }
        }

        fun bind(item: PhotoDTO) {
            txtDateValue.text = item.date.toString()
            Glide.with(itemView.context)
                .load(item.ImageUrl())
                .override(100,100)
                .error(R.drawable.ic_baseline_image_not_supported)
                .placeholder(R.drawable.ic_baseline_photo_size_select_actual)
                .into(avatarImageView)
        }
    }
}