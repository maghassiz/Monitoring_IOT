package com.magha.monitoring_iot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String BASE_API_URL = "https://io.adafruit.com/api/v2/maghassiz/feeds/";
    private static final String APP_ID = "maghassiz";
    private static final String APP_KEY = "1d52a87e10724b1893ce3a4c3c23bfd9";
    TextView tvHumidity,tvTemp;
    String humidityValue, temperatureValue,key;
    boolean humidity,temperatur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHumidity = (TextView) findViewById(R.id.tvHumidity);
        tvTemp = (TextView) findViewById(R.id.tvTemp);

//        OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
//            @Override
//            public Response intercept(@NonNull Chain chain) throws IOException {
//                Request request = chain.request()
//                        .newBuilder()
//                        .addHeader("app_key", APP_KEY)
//                        .build();
//                return chain.proceed(request);
//            }
//        }).build();
//        ------------------------------------
          tvHumidity.setOnClickListener(this);
          tvTemp.setOnClickListener(this);
//        final Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_API_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        ApiHum apiService = retrofit.create(ApiHum.class);
//        final Call<MonitoringModel> result = apiService.getInfo();
//        result.enqueue(new Callback<MonitoringModel>() {
//            private static final String TAG = "Data Monitoring";
//
//            @Override
//            public void onResponse(Call<MonitoringModel> call, Response<MonitoringModel> response) {
//                if (response != null) {
//                    Log.i(TAG, String.valueOf(response.body()));
//                    key = response.body().getKeyValue();
//                    key = "humidity";
//                    key = "temperatur";
//                    if (key == "humidity"){
//                        humidityValue = response.body().getLastValue();
//                        tvHumidity.setText(humidityValue);
//                    }
//                    if (key== "temperatur"){
//                        temperatureValue = response.body().getLastValue();
//                        tvTemp.setText(temperatureValue);
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MonitoringModel> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvHumidity :
                Intent humidity = new Intent(MainActivity.this, HumidityActivity.class);
                startActivity(humidity);

            case R.id.tvTemp :
                Intent temperature = new Intent(MainActivity.this, TemperatureActivity.class);
                startActivity(temperature);
        }
    }
}
