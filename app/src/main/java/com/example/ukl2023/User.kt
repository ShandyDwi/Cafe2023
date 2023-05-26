package com.example.ukl2023


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    var name: String,
    var username: String,
    var password: String,
    var job: String,
    var image: Int
)