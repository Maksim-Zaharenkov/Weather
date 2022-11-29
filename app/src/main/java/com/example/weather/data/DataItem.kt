package com.example.wheather.data

data class DataItem (
    val city: String,
    val time: String,
    val condition: String,
    val imageUrl: String,
    val currentTemperature: String,
    val minTemperature: String,
    val maxTemperature: String,
    val hours: String
    )