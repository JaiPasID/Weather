package fr.jaipasid.weather;

import android.util.Log;

import fr.jaipasid.weather.models.WeatherApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository {

    WeatherApiInterface weatherApiInterface;
    String apiKey = "2331d28326ca7c4895602fd40186230d";

    public WeatherRepository (WeatherApiInterface weatherApiInterface){
        this.weatherApiInterface = weatherApiInterface;
    }

    public void FetchData (String country){
        Call<WeatherApi> call = weatherApiInterface.getWeather(country, "limit",apiKey );

        call.enqueue(new Callback<WeatherApi>() {
            @Override
            public void onResponse(Call<WeatherApi> call, Response<WeatherApi> response) {
                Log.d("test", response.body().toString());
            }

            @Override
            public void onFailure(Call<WeatherApi> call, Throwable t) {
                Log.d("Test Echec", t.getMessage());
            }
        });
    }
}
