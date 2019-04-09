package com.skanderjabouzi.java.androidarchitecture.mvvmbiding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BindingUtils {

    @BindingAdapter({"data"})
    public static final void setRecyclerViewProperties(@NotNull RecyclerView recyclerView, @NotNull List items) {
        if (recyclerView.getAdapter() instanceof BindableAdapter) {
            Adapter adapter = recyclerView.getAdapter();
            ((BindableAdapter)adapter).setData(items);
        }
    }
}
