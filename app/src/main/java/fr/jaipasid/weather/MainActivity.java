package fr.jaipasid.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText mCountry;
    String countryName;
    TextView mAnswer;
    Button mValidate;

    private FetchDataViewModel fetchDataViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCountry = findViewById(R.id.countryName);
        mAnswer = findViewById(R.id.answer_retrofit);
        mValidate = findViewById(R.id.validate);



        mValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countryName = mCountry.getText().toString();
                fetchDataViewModel.getWeather(countryName);
            }
        });

    }

}