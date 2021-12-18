package com.umc.eatsapp.serviceView

import com.umc.eatsapp.AuthResult

interface LoginView {
    fun onLoginLoading()
    fun onLoginSuccess(auth: AuthResult)
    fun onLoginFailure(code : Int, message : String)
}