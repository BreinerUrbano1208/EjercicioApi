package com.CamiloUrbano.myapplication.network
import com.CamiloUrbano.myapplication.model.DogResponse
import retrofit2.Response
import retrofit2.http.GET

interface DogApiService {
    @GET("api/breeds/image/random")
    suspend fun getRandomDog(): Response<DogResponse>
}