package com.skillbox.android.nasa_earth_view.other

import com.skillbox.android.nasa_earth_view.data.DateDTO
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

fun Single<List<DateDTO>>.init(): Single<List<DateDTO>> {
    return this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnError { t -> Timber.e(t.toString()) }
}