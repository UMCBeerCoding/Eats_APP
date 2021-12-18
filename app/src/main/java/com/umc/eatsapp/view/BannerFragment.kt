package com.umc.eatsapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.umc.eatsapp.databinding.FragmentHomeBannerBinding

class BannerFragment(val imgRes : Int) : Fragment() {

    lateinit var binding : FragmentHomeBannerBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentHomeBannerBinding.inflate(inflater,container,false)
        binding.bannerImageIv.setImageResource(imgRes)


        return binding.root
    }
}