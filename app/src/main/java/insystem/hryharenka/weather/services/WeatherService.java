package insystem.hryharenka.weather.services;

import insystem.hryharenka.weather.models.CurrentWeather;
import insystem.hryharenka.weather.models.Forecast;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("data/2.5/weather")
    Call<CurrentWeather> currentWeather(@Query("id") int idCountry, @Query("appid") String key);

    @GET("data/2.5/forecast")
    Call<Forecast> forecast(@Query("id") int idCountry, @Query("appid") String key);


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
