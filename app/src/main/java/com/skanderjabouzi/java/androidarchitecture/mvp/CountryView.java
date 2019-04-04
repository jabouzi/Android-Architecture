package com.skanderjabouzi.java.androidarchitecture.mvp;

import java.util.List;

public interface CountryView {
    void setValues(List<String> countries);
    void onError();
}
