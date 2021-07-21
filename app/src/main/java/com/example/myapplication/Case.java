package com.example.myapplication;

import org.json.JSONException;
import org.json.JSONObject;

public class Case {

    private int confirmed;
    private int deaths;
    private int recovered;
    private int active;
    private String date;

    public Case() {
    }

    public Case(JSONObject jsonObject) throws JSONException {
        this.confirmed = jsonObject.getInt("Confirmed");
        this.deaths = jsonObject.getInt("Deaths");
        this.recovered = jsonObject.getInt("Recovered");
        this.active = jsonObject.getInt("Active");
        this.date = jsonObject.getString("Date");
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
