package fr.jaipasid.weather;

import fr.jaipasid.weather.models.WeatherApi;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiInterface {

    @GET ("geo/1.0/direct")
    Call<WeatherApi> getWeather(@Query("city")String city, @Query("limit")String limit, @Query("key") String apiKey);
}

/**
 * geo/1.0/direct
 * ?q={city name},
 * &limit={limit}&appid={API key}
 */