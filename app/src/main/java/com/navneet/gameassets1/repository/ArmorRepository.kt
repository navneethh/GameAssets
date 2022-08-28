package com.navneet.gameassets1.repository

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.navneet.gameassets1.JsonApi
import com.navneet.gameassets1.MainActivity
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

//    downloading data using retrofit Api
    private fun loadArmor() {
        val retrofit = Retrofit.Builder().baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create()).build()
        val jsonApi : JsonApi = retrofit.create(JsonApi::class.java)
        val armorRemote: Call<List<Armor>> = jsonApi.getArmor()
        armorRemote.enqueue( object : Callback<List<Armor>> {

            override fun onResponse(call: Call<List<Armor>>, response: Response<List<Armor>>) {
                if(response.isSuccessful) {
//                    value intialization after receiving form Url
                    data.postValue(response.body())
                    Log.e("Value of Data", data.value.toString())


                } else {
                    Log.e("Unsuccessful","response" + response.code())
                }
            }

            override fun onFailure(call: Call<List<Armor>>, t: Throwable) {
                Log.e("Error", t.message!!)
            }

        })
    }


}