package com.skillbox.android.nasa_earth_view.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
object NasaAPIClient {
    private const val BASE_URL = "https://api.nasa.gov/EPIC/api/"

    private var client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(APICustomInterceptor())
        .addInterceptor(HttpLoggingInterceptor(CustomHttpLogging()).apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    val apiClient: NasaAPI by lazy  {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return@lazy retrofit.create(NasaAPI::class.java)
    }
}

