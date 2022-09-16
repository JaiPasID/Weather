package fr.jaipasid.weather;

import fr.jaipasid.weather.models.WeatherApi;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiInterface {

    @GET ("/data/2.5/weather")
    Call<WeatherApi> getWeather(@Query("q")String city, @Query("appid") String apiKey);
}


