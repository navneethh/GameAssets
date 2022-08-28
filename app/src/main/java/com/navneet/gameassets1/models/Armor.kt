package com.navneet.gameassets1.models

import com.google.gson.annotations.SerializedName

data class Armor(val name: String, val rank: String, @SerializedName("id") val BaseDefense: String, val type: String )