package fr.jaipasid.weather;

import androidx.lifecycle.ViewModel;

import java.util.List;

import fr.jaipasid.weather.models.Weather;

public class FetchDataViewModel extends ViewModel {

    private WeatherRepository weatherRepository;

    public FetchDataViewModel (WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public List<Weather> getWeather(String myCountry){
        return weatherRepository.FetchData(myCountry);
    }
}
