package com.example.supers.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.supers.data.HeroesEntityPojo
import com.example.supers.viewModel.HeroesRepositorio

class HeroesViewModel(application: Application):AndroidViewModel(application) {

    private val repositorio = HeroesRepositorio(application)
    private val heroesList = repositorio.passLiveDataToViewModel()

    fun fetchFromServer(){
        repositorio.fetchHeroesFromServer()
    }

    fun getDataFromDB(): LiveData<List<HeroesEntityPojo>> {
        return heroesList
    }
}