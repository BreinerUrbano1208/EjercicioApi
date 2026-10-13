package com.CamiloUrbano.myapplication.network
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val apiService: DogApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://dog.ceo/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DogApiService::class.java)
    }
}