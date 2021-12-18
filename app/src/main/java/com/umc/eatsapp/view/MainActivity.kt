package com.umc.eatsapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.umc.eatsapp.R
import com.umc.eatsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){


    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initNavigation()
    }

    private fun initNavigation() {

        //activity -> fragment
        supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment())
            .commitAllowingStateLoss()

        binding.mainBnv.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.searchFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, SearchFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.heartFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, HeartFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.orderFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, OrderFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.myinfoFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, MyinfoFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }
}

