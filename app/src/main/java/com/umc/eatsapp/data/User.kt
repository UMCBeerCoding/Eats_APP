package com.umc.eatsapp.data

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName(value = "email") val email : String,
    @SerializedName(value = "password") val password : String,
    @SerializedName(value = "name") val name : String?,
    @SerializedName(value = "phoneNum") val phoneNum : String?
    ){
}