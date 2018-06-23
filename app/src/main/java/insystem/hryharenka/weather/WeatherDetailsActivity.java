package insystem.hryharenka.weather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import insystem.hryharenka.weather.models.CurrentWeather;
import insystem.hryharenka.weather.models.Forecast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherDetailsActivity extends AppCompatActivity {
    TextView temperature;
    Forecast forecast;
    TextView forecastTextView;
    private int cityId;

    public Activity getActivity() {
        return this;
    }

    Button forecastButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_details);
        Intent intent = getIntent();
        cityId = intent.getIntExtra("cityId", 0);
        final CurrentWeather weather = intent.getParcelableExtra("weather");
        String temp = Double.toString(weather.getMain().getTemp());
        temperature = findViewById(R.id.temperature_value);
        temperature.setText(temp);
        forecastTextView = findViewById(R.id.forecast);
        forecastButton = findViewById(R.id.show_3);
        forecastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.isInternetAvailable()) {
                    final Call<Forecast> call = CityAdapter.weatherService.forecast(cityId, "b6907d289e10d714a6e88b30761fae22");
                    call.clone().enqueue(new Callback<Forecast>() {
                        @Override
                        public void onResponse(@NonNull Call<Forecast> call, @NonNull Response<Forecast> response) {
                            forecast = response.body();
                            StringBuilder stringBuilder = new StringBuilder();
                            for (int i = 0; i < 24; i++) {
                                stringBuilder.append(forecast.getList().get(i).getDtTxt());
                                stringBuilder.append(" - ");
                                stringBuilder.append(forecast.getList().get(i).getMain().getTemp().toString());
                                stringBuilder.append("\n");
                                forecastTextView.setText(stringBuilder);
                            }
                            System.out.println();
                        }

                        @Override
                        public void onFailure(@NonNull Call<Forecast> call, @NonNull Throwable t) {
                            Toast toast = Toast.makeText(getActivity(), "Bad response:(", Toast.LENGTH_LONG);
                            toast.show();
                            System.out.println();

                        }
                    });
                } else {
                    Toast toast = Toast.makeText(getActivity(), "Включите интернет!!!", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

    }
}
