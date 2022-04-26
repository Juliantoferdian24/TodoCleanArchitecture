package com.ferdian.todocleanarchitecture.presentation.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ferdian.todocleanarchitecture.R
import com.ferdian.todocleanarchitecture.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}