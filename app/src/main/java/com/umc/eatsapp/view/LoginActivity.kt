package com.umc.eatsapp.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.umc.eatsapp.AuthResult
import com.umc.eatsapp.data.User
import com.umc.eatsapp.databinding.ActivityLoginBinding
import com.umc.eatsapp.service.AuthService
import com.umc.eatsapp.serviceView.LoginView

class LoginActivity :AppCompatActivity(),LoginView{
    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginRegisterTv.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }

        binding.loginLoginTv.setOnClickListener {
            login()
        }
    }

    private fun login() {

        var email : String = binding.loginEmail.text.toString()
        var pwd : String = binding.loginPassword.text.toString()
        val user : User = User(email, pwd,"","")

        val authService = AuthService()
        authService.setLoginView(this)
        authService.login(user)
    }

    override fun onLoginLoading() {
        Toast.makeText(this,"로딩중.", Toast.LENGTH_SHORT).show()
    }

    override fun onLoginSuccess(auth: AuthResult) {
        Toast.makeText(this,"로그인에 성공하셨습니다.",Toast.LENGTH_SHORT).show()
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }

    override fun onLoginFailure(code: Int, message: String) {
        Toast.makeText(this,message.toString(),Toast.LENGTH_SHORT).show()
    }

}