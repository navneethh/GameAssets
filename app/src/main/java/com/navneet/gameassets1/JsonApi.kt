package com.navneet.gameassets1

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

 public interface JsonApi {
    @GET("armor")
    fun getArmor() :Call<JsonArray>

}