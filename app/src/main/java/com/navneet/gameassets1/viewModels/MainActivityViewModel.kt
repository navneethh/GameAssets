package com.navneet.gameassets1.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.navneet.gameassets1.models.Armor
import com.navneet.gameassets1.repository.ArmorRepository

class MainActivityViewModel : ViewModel(){
    private var armorList : MutableLiveData<List<Armor>> = MutableLiveData()

    fun init() {
        if(armorList.value!= null){
            Log.e("from mainactivityViewModel", "Data reloading stopped")
            return
        }
        val armorRepository  = ArmorRepository()
        val mRepo = armorRepository.getInstance()
        armorList = mRepo.getArmorList()

    }

//    returns armorList to mainactivity as RecycerView Dataset
    fun getArmorList(): LiveData<List<Armor>> {
        return armorList
    }

}