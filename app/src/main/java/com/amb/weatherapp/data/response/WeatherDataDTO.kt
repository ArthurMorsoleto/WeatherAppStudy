package com.amb.weatherapp.data.response

import com.squareup.moshi.Json

data class WeatherDataDTO(
    @field:Json(name = "time")
    val time: String,
    @field:Json(name = "temperature_2m")
    val temperature: Double,
    @field:Json(name = "interval")
    val interval: Int,
    @field:Json(name = "wind_speed_10m")
    val windSpeeds: Double,
    @field:Json(name = "weathercode")
    val weatherCode: Int,
    @field:Json(name = "relative_humidity_2m")
    val relativeHumidity: Double
)
