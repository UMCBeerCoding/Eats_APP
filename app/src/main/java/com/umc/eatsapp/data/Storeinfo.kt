package com.umc.eatsapp.data

data class Storeinfo(
    var storeIdx : Int,
    var storeName : String,
    var rating : Float,
    var reviewNum : Int,
    var distance : String,
    var deliverTip : String,
    var deliveryTime : Boolean,
    var storeImg : String
)
