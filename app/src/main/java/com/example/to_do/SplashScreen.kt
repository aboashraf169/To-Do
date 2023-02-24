package com.example.to_do

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.to_do.databinding.SplashScreenBinding

class SplashScreen : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = SplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val i = Intent(this, MainActivity::class.java)
        Handler().postDelayed({
            startActivity(i)
            finish()
        }, 2000)
    }
}