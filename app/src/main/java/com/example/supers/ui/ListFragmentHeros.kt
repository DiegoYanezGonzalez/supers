package com.example.supers.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.supers.R
import com.example.supers.data.HeroesEntityPojo
import com.example.supers.viewModel.HeroesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_list_heros.*


class ListFragmentHeros : Fragment() {
    private lateinit var mViewModel: HeroesViewModel
    private lateinit var listaHero:List<HeroesEntityPojo>
    private lateinit var heroAdapter:HeroesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list_heros, container, false)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listaHero = ArrayList()
        mViewModel = ViewModelProvider(this).get(HeroesViewModel::class.java)
        mViewModel.fetchFromServer()
        heroAdapter = HeroesAdapter(listaHero)
        recyclerView.adapter = heroAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        mViewModel.getDataFromDB().observe(viewLifecycleOwner,{
            //Log.d("datos",it.toString())
            listaHero=it
            heroAdapter.updateData(listaHero)
        })
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListFragmentHeros().apply {
                arguments = Bundle().apply {
                }
            }
    }
}