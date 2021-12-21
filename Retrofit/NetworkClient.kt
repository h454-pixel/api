package com.pinit.kotlinproject.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient

object NetworkClient {
    private var retrofit: Retrofit? = null
    private val BASE_URL = "https://newsapi.org/v2/"

    fun getRetrofit(): Retrofit? {
        val okHttpClient = OkHttpClient.Builder().build()
        if (retrofit == null) {
            retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build()
        }
        return retrofit
    }
}