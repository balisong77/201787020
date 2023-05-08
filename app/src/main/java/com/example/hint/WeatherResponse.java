package com.example.hint;

import java.util.ArrayList;

public class WeatherResponse{
    public String code;
    public String updateTime;
    public String fxLink;
    public ArrayList<Hourly> hourly;
    public Refer refer;

    public WeatherResponse(String code, String updateTime, String fxLink, ArrayList<Hourly> hourly, Refer refer) {
        this.code = code;
        this.updateTime = updateTime;
        this.fxLink = fxLink;
        this.hourly = hourly;
        this.refer = refer;
    }

    public WeatherResponse(){

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getFxLink() {
        return fxLink;
    }

    public void setFxLink(String fxLink) {
        this.fxLink = fxLink;
    }

    public ArrayList<Hourly> getHourly() {
        return hourly;
    }

    public void setHourly(ArrayList<Hourly> hourly) {
        this.hourly = hourly;
    }

    public Refer getRefer() {
        return refer;
    }

    public void setRefer(Refer refer) {
        this.refer = refer;
    }
}

