package insystem.hryharenka.weather;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import insystem.hryharenka.weather.models.City;
import insystem.hryharenka.weather.models.CurrentWeather;
import insystem.hryharenka.weather.services.WeatherService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {
    private List<City> mDataset;
    private Activity activity;
    public static WeatherService weatherService = WeatherService.retrofit.create(WeatherService.class);
    CurrentWeather weather;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView cityNameTextView;

        ViewHolder(View v) {
            super(v);
            cityNameTextView = v.findViewById(R.id.weatherName);
        }
    }

    CityAdapter(List<City> results, Activity activity) {
        mDataset = results;
        this.activity = activity;
    }

    public List<City> getmDataset() {
        return mDataset;
    }

    @NonNull
    @Override
    public CityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_recycler, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.cityNameTextView.setText(mDataset.get(position).getName());
        holder.cityNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.isInternetAvailable()) {
                    final Call<CurrentWeather> call = weatherService.currentWeather(mDataset.get(position).getId(), "b6907d289e10d714a6e88b30761fae22");
                    call.clone().enqueue(new Callback<CurrentWeather>() {
                        @Override
                        public void onResponse(@NonNull Call<CurrentWeather> call, @NonNull Response<CurrentWeather> response) {
                            weather = response.body();
                            Intent myIntent = new Intent(activity, WeatherDetailsActivity.class);
                            myIntent.putExtra("weather", weather);
                            myIntent.putExtra("cityId", mDataset.get(position).getId());
                            activity.startActivity(myIntent);
                        }

                        @Override
                        public void onFailure(@NonNull Call<CurrentWeather> call, @NonNull Throwable t) {
                            Toast toast = Toast.makeText(activity, "Bad response:(", Toast.LENGTH_LONG);
                            toast.show();

                        }
                    });
                } else {
                    Toast toast = Toast.makeText(activity, "Включите интернет!!!", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();

    }


}