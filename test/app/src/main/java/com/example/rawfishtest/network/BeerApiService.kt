package com.example.rawfishtest.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.punkapi.com/v2/"

//creates a moshi object, needed to coordinate JSON values and java objects
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

//create a retrofit, using the moshi converter, passing the base URL as target to be converted
private val retrofit =
    Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

interface BeerApiService {
    @GET("beers")
    suspend fun getBeers(): List<BeerModel>
}

//since the retrofit service is set as private, expose it through this object
object BeerApi {
    val retrofitService: BeerApiService by lazy { retrofit.create(BeerApiService::class.java) }
}