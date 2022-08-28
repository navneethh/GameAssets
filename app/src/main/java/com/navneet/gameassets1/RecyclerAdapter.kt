package com.navneet.gameassets1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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
        holder.baseDefense.text = armourList[position].BaseDefense
        holder.rank.text = armourList[position].rank
        setTypeImage(armourList[position].type, holder.type)
    }

    private fun setTypeImage(type: String, type1: ImageView ) {
        when(type){
            "chest" -> type1.setImageResource(R.drawable.ic_chest)
            "gloves" -> type1.setImageResource(R.drawable.ic_gloves)
            "head" -> type1.setImageResource(R.drawable.ic_head)
            "legs" -> type1.setImageResource(R.drawable.ic_legs)
            "waist" -> type1.setImageResource(R.drawable.ic_waist)


        }

    }

    override fun getItemCount(): Int {
        return armourList.size
    }



    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.armor_name)
        val slots: TextView = itemView.findViewById(R.id.slots)
        val rank: TextView = itemView.findViewById(R.id.rank)
        val type: ImageView = itemView.findViewById(R.id.type)
        val baseDefense: TextView = itemView.findViewById(R.id.base_defense)
    }
}