package com.umc.eatsapp.service

import android.util.Log
import com.umc.eatsapp.CatResponse
import com.umc.eatsapp.Interface.AuthRetrofitInterface
import com.umc.eatsapp.StoreResponse
import com.umc.eatsapp.getRetrofit
import com.umc.eatsapp.serviceView.CatView
import com.umc.eatsapp.serviceView.StoreView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StoreService {
    private lateinit var catView : CatView
    private lateinit var storeView : StoreView

    private val StoreService = getRetrofit().create(AuthRetrofitInterface::class.java)

    fun setCatView(catView : CatView){
        this.catView = catView
    }
    fun setStoreView(storeView : StoreView){
        this.storeView = storeView
    }

    fun category(){

        catView.onCatLoading()

        StoreService.category().enqueue(object : Callback<CatResponse> {
            override fun onResponse(call: Call<CatResponse>, response: Response<CatResponse>) {
                val catResponse : CatResponse = response.body()!!

                when(catResponse.code){
                    1000-> catView.onCatSuccess(catResponse.result!!)
                    else->catView.onCatFailure(catResponse.code, catResponse.message)
                }
            }

            override fun onFailure(call: Call<CatResponse>, t: Throwable) {
                catView.onCatFailure(400,t.message.toString())
            }
        })
    }

    fun store(type : String){
        storeView.onStoreLoading()

        StoreService.store(type).enqueue(object: Callback<StoreResponse> {

            override fun onResponse(call: Call<StoreResponse>, response: Response<StoreResponse>) {

                val storeResponse: StoreResponse = response.body()!!

                Log.e("LOGIN/API",storeResponse.toString())

                when(storeResponse.code){
                    1000 -> storeView.onStoreSuccess(storeResponse.result!!)
                    else -> storeView.onStoreFailure(storeResponse.code, storeResponse.message)
                }
            }
            override fun onFailure(call: Call<StoreResponse>, t: Throwable) {
                storeView.onStoreFailure(400, t.message.toString())
            }

        })
    }
}