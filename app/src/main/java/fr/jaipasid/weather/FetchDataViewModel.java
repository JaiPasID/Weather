package fr.jaipasid.weather;

import androidx.lifecycle.ViewModel;

public class FetchDataViewModel extends ViewModel {

    private WeatherRepository weatherRepository;

    public FetchDataViewModel (WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public void getWeather (String myCountry){
        weatherRepository.FetchData(myCountry);
    }
}
