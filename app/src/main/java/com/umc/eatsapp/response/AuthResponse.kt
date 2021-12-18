package com.umc.eatsapp

import com.google.gson.annotations.SerializedName
import com.umc.eatsapp.data.Storeinfo

data class AuthResult(
    @SerializedName("userIdx") val userIdx : Int,
    @SerializedName("jwt") val jwt : String,
    @SerializedName("email") val email : String?,
    @SerializedName("name") val name : String?,
    @SerializedName("phoneNum") val phoneNum : String?

)
data class AuthResponse(
    @SerializedName("result") val result : AuthResult,
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String
)


data class CatResponse(
    @SerializedName("result") val result: ArrayList<Category>,
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String,
)

data class StoreResponse(
    @SerializedName("result") val result: ArrayList<Storeinfo>,
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String,
)