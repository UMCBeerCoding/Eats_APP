package com.umc.eatsapp.`Interface`

import com.umc.eatsapp.AuthResponse
import com.umc.eatsapp.CatResponse
import com.umc.eatsapp.StoreResponse
import com.umc.eatsapp.data.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthRetrofitInterface {

    @POST("/app/users/sign-up")
    fun register(@Body user: User): Call<AuthResponse>

    @POST("/app/users/login")
    fun login(@Body user : User): Call<AuthResponse>

    @GET("/app/stores/categories")
    fun category(): Call<CatResponse>

    @GET("/app/stores/reco")
    fun store(@Query("type") type: String): Call<StoreResponse>
}