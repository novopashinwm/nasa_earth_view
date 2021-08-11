package com.skillbox.android.nasa_earth_view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.skillbox.android.nasa_earth_view.data.DateDTO

class ListDatesAdapter( onItemClick: (position: Int) -> Unit )
    : AsyncListDifferDelegationAdapter<DateDTO>(
    UserDiffUtilCallback()) {
    init {
        delegatesManager.addDelegate(ListDatesAdapterDelegate(onItemClick))
    }

    class UserDiffUtilCallback : DiffUtil.ItemCallback<DateDTO>() {
        override fun areItemsTheSame(oldItem: DateDTO, newItem: DateDTO): Boolean {
            return oldItem.date == newItem.date
        }

        override fun areContentsTheSame(oldItem: DateDTO, newItem: DateDTO): Boolean {
            return oldItem == newItem
        }
    }
}