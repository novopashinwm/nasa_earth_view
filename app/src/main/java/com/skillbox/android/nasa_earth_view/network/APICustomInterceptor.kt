package com.skillbox.android.nasa_earth_view.network
import okhttp3.Interceptor
import okhttp3.Response

class APICustomInterceptor : Interceptor {
    override fun intercept(chain : Interceptor.Chain) : Response {
        val originalRequest = chain.request()
        val originalURL = originalRequest.url
        val modifiedURL = originalURL.newBuilder()

            .addQueryParameter("api_key", NasaService.KEY)
            .build()
        val modifiedRequest = originalRequest.newBuilder()
            .url(modifiedURL)
            .build()
        val response = chain.proceed(modifiedRequest)
        return response
    }
}