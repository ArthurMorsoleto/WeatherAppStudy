package com.amb.weatherapp.data.repository

import com.amb.weatherapp.data.Api
import com.amb.weatherapp.data.response.WeatherDataDTO
import com.amb.weatherapp.data.response.WeatherResponse
import com.amb.weatherapp.domain.repository.WeatherRepository
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import java.time.LocalDateTime

class WeatherRepositoryImplTest {

    private lateinit var subject: WeatherRepository
    private val api = mockk<Api>()
    private val weatherResponse = WeatherResponse(
        data = WeatherDataDTO(
            time = LocalDateTime.now().toString(),
            temperature = 23.0,
            windSpeeds = 10.0,
            relativeHumidity = 3.0,
            interval = 3,
            weatherCode = 3
        )
    )

    @Before
    fun setup() {
        subject = WeatherRepositoryImpl(api)
    }

    @Test
    fun `when get weather data is called then should return response success`() = runTest {
        coEvery { api.getWeatherData(any(), any()) } returns weatherResponse

        val response = subject.getWeatherData(10.0, 10.0)

        assertEquals(23.0, response.data?.temperatureCelsius)
    }
}
