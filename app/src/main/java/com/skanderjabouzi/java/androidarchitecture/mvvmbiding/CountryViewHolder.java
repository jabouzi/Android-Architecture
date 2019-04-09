package com.skanderjabouzi.java.androidarchitecture.mvvmbiding;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skanderjabouzi.java.androidarchitecture.R;

public class CountryViewHolder extends RecyclerView.ViewHolder{
    TextView title;
    private ViewGroup container;

    public CountryViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.listText);
    }

    public void bind(String countryName) {
        title.setText(countryName);
    }

    public ViewGroup getContainer() {
        return container;
    }

}