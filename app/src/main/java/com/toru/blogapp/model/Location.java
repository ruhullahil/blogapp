package com.toru.blogapp.model;

import com.google.gson.annotations.SerializedName;

public class Location {
    @SerializedName("name")
    public   String name;
    @SerializedName("lat")
    public Double lat;
    @SerializedName("lng")
    public Double lng;
    @SerializedName("span")
    public String span;

    public Location(String name, Double lat, Double lng, String span) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.span = span;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getSpan() {
        return span;
    }

    public void setSpan(String span) {
        this.span = span;
    }
}

