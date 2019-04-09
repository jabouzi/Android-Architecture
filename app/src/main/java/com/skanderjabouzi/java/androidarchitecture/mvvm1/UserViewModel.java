package com.skanderjabouzi.java.androidarchitecture.mvvm1;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import com.skanderjabouzi.java.androidarchitecture.model.CountriesService;
import com.skanderjabouzi.java.androidarchitecture.model.Country;


import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public final class UserViewModel extends BaseObservable {
    @NotNull
    private List<String> countries;
    @NotNull
    public Boolean countryError;
    @NotNull
    public Boolean initStatus;
    private CountriesService service = new CountriesService();

    @Bindable
    @NotNull
    public final List getCountries() {
        return this.countries;
    }

    private final void setCountries(List value) {
        this.countries = value;
        this.notifyPropertyChanged(3);
    }

    @Bindable
    @NotNull
    public Boolean getCountryError() {
        return countryError;
    }

    public void setCountryError(Boolean countryError) {
        this.countryError = countryError;
        this.notifyPropertyChanged(4);
    }

    @Bindable
    @NotNull
    public Boolean getInitStatus() {
        return initStatus;
    }

    public void setInitStatus(Boolean initStatus) {
        this.initStatus = initStatus;
        this.notifyPropertyChanged(2);
    }

    public final void onRefresh() {
        this.fetchCountries();
    }

    public UserViewModel() {
        setInitStatus(true);
        countries = new ArrayList<>();
    }

    private void fetchCountries() {
        service.getCountries()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Country>>() {

                    @Override
                    public void onSuccess(List<Country> value) {
                        List<String> countryNames = new ArrayList<>();
                        Log.e("COUNTRIES", value.toString());
                        for (Country country : value) {
                            countryNames.add(country.countryName);
                        }
                        setCountries(countryNames);
                        setCountryError(false);
                        setInitStatus(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("COUNTRIES", e.getLocalizedMessage());
                        setCountryError(true);
                        setInitStatus(false);
                    }
                });
    }

}
