package com.umc.eatsapp

import com.google.gson.annotations.SerializedName

data class result(
    @SerializedName("userIdx") val userIdx : Int,
    @SerializedName("jwt") val jwt : String
)
data class auth(
    @SerializedName("result") val result : result?,
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String
)