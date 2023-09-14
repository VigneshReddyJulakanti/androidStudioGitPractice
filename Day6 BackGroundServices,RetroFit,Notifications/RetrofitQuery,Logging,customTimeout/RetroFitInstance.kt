package com.example.retrofitdemo

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetroFitInstance {
    companion object{
        val BASE_URL="https://jsonplaceholder.typicode.com/"


        val interceptor=HttpLoggingInterceptor().apply {
            this.level=HttpLoggingInterceptor.Level.BODY
        }

        val client=OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)

//The below 3 lines are needed if we want to set custom timeouts
                .connectTimeout(30,TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .writeTimeout(25,TimeUnit.SECONDS)
        }.build()
        fun getRestroFitInstance():Retrofit{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }

    }
}