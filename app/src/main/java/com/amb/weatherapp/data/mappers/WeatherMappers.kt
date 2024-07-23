package com.amb.weatherapp.data.mappers

import android.os.Build
import androidx.annotation.RequiresApi
import com.amb.weatherapp.data.response.WeatherDataDTO
import com.amb.weatherapp.domain.weather.WeatherData
import com.amb.weatherapp.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDataDTO.toWeatherData(): WeatherData {
    return WeatherData(
        time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
        temperatureCelsius = temperature,
        windSpeed = windSpeeds,
        humidity = relativeHumidity,
        weatherType = WeatherType.fromWMO(weatherCode)
    )
}
