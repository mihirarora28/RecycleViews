package com.example.recycleviews

import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CityAdapter(private val listener: (city) -> Unit) : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    var list =  arrayOf<city>()
    set(value){
        if(value!=null){
            field = value;
            notifyDataSetChanged();
        }
    }

   inner class CityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val flagid: ImageView = view.findViewById(R.id.flags);
        val country:TextView = view.findViewById(R.id.country);
        val city:TextView =  view.findViewById(R.id.captial);
        init {
            itemView.setOnClickListener{
                listener.invoke(list[adapterPosition]);
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
       var xx = LayoutInflater.from(parent.context).inflate(R.layout.item, parent,false);
        return CityViewHolder(xx);
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        with(holder){
            flagid.setImageResource(list[position].flag);
            country.text = list[position].Country
            city.text = list[position].City;
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}