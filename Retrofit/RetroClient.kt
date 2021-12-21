package com.pinit.kotlinproject.Retrofit
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

 object RetroClient {

     private const val ROOT_URL = "https://newsapi.org/v2/"
     /**
      * Get Retrofit Instance
      */
     private fun getRetrofitInstance(): Retrofit {
         return Retrofit.Builder()
             .baseUrl(ROOT_URL)
             .addConverterFactory(GsonConverterFactory.create())
             .build() }

     fun getApiService(): Myapi? {
         return getRetrofitInstance().create(Myapi::class.java)
     }
 }
