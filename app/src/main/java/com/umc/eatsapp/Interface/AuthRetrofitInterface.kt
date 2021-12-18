package com.umc.eatsapp.`interface`

import android.telecom.Call
import com.umc.eatsapp.AuthResponse
import com.umc.eatsapp.data.User
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthRetrofitInterface {

    @POST("/app/users/sign-up")
    fun signUp(@Body user : User) : Call<AuthResponse>
}