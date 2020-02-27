package com.magha.monitoring_iot;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiTemperature {
    @Headers("X-AIO-Key:1d52a87e10724b1893ce3a4c3c23bfd9")
    @GET("temperatur")
    Call<MonitoringModel> getTemp();
}
