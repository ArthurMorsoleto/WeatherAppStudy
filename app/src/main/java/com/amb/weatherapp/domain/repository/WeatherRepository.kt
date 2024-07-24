package com.amb.weatherapp.domain.repository

import com.amb.weatherapp.domain.util.Response
import com.amb.weatherapp.domain.weather.WeatherData

interface WeatherRepository {
    suspend fun getWeatherData(latitude: Double, longitude: Double): Response<WeatherData>
}
