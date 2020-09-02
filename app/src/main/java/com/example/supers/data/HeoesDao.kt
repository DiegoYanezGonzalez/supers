package com.example.supers.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface HeoesDao {

    @Query("SELECT * FROM Super_Heroes_Table")
    fun getAllSuperHeroes():LiveData<List<HeroesEntityPojo>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllSuperHeroesInDb(listHero:List<HeroesEntityPojo>)

    @Update
    fun update(superHeroesEntityPojo: HeroesEntityPojo)

    @Delete
    fun deleteSuperHero(superHeroesEntityPojo: HeroesEntityPojo)


}