package com.skanderjabouzi.java.androidarchitecture.mvvmbiding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import com.skanderjabouzi.java.androidarchitecture.BR;
import com.skanderjabouzi.java.androidarchitecture.model.CountriesService;
import com.skanderjabouzi.java.androidarchitecture.model.Country;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import java.util.Random;

public class CountriesBindingViewModel extends BaseObservable {

    public List<String> countries;
    public Boolean countryError;
    public Boolean initStatus;
    private CountriesService service = new CountriesService();

    public CountriesBindingViewModel() {
        this.countries = new ArrayList<>();
    }

    @Bindable
    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
        this.notifyPropertyChanged(3);
        Log.e("COUNTRIES1", this.countries.toString());
    }

    @Bindable
    public Boolean getCountryError() {
        return countryError;
    }

    public void setCountryError(Boolean countryError) {
        this.countryError = countryError;
        this.notifyPropertyChanged(4);
    }

    @Bindable
    public Boolean getInitStatus() {
        return initStatus;
    }

    public void setInitStatus(Boolean initStatus) {
        this.initStatus = initStatus;
        this.notifyPropertyChanged(2);
    }

    private void fetchCountries() {
        service.getCountries()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Country>>() {

                    @Override
                    public void onSuccess(List<Country> value) {
                        List<String> countryNames = new ArrayList<>();
                        for (Country country : value) {
                            countryNames.add(country.countryName);
                        }
                        setCountries(countryNames);
                        setCountryError(false);
                        setInitStatus(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        setCountryError(true);
                        setInitStatus(false);
                    }
                });
    }

    public void onRefresh() {
        setInitStatus(false);
        byte var1 = 10;
        List<String> countries = new ArrayList(var1);
        for (int i = 0; i < 10; i++) {
            countries.add("I " + i);
        }
        setCountries(countries);
    }
}
