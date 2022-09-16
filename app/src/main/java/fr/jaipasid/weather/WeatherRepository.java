package fr.jaipasid.weather;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import fr.jaipasid.weather.models.Weather;
import fr.jaipasid.weather.models.WeatherApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository {

    WeatherApiInterface weatherApiInterface;
    String apiKey = "2331d28326ca7c4895602fd40186230d";
    List<Weather> maMeteo = new ArrayList<>();

    public WeatherRepository (WeatherApiInterface weatherApiInterface){
        this.weatherApiInterface = weatherApiInterface;
    }

    public List<Weather> FetchData (String country){
        Call<WeatherApi> call = weatherApiInterface.getWeather(country, apiKey );

        call.enqueue(new Callback<WeatherApi>() {
            @Override
            public void onResponse(Call<WeatherApi> call, Response<WeatherApi> response) {
                Log.d("test", response.body().getBase());
                 maMeteo = response.body().getWeather();
            }

            @Override
            public void onFailure(Call<WeatherApi> call, Throwable t) {
                Log.d("Test Echec", t.getMessage());
            }
        });
        return maMeteo;
    }
}
