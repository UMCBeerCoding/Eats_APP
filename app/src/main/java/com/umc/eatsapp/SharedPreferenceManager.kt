package com.umc.eatsapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

fun saveJwt(context : Context, jwt : String){
    val spf = context.getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE)
    val editor = spf.edit()
    editor.putString("jwt",jwt)
    editor.apply()
}

fun getJwt(context : Context) : String{
    val spf = context.getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE)
    return spf.getString("jwt","")!!
}