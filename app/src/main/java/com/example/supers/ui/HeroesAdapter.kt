package com.example.supers.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.supers.R
import com.example.supers.data.HeroesEntityPojo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item.view.*

class HeroesAdapter(var myDataHeroes:List<HeroesEntityPojo>):
    RecyclerView.Adapter<HeroesAdapter.HeroesViewHolder>() {

    fun updateData(listaHeroes:List<HeroesEntityPojo>){
        Log.d("UPDATE","update ${listaHeroes.size}")
        myDataHeroes=listaHeroes
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
       val view = LayoutInflater.from(parent.context)
           .inflate(R.layout.list_item,parent,false)
        return HeroesViewHolder(view)
    }
    override fun getItemCount(): Int {
        return myDataHeroes.size
    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        val heros = myDataHeroes[position]
        holder.nombre.text=heros.name.toString()
        holder.id=heros.id
        Picasso.get().load(heros.imageUrl.md).into(holder.image)

    }
    //InnerClass View Holder
    class HeroesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var nombre: TextView = itemView.tvNombre
        var image :ImageView=itemView.imageView
        var id:Int=itemView.id

    }

}
