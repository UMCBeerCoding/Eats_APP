package com.umc.eatsapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.umc.eatsapp.databinding.ActivitySplashBinding
import com.umc.eatsapp.view.LoginActivity

class SplashActivity : AppCompatActivity(){
    lateinit var binding : ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            finish()
            startActivity(intent)
        },2000) //2초를 기다린 후 {} 안을 실행한다.
    }
}