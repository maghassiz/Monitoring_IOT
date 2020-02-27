package com.magha.monitoring_iot;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import retrofit2.http.Headers;

public class MonitoringModel {
    @SerializedName("last_value")
    @Expose
    private String lastValue;

    @SerializedName("key")
    @Expose
    private String  keyValue;

    public String getLastValue() {
        return lastValue;
    }

    public String  getKeyValue() {
        return keyValue;
    }

    public void setLastValue(String lastValue) {
        this.lastValue = lastValue;
    }

    public void setKeyValue(String  keyValue) {
        this.keyValue = keyValue;
    }
}