package com.umc.eatsapp

interface RegisterView {
    fun onRegisterLoading()
    fun onRegisterSucces()
    fun onRegisterFailure(code : Int, message : String)
}