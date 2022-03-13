package com.limitless.moansports.services

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServicesBuilder {
    private const val BASE_URL = "https://api.football-data.org/v2/"
    private const val API_KEY = "04e47f6e20824802a4463deba609764b"

    private val interceptor = Interceptor{ chain ->
        val url = chain.request().url().newBuilder().addQueryParameter("apiKey", API_KEY).build()
        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()
        chain.proceed(request)
    }
//    private val logger = HttpLoggingInterceptor()
//        .setLevel(HttpLoggingInterceptor.Level.BODY)

    private val builder = OkHttpClient.Builder()
        .addInterceptor(interceptor)

    private val retrofitBuilder = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(builder.build())

    private val retrofit = retrofitBuilder.build()

    val competitionsApi: CompetitionsServices = retrofit.create(CompetitionsServices::class.java)
//    fun <S> buildService(serviceType: CompetitionsServices::class.java): Competition {
//        return retrofit.create(serviceType)
//    }
}