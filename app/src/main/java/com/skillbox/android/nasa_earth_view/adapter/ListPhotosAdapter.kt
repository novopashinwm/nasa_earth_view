package com.skillbox.android.nasa_earth_view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.skillbox.android.nasa_earth_view.data.PhotoDTO

class ListPhotosAdapter( onItemClick: (position: Int) -> Unit )
    : AsyncListDifferDelegationAdapter<PhotoDTO>(
    UserDiffUtilCallback()) {
    init {
        delegatesManager.addDelegate(ListPhotosAdapterDelegate(onItemClick))
    }

    class UserDiffUtilCallback : DiffUtil.ItemCallback<PhotoDTO>() {
        override fun areItemsTheSame(oldItem: PhotoDTO, newItem: PhotoDTO): Boolean {
            return oldItem.date == newItem.date
        }

        override fun areContentsTheSame(oldItem: PhotoDTO, newItem: PhotoDTO): Boolean {
            return oldItem == newItem
        }
    }
}