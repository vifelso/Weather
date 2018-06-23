package insystem.hryharenka.weather;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import insystem.hryharenka.weather.models.City;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter mAdapter;

    public Activity getActivity() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addCity = findViewById(R.id.add_city);
        addCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (WeatherApplication.cities.size() != 0) {
                    AlertDialog.Builder builderSingle = new AlertDialog.Builder(MainActivity.this);
                    builderSingle.setTitle("Выберите город:-");

                    final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.select_dialog_singlechoice);

                    for (int i = 0; i < WeatherApplication.cities.size(); i++) {
                        int key = WeatherApplication.cities.keyAt(i);
                        arrayAdapter.add(WeatherApplication.cities.get(key).getName());

                    }

                    builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

                    builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            int key = WeatherApplication.cities.keyAt(which);
                            City newCity = WeatherApplication.cities.get(key);
                            ((CityAdapter) mAdapter).getmDataset().add(newCity);
                            mAdapter.notifyItemInserted(mAdapter.getItemCount() - 1);
                        }
                    });
                    builderSingle.show();
                } else {
                    Toast toast = Toast.makeText(getActivity(), "Ждите!!! Идёт загрузка городов.", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        List<City> cityList = new ArrayList<>();
        City city = new City();
        city.setId(5601538);
        city.setName("Moscow");
        cityList.add(city);
        city = new City();
        city.setId(4171563);
        city.setName("Saint Petersburg");
        cityList.add(city);

        mAdapter = new CityAdapter(cityList, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    public static boolean isInternetAvailable() {
        String netAddress = null;
        try {
            netAddress = new NetTask().execute("www.google.com").get();
        } catch (Exception e1) {
            return false;
        }
        if (netAddress != null) {
            return !netAddress.equals("");
        } else {
            return false;
        }
    }

    public static class NetTask extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... params) {
            InetAddress addr = null;
            try {
                addr = InetAddress.getByName("google.com");
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            return addr != null ? addr.getHostAddress() : null;
        }
    }
}
