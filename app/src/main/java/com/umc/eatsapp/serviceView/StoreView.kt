package com.umc.eatsapp.serviceView

import com.umc.eatsapp.data.Storeinfo

interface StoreView {
    fun onStoreLoading()
    fun onStoreSuccess(stores : ArrayList<Storeinfo>)
    fun onStoreFailure(code : Int, message : String)
}