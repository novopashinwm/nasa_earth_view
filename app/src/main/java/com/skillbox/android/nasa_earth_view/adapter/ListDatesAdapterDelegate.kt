package com.skillbox.android.nasa_earth_view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.skillbox.android.nasa_earth_view.R
import com.skillbox.android.nasa_earth_view.data.DateDTO
import com.skillbox.android.nasa_earth_view.other.inflate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_date.*

class ListDatesAdapterDelegate(
    private val onItemClick: (position: Int) -> Unit
) :
    AbsListItemAdapterDelegate<DateDTO, DateDTO, ListDatesAdapterDelegate.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup): Holder {
        return Holder(
            parent.inflate(R.layout.item_date),
            onItemClick
        )
    }

    override fun isForViewType(
        item: DateDTO,
        items: MutableList<DateDTO>,
        position: Int
    ): Boolean {
        return true
    }

    override fun onBindViewHolder(item: DateDTO, holder: Holder, payloads: MutableList<Any>) {
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

        fun bind(item: DateDTO) {

            txtOneOfDates.text = item.date.toString()

        }
    }
}
