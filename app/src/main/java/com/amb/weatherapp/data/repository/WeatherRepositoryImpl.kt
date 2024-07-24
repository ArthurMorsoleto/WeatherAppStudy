package com.amb.weatherapp.data.repository

import android.annotation.SuppressLint
import com.amb.weatherapp.data.Api
import com.amb.weatherapp.data.mappers.toWeatherData
import com.amb.weatherapp.domain.repository.WeatherRepository
import com.amb.weatherapp.domain.util.Response
import com.amb.weatherapp.domain.weather.WeatherData
import javax.inject.Inject

@SuppressLint("NewApi")
class WeatherRepositoryImpl @Inject constructor(
    private val api: Api
) : WeatherRepository {

    override suspend fun getWeatherData(
        latitude: Double,
        longitude: Double
    ): Response<WeatherData> {
        return try {
            val response = api.getWeatherData(latitude, longitude).data.toWeatherData()
            Response.Success(data = response)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Error(message = e.message ?: "Error")
        }
    }
}
