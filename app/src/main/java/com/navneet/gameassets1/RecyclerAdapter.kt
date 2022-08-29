package com.navneet.gameassets1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.navneet.gameassets1.models.Armor

class RecyclerAdapter(private var armorList:ArrayList<Armor>) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = armorList[position].name
        holder.rank.text = armorList[position].rank.uppercase()
        setTypeImage(armorList[position].type, holder.type)
        val baseString =  armorList[position].defense.base.toString()+"+"
        holder.baseDefense.text = baseString


//        using brute force method to show SLOTS details if present. It no data is present then make it invisible, it may be improved further

        if (armorList[position].slots.size > 2) {
            holder.slots1.text = armorList[position].slots[0].rank.toString()
            holder.slots2.text = armorList[position].slots[1].rank.toString()
            holder.slots3.text = armorList[position].slots[2].rank.toString()
            holder.slots1.visibility = View.VISIBLE
            holder.slots2.visibility = View.VISIBLE
            holder.slots3.visibility = View.VISIBLE
        } else if (armorList[position].slots.size > 1) {
            holder.slots1.text = armorList[position].slots[0].rank.toString()
            holder.slots2.text = armorList[position].slots[1].rank.toString()
            holder.slots1.visibility = View.VISIBLE
            holder.slots2.visibility = View.VISIBLE
            holder.slots3.visibility = View.INVISIBLE
        } else if (armorList[position].slots.isNotEmpty()) {
            holder.slots1.text = armorList[position].slots[0].rank.toString()
            holder.slots1.visibility = View.VISIBLE
            holder.slots2.visibility = View.INVISIBLE
            holder.slots3.visibility = View.INVISIBLE
        } else {
            holder.slots1.visibility = View.INVISIBLE
            holder.slots2.visibility = View.INVISIBLE
            holder.slots3.visibility = View.INVISIBLE
        }
    }

    override fun getItemCount(): Int {
        return armorList.size
    }

    //    a Switch case function to set icons of armor TYPE to ImageView
    private fun setTypeImage(type: String, type1: ImageView ) {
        when(type){
            "chest" -> type1.setImageResource(R.drawable.ic_chest)
            "gloves" -> type1.setImageResource(R.drawable.ic_gloves)
            "head" -> type1.setImageResource(R.drawable.ic_head)
            "legs" -> type1.setImageResource(R.drawable.ic_legs)
            "waist" -> type1.setImageResource(R.drawable.ic_waist)
        }
    }
    // for refreshing ArmorList from mainActivity
    fun refreshRecycler(newList: ArrayList<Armor>) {
        armorList = newList
        notifyDataSetChanged()
    }

//    for filtering of ArmorList by string provided by user
    fun filterRecycler(input: String) {
         val newList: ArrayList<Armor> = ArrayList()
         for (arrayList in armorList) {
           if (arrayList.name.lowercase().contains(input.lowercase())) {
            newList.add(arrayList)
        }
        armorList = newList
        notifyDataSetChanged()
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.armor_name)
        val slots1: TextView = itemView.findViewById(R.id.slot1)
        val slots2: TextView = itemView.findViewById(R.id.slot2)
        val slots3: TextView = itemView.findViewById(R.id.slot3)
        val rank: TextView = itemView.findViewById(R.id.rank)
        val type: ImageView = itemView.findViewById(R.id.type)
        val baseDefense: TextView = itemView.findViewById(R.id.base_defense)
    }
}