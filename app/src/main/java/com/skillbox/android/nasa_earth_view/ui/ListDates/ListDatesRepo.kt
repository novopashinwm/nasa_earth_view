package com.skillbox.android.nasa_earth_view.ui.ListDates

import com.skillbox.android.nasa_earth_view.network.NasaAPIClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListDatesRepo {
    suspend fun getDates()  = NasaAPIClient.apiClient.getDatesWithPhoto()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())

    suspend fun getPhotosForDate(sDate:String)
        = NasaAPIClient.apiClient.getPhotosForDate(sDate)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
}