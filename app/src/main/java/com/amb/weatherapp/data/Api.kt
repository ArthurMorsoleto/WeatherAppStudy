package com.amb.weatherapp.data

import com.amb.weatherapp.data.response.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *  Base api interface for fetching data from https://open-meteo.com/
 */
interface Api {

    /**
     *  Gets Weather Data Information based on user location
     */
    @GET(WEATHER_ENDPOINT)
    suspend fun getWeatherData(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double
    ): WeatherResponse

    companion object {
        private const val WEATHER_ENDPOINT =
            "v1/forecast?current=temperature_2m,wind_speed_10m,weathercode,relative_humidity_2m"
    }
}