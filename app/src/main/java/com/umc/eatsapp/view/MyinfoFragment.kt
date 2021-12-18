package com.umc.eatsapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.umc.eatsapp.databinding.FragmentMyinfoBinding

class MyinfoFragment : Fragment() {
    lateinit var binding : FragmentMyinfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyinfoBinding.inflate(inflater,container,false)
        return binding.root
    }
}