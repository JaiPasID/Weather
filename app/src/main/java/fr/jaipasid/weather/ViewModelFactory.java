package fr.jaipasid.weather;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private static ViewModelFactory viewModelFactory;
    private WeatherRepository weatherRepository;
    /**
     * Singleton
     * instantiate ViewModelFactory with things inside constructors
     */
    public static ViewModelFactory getInstance(Context context) {

        if (viewModelFactory == null) {
            synchronized (ViewModelFactory.class) {
                viewModelFactory = new ViewModelFactory(context);
            }
        }
        return viewModelFactory;
    }

    /**
     * Constructor
     * Instantiate 1 repository
     */
    private ViewModelFactory(Context context) {

        weatherRepository = new WeatherRepository(Retrofit.getWeather());

    }



    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(FetchDataViewModel.class)) {
            return (T) new FetchDataViewModel(weatherRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
