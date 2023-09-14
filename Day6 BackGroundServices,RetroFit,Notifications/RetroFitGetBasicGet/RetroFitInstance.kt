package com.example.retrofitdemo

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroFitInstance {
    companion object{
        val BASE_URL="https://jsonplaceholder.typicode.com/"
        fun getRestroFitInstance():Retrofit{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }

    }
}