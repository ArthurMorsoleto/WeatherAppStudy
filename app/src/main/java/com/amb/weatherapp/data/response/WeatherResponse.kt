package com.amb.weatherapp.data.response

import com.squareup.moshi.Json

data class WeatherResponse(
    @field:Json(name = "current")
    val data: WeatherDataDTO
)
