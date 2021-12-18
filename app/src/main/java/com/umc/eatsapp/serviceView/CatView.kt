package com.umc.eatsapp.serviceView

import com.umc.eatsapp.Category

interface CatView {
    fun onCatLoading()
    fun onCatSuccess(cats: ArrayList<Category>)
    fun onCatFailure(code : Int, message : String)
}