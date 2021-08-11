package com.skillbox.android.nasa_earth_view.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.skillbox.android.nasa_earth_view.R
import com.skillbox.android.nasa_earth_view.data.DateDTO
import com.skillbox.android.nasa_earth_view.network.NasaAPIClient
import com.skillbox.android.nasa_earth_view.ui.ListDates.ListDatesFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            /*supportFragmentManager
                .beginTransaction()
                .add(R.id.container, ListDatesFragment())
                .commit()*/
        }

    }


}

   /* lateinit var recycler : RecyclerView
    private lateinit var adapter : Adapter
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var layoutManager = GridLayoutManager(this, 2)
        recycler = findViewById(R.id.list)
        recycler.layoutManager = layoutManager

        adapter = Adapter()
        recycler.adapter = adapter
        NasaAPIClient.apiClient.getDatesWithPhoto()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe { list, err ->
                Timber.log(1,list.toString())
                adapter.setDates(list)
            }


    }
    private class Adapter : RecyclerView.Adapter<ViewHolder>() {
        var dates = ArrayList<DateDTO>()
        fun setDates(list : List<DateDTO>) {
            dates.clear()
            dates.addAll(list)
            notifyDataSetChanged()
        }


        override fun onCreateViewHolder(viewGroup : ViewGroup, i : Int) : ViewHolder {
            return ViewHolder(
                LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.item_date, viewGroup, false)
            )
        }

        override fun onBindViewHolder(viewHolder : ViewHolder, i : Int) {
            viewHolder.bind(dates[i])
        }

        override fun getItemCount() : Int {
            return dates.size
        }
    }

    private class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var dateDTO : DateDTO? = null
        var text : TextView
        fun bind(date : DateDTO) {
            dateDTO = date
            text.setText(date.date)
        }

        init {
            text = itemView.findViewById(R.id.text)
            itemView.setOnClickListener { view ->
                /*PhotoListActivity.start(
                    view.context,
                    dateDTO.getDate()
                )*/
                NasaAPIClient.apiClient.getPhotosForDate(dateDTO!!.date)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe { list, err ->
                        Timber.log(1,list.toString())
                        Log.i("MainActivity", list.toString())
                    }
            }
        }
    }*/


