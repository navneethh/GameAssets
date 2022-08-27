package com.navneet.gameassets1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.navneet.gameassets1.Models.Armor

class RecyclerAdapter(private val armourList:List<Armor>) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
            return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.name.text  = armourList.get(position).name;
        holder.slots.text  = armourList.get(position).type;
        holder.rank.text  = armourList.get(position).rank;

    }

    override fun getItemCount(): Int {
        return armourList.size
    }



    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {




        val name = itemView.findViewById<TextView>(R.id.armor_name)
        val slots = itemView.findViewById<TextView>(R.id.slots)
        val rank = itemView.findViewById<TextView>(R.id.rank)


    }
}