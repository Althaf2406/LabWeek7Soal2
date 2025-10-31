package com.example.labweek7.data.dto

import com.google.gson.annotations.SerializedName


data class Rain(
    @SerializedName("1h")
    val oneHour: Double
)