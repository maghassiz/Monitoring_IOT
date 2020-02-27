package com.magha.monitoring_iot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TemperatureActivity extends AppCompatActivity{
    TextView tvTemperature;
    String temperatureValue;
    public static final String BASE_API_URL = "https://io.adafruit.com/api/v2/maghassiz/feeds/";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        tvTemperature = (TextView) findViewById(R.id.tvTemperature);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiTemperature apiService = retrofit.create(ApiTemperature.class);
        final Call<MonitoringModel> result = apiService.getTemp();
        result.enqueue(new Callback<MonitoringModel>() {
                private static final String TAG = "Data Monitoring";

                @Override
                public  void onResponse(Call<MonitoringModel> call, Response<MonitoringModel>response){
                    if(response != null){
                        Log.i(TAG, String.valueOf(response.body()));
                        temperatureValue = response.body().getLastValue();
                        tvTemperature.setText(temperatureValue);
                    }
                }

            @Override
            public void onFailure(Call<MonitoringModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


}