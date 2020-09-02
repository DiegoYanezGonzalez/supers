package com.example.supers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.supers.data.HeroesEntityPojo
import com.example.supers.ui.HeroesAdapter
import com.example.supers.viewModel.HeroesViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mViewModel:HeroesViewModel
    private lateinit var listaHero:List<HeroesEntityPojo>
    private lateinit var heroAdapter:HeroesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
     listaHero = ArrayList()
        mViewModel = ViewModelProvider(this).get(HeroesViewModel::class.java)
        mViewModel.fetchFromServer()
        heroAdapter = HeroesAdapter(listaHero)
        recyclerView.adapter = heroAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        mViewModel.getDataFromDB().observe(this,{
            listaHero=it
            heroAdapter.updateData(listaHero)
        })
    }
}