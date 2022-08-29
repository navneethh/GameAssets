package com.navneet.gameassets1.models

import com.google.gson.JsonArray
import com.google.gson.annotations.SerializedName

data class Armor(val name: String, val rank: String, val defense: BaseDefense, val type: String, val slots: List<Slot> )

data class BaseDefense ( val base: Int)

data class Slot ( val rank : Int )
