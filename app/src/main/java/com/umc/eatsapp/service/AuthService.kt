package com.umc.eatsapp.service

import android.util.Log
import com.umc.eatsapp.AuthResponse
import com.umc.eatsapp.Interface.AuthRetrofitInterface
import com.umc.eatsapp.data.User
import com.umc.eatsapp.getRetrofit
import com.umc.eatsapp.serviceView.LoginView
import com.umc.eatsapp.serviceView.RegisterView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthService {

    private lateinit var registerView : RegisterView
    private lateinit var loginView : LoginView

    private val AuthService = getRetrofit().create(AuthRetrofitInterface::class.java)

    fun setRegisterView(registerView : RegisterView){
        this.registerView = registerView
    }
    fun setLoginView(loginView : LoginView){
        this.loginView = loginView
    }

    fun register(user: User){

        registerView.onRegisterLoading()

        AuthService.register(user).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                val signUpResponse: AuthResponse = response.body()!!
                Log.e("SignUP/API", signUpResponse.toString())

                when (signUpResponse.code) {
                    1000 -> {
                        registerView.onRegisterSucces()
                    }
                    else -> registerView.onRegisterFailure(signUpResponse.code, signUpResponse.message)
                }
            }
            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                registerView.onRegisterFailure(400, t.message.toString())
            }
        })
    }

    fun login(user : User){
        loginView.onLoginLoading()

        AuthService.login(user).enqueue(object: Callback<AuthResponse> {

            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {

                val LoginResponse: AuthResponse = response.body()!!

                Log.e("LOGIN/API",LoginResponse.toString())

                when(LoginResponse.code){
                    1000 -> loginView.onLoginSuccess(LoginResponse.result!!)
                    else -> loginView.onLoginFailure(LoginResponse.code, LoginResponse.message)
                }
            }
            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                loginView.onLoginFailure(400, t.message.toString())
            }

        })
    }

}