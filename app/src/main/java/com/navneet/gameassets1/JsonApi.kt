package com.navneet.gameassets1

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.navneet.gameassets1.models.Armor
import retrofit2.Call
import retrofit2.http.GET

 public interface JsonApi {
    @GET("armor")
    fun getArmor() :Call<List<Armor>>

}