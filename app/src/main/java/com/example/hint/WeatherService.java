package com.example.hint;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface WeatherService {
    @GET("weather/24h")
    Call<WeatherResponse> getWeather(@QueryMap Map<String, String> options);
}
