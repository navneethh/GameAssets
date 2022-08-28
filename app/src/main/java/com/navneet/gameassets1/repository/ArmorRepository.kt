package com.navneet.gameassets1.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.navneet.gameassets1.JsonApi
import com.navneet.gameassets1.models.Armor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public class ArmorRepository {
    private var  instance : ArmorRepository? = null
    private var armorArray :ArrayList<Armor> = ArrayList()

    val url = "https://mhw-db.com/"
    lateinit var data : MutableLiveData<List<Armor>>

    public fun getInstance() : ArmorRepository {
        if( instance == null){
            instance =  ArmorRepository()
        }
         return instance as ArmorRepository
    }

    public fun getArmorList() : MutableLiveData<List<Armor>> {
        loadArmor()
        data = MutableLiveData()
        data.value = armorArray
        return data
    }

    private fun loadArmor() {
        val retrofit = Retrofit.Builder().baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create()).build()
        val jsonApi : JsonApi = retrofit.create(JsonApi::class.java)
        val armorRemote: Call<JsonArray> = jsonApi.getArmor()
        armorRemote.enqueue( object : Callback<JsonArray> {
             override fun onResponse(call: Call<JsonArray>, response: Response<JsonArray>) {
                 if(response.isSuccessful) {
                     val output = response.body()!!.toString()
                     Log.e("from repository", output)
                 } else {
                     Log.e("Unsuccessful","response" + response.code())
                 }
             }

            override fun onFailure(call: Call<JsonArray>, t: Throwable) {
                Log.e("Error", t.message!!)

            }

        })
//        armorArray.add( Armor("Navneet","low", "34","head"))
//        armorArray.add( Armor("Second","High", "11","waist"))
//        armorArray.add( Armor("Third","Not", "34","legs"))
//        armorArray.add( Armor("Fourth","up", "45","gloves"))
//        armorArray.add( Armor("Fifth","low", "64","chest"))
    }


}