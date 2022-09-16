package fr.jaipasid.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import fr.jaipasid.weather.models.Weather;
import fr.jaipasid.weather.models.WeatherApi;

public class MainActivity extends AppCompatActivity {

    TextInputEditText mCountry;
    String countryName;
    TextView mAnswer;
    Button mValidate;
    private FetchDataViewModel mFetchDataViewModel;

    List<Weather> maMeteo = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mFetchDataViewModel = new ViewModelProvider(this, ViewModelFactory.getInstance()).get(FetchDataViewModel.class);

        mCountry = findViewById(R.id.countryName);
        mAnswer = findViewById(R.id.answer_retrofit);
        mValidate = findViewById(R.id.validate);



        mValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countryName = mCountry.getText().toString();
                maMeteo = mFetchDataViewModel.getWeather(countryName);


                if (maMeteo.size() > 0) {
                    String description = maMeteo.get(0).getDescription();

                    mAnswer.setText(description);
                }




            }
        });

    }


}