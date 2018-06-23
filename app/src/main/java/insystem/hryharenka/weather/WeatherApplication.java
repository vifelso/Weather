package insystem.hryharenka.weather;


import android.app.Application;
import android.util.SparseArray;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import insystem.hryharenka.weather.models.City;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class WeatherApplication extends Application {
    public static SparseArray<City> cities = new SparseArray<>();

    @Override
    public void onCreate() {
        super.onCreate();
        //можно было и с помощью AsyncTask или своео потока.
        Observable.create(new ObservableOnSubscribe<List<City>>() {
            @Override
            public void subscribe(ObservableEmitter<List<City>> e) {
                cities = loadJSONFromAsset();
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    public SparseArray<City> loadJSONFromAsset() {
        SparseArray<City> cityList = new SparseArray<City>();
        try {
            InputStream is = this.getAssets().open("city.list.json");
            JsonReader reader = new JsonReader(new InputStreamReader(is, "UTF-8"));
            reader.beginArray();
            Gson gson = new GsonBuilder().create();
            while (reader.hasNext()) {
                City city = gson.fromJson(reader, City.class);
                cityList.append(city.getId(), city);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cityList;
    }

}
