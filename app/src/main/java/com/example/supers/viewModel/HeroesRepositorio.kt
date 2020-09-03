package com.example.supers.viewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.supers.data.HeroesRoomDataBase
import com.example.supers.data.HeroesEntityPojo
import com.example.supers.remote.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroesRepositorio(context:Context) {

    private val tag = "HeroesRepo"

    private val dbHero: HeroesRoomDataBase = HeroesRoomDataBase.getData(context)
    private val heroesList = dbHero.heroesDao().getAllSuperHeroes()

    fun passLiveDataToViewModel(): LiveData<List<HeroesEntityPojo>> {
        return heroesList
    }

//    suspend fun getAll()=RetrofitClient.retrofitInstance().getAllHeroes()

    fun insertSuperFromNet(){
        CoroutineScope(IO).launch {
         //   dbHero.heroesDao().insertAllSuperHeroesInDb(getAll())
        }
    }
    fun fetchHeroesFromServer() {
        val service = RetrofitClient.retrofitInstance()
        val call = service.getAllHeroes()

        call.enqueue(object : Callback<List<HeroesEntityPojo>> {
            override fun onResponse(
                call: Call<List<HeroesEntityPojo>>,
                response: Response<List<HeroesEntityPojo>>
            ) {
                Log.d("superdato",response.body().toString())
                CoroutineScope(Dispatchers.IO).launch {
                    response.body()?.let { dbHero.heroesDao().insertAllSuperHeroesInDb(response.body()!!) }
                }
            }

            override fun onFailure(call: Call<List<HeroesEntityPojo>>, t: Throwable) {
                Log.d(tag, t.message.toString())
            }

        })

    }
}
