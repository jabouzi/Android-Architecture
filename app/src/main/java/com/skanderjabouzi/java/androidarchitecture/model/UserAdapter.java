package com.skanderjabouzi.java.androidarchitecture.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skanderjabouzi.java.androidarchitecture.R;
import com.skanderjabouzi.java.androidarchitecture.mvvm1.BindableAdapter;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;


public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> implements BindableAdapter {

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

    public UserViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new UserViewHolder(view);
    }

    public int getItemCount() {
        return this.countries.size();
    }

    public void onBindViewHolder(@NotNull UserViewHolder holder, int position) {
        holder.bind(this.countries.get(position));
    }
}
