package com.umc.eatsapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.umc.eatsapp.data.User

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

fun saveUserinfo(context : Context, user : User){
    val spf = context.getSharedPreferences("user",AppCompatActivity.MODE_PRIVATE)
    val editor = spf.edit()
    editor.putString("name",user.name)
    editor.putString("phonenumber",user.phoneNum)
    editor.apply()
}

fun getUserinfo(context: Context) : User{
    val spf = context.getSharedPreferences("user",AppCompatActivity.MODE_PRIVATE)
    val name = spf.getString("name","")!!
    val phone = spf.getString("phonenumber","")!!
    return User("","",name,phone)
}