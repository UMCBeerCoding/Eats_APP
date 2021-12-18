package com.umc.eatsapp.serviceView

interface RegisterView {
    fun onRegisterLoading()
    fun onRegisterSucces()
    fun onRegisterFailure(code : Int, message : String)
}