package com.rayray.madlevel6example.model

import com.google.gson.annotations.SerializedName

data class Trivia (

    @SerializedName("text")
    var text: String,

    @SerializedName("number")
    var int: Int,

    @SerializedName("found")
    var found: Boolean,

    @SerializedName("type")
    var type: String
)