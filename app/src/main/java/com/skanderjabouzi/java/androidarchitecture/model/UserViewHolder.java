package com.skanderjabouzi.java.androidarchitecture.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skanderjabouzi.java.androidarchitecture.ItemClickListener;
import com.skanderjabouzi.java.androidarchitecture.R;


public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView title;
    private ViewGroup container;
    private ItemClickListener mClickListener;

    public UserViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        title = (TextView) itemView.findViewById(R.id.userText);
    }

    public void bind(String country) {
        title.setText(country);
    }

    public ViewGroup getContainer() {
        return container;
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
    }

}
