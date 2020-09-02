package com.example.supers.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities=[HeroesEntityPojo::class],version=1,exportSchema=false)
abstract class HeroesRoomDataBase:RoomDatabase() {
    //acceder a los datos
    abstract fun heroesDao():HeoesDao

    companion object{
        @Volatile
        private var INSTANCE:HeroesRoomDataBase?=null


        fun getData(context: Context):HeroesRoomDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            kotlin.synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, HeroesRoomDataBase::class.java, "appDataBase").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}