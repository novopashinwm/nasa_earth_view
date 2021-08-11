package com.skillbox.android.nasa_earth_view.network

import com.skillbox.android.nasa_earth_view.data.DateDTO
import com.skillbox.android.nasa_earth_view.data.PhotoDTO
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface NasaAPI {
    @GET("natural/all")
    fun getDatesWithPhoto() : Single<List<DateDTO>>

    @GET("natural/date/{date}")
    fun getPhotosForDate(@Path("date") date : String) : Single<List<PhotoDTO>>

}