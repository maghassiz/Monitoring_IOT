package com.magha.monitoring_iot;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("humidity")
    @Expose
    private String humidity;

    public String getHumidity(){
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}
