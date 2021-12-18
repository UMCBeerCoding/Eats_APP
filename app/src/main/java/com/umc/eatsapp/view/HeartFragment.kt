package com.umc.eatsapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.umc.eatsapp.databinding.FragmentHeartBinding

class HeartFragment : Fragment() {
    lateinit var binding : FragmentHeartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHeartBinding.inflate(inflater,container,false)
        return binding.root
    }
}