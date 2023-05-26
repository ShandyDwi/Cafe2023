package com.example.ukl2023

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ukl2023.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cardDatauserIvBg.setOnClickListener {
            startActivity(Intent(this, DataUser::class.java))
            finish()
        }

        binding.cardMenuIvBg.setOnClickListener {
            startActivity(Intent(this, DataMenu::class.java))
            finish()
        }

        binding.cardMejaIvBg.setOnClickListener {
            startActivity(Intent(this, DataMeja::class.java))
            finish()
        }
    }
}