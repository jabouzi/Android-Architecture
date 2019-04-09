package com.skanderjabouzi.java.androidarchitecture.mvvm1;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public final class BindingUtils {
    @BindingAdapter({"data"})
    public static final void setRecyclerViewProperties(@NotNull RecyclerView recyclerView, @NotNull List items) {
        if (recyclerView.getAdapter() instanceof BindableAdapter) {
            Adapter adapter = recyclerView.getAdapter();
            ((BindableAdapter)adapter).setData(items);
        }
    }

//    @BindingAdapter({"data"})
//    public static final void setListViewProperties(@NotNull ListView listView, @NotNull List items) {
//        if (listView.getAdapter() instanceof BindableAdapter) {
//            ListAdapter adapter = listView.getAdapter();
//            ((BindableAdapter)adapter).setData(items);
//        }
//
//    }

//    @BindingAdapter({"changedPositions"})
//    public static final void setDataChanged(@NotNull RecyclerView recyclerView, @NotNull Set positions) {
//        if (recyclerView.getAdapter() instanceof BindableAdapter) {
//            Adapter adapter = recyclerView.getAdapter();
//            ((BindableAdapter)adapter).changedPositions(positions);
//        }
//
//    }
}

