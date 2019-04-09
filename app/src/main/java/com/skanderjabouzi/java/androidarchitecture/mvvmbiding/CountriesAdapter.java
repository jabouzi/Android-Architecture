package com.skanderjabouzi.java.androidarchitecture.mvvmbiding;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

import com.skanderjabouzi.java.androidarchitecture.R;

public class CountriesAdapter extends RecyclerView.Adapter<CountryViewHolder> implements BindableAdapter {

    @NotNull
    private List<String> countries = new ArrayList();

    @Override
    public void setData(@NotNull List items) {
        this.countries = items;
        this.notifyDataSetChanged();
    }

    @NotNull
    public final List getCountries() {
        return this.countries;
    }

    public final void setCountries(@NotNull List countries) {
        this.countries = countries;
    }

    public CountryViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_layout, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.bind(this.countries.get(position));
    }

    public int getItemCount() {
        return this.countries.size();
    }
}
