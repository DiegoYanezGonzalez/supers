package com.example.supers.remote



import com.example.supers.data.HeroesEntityPojo
import retrofit2.Call
import retrofit2.http.GET

interface Api{
    @GET("all.json")
     fun getAllHeroes(): Call<List<HeroesEntityPojo>>




}