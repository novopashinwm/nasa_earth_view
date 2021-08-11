package com.skillbox.android.nasa_earth_view.network

import android.util.Log
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.google.gson.JsonSyntaxException
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

class CustomHttpLogging : HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
        if (!message.startsWith("{") || !message.startsWith("[")) {
            Log.d("CustomHTTP",message)
            return
        }
        try {
            val prettyPrintJson = GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(JsonParser().parse(message))
            Log.d("CustomHTTP", prettyPrintJson)
        } catch (m: JsonSyntaxException) {
            Log.d("CustomHTTP",message)
        }
    }
}