package com.skanderjabouzi.java.androidarchitecture.mvvmbiding;

import android.databinding.BaseObservable;

import com.google.gson.annotations.SerializedName;

public class CountryBindable extends BaseObservable {
    @SerializedName("name")
    public String countryName;
}
