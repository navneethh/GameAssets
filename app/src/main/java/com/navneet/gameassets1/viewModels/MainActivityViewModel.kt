package com.navneet.gameassets1.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.navneet.gameassets1.models.Armor

class MainActivityViewModel : ViewModel(){
    private var armorList : MutableLiveData<List<Armor>> = MutableLiveData()
    private var  armorArray: ArrayList<Armor> = ArrayList()

    fun init() {
        if(armorList.value!= null){
            Log.e("from mainactivityViewModel", "Data reloading stopped")
            return
        }
        loadArmorList()
        armorList.value= armorArray
    }

    private fun loadArmorList() {
        armorArray.add( Armor("Navneet","low", "34","better"))
        armorArray.add( Armor("Second","High", "11","jetter"))
        armorArray.add( Armor("Third","Not", "34","setter"))
        armorArray.add( Armor("Fourth","up", "45","getter"))
        armorArray.add( Armor("Fifth","low", "64","butter"))

    }

    fun getArmorList(): LiveData<List<Armor>> {

        return armorList
    }

}