package com.skanderjabouzi.java.androidarchitecture.mvvm;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.skanderjabouzi.java.androidarchitecture.model.CountriesService;
import com.skanderjabouzi.java.androidarchitecture.model.Country;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class CountriesViewModel extends ViewModel {

    private final MutableLiveData<List<String>> countries = new MutableLiveData<>();
    private final MutableLiveData<Boolean> countryError = new MutableLiveData<>();

    private CountriesService service;

    public CountriesViewModel() {
        service = new CountriesService();
        fetchCountries();
    }

    public LiveData<List<String>> getCountries() {
        return countries;
    }

    public MutableLiveData<Boolean> getCountryError() {
        return countryError;
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
                        countries.setValue(countryNames);
                        countryError.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        countryError.setValue(true);
                    }
                });
    }

    public void onRefresh() {
        fetchCountries();
    }
}
