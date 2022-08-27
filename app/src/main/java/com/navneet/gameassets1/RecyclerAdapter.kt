package com.navneet.gameassets1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.navneet.gameassets1.models.Armor

class RecyclerAdapter(private val armourList:List<Armor>) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = armourList[position].name
        holder.slots.text = armourList[position].type
        holder.rank.text = armourList[position].rank
    }

    override fun getItemCount(): Int {
        return armourList.size
    }



    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.armor_name)
        val slots: TextView = itemView.findViewById(R.id.slots)
        val rank: TextView = itemView.findViewById(R.id.rank)
    }
}