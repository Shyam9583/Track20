package com.pce.android.track20.data.network.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.pce.android.track20.data.network.interceptor.ConnectivityInterceptor
import com.pce.android.track20.data.network.response.CountryTotalResponse
import com.pce.android.track20.data.network.response.WorldStatusResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface Covid19Api {

    @GET("/summary")
    suspend fun getWorldStatus(): WorldStatusResponse

    @GET("/total/country/{countryCode}")
    suspend fun getCountryStatus(@Path("countryCode") countryCode: String): CountryTotalResponse

    companion object {
        private const val BASE_URL = "https://api.covid19api.com/"
        operator fun invoke(connectivityInterceptor: ConnectivityInterceptor): Covid19Api {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(connectivityInterceptor)
                .build()
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Covid19Api::class.java)
        }
    }
}