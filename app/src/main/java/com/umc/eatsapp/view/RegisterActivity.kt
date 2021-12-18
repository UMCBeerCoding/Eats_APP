package com.umc.eatsapp.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.umc.eatsapp.data.User
import com.umc.eatsapp.databinding.ActivityRegisterBinding
import com.umc.eatsapp.service.AuthService
import com.umc.eatsapp.serviceView.RegisterView

class RegisterActivity : AppCompatActivity(), RegisterView {
    lateinit var binding : ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.registerRegisterTv.setOnClickListener {
            register()
        }
    }

    private fun register() {
        val authService = AuthService()
        authService.setRegisterView(this)
        authService.register(getUser())
    }

    override fun onRegisterLoading() {
        Toast.makeText(this,"로딩중.",Toast.LENGTH_SHORT).show()
    }

    override fun onRegisterSucces() {
        Toast.makeText(this,"회원가입에 성공하셨습니다.",Toast.LENGTH_SHORT).show()
        finish()
    }

    override fun onRegisterFailure(code: Int, message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    private fun getUser() : User {
        var email : String = binding.registerEmail.text.toString()
        var pwd : String = binding.registerPassword.text.toString()
        var name : String = binding.registerName.text.toString()
        var phone : String = binding.registerPhone.text.toString()

        return User(email,pwd,name,phone)
    }
}