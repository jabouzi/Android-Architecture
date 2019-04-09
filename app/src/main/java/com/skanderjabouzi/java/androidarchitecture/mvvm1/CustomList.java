package com.skanderjabouzi.java.androidarchitecture.mvvm1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.skanderjabouzi.java.androidarchitecture.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CustomList extends ArrayAdapter<Integer>  implements BindableAdapter{

    private final Activity context;

    @NotNull
    private List<Integer> userIds = new ArrayList();

    @Override
    public void setData(@NotNull List items) {
        this.userIds = items;
        this.notifyDataSetChanged();
    }

//    @Override
//    public void changedPositions(@NotNull Set positions) {
//        Iterable iterable = (Iterable)positions;
//        CustomList userAdapter = this;
//        Iterator iterator = iterable.iterator();
//
//        while(iterator.hasNext()) {
//            Object o = iterator.next();
//            int p1 = ((Number)o).intValue();
////            int var7 = false;
//            userAdapter.notifyDataSetChanged();
//        }
//
//    }

    public CustomList(Activity context) {
        super(context, R.layout.list_item);
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_item, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.userText);
        txtTitle.setText(String.valueOf(userIds.get(position)));
        return rowView;
    }
}
