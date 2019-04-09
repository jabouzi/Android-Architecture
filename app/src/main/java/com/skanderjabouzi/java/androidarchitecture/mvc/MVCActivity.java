package com.skanderjabouzi.java.androidarchitecture.mvc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.skanderjabouzi.java.androidarchitecture.ItemClickListener;
import com.skanderjabouzi.java.androidarchitecture.R;
import com.skanderjabouzi.java.androidarchitecture.model.UserAdapter1;

import java.util.ArrayList;
import java.util.List;

public class MVCActivity extends AppCompatActivity implements ItemClickListener {

    private List<String> listValues = new ArrayList<>();
    private UserAdapter1 adapter;
    private RecyclerView list;
    private CountriesController controller;
    private Button retryButton;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("MVC Activity");

        controller = new CountriesController(this);

        list = findViewById(R.id.list);
        retryButton = findViewById(R.id.retryButton);
        progress = findViewById(R.id.progress);
        adapter = new UserAdapter1(listValues);
        adapter.setClickListener(this);
        list.setAdapter(adapter);
    }

    public void setValues(List<String> values) {
        listValues.clear();
        listValues.addAll(values);
        retryButton.setVisibility(View.GONE);
        progress.setVisibility(View.GONE);
        list.setVisibility(View.VISIBLE);
        adapter.notifyDataSetChanged();
    }

    public void onRetry(View view) {
        controller.onRefresh();
        retryButton.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
        list.setVisibility(View.GONE);
    }

    public void onError() {
        Toast.makeText(this, getString(R.string.error_message), Toast.LENGTH_SHORT).show();
        retryButton.setVisibility(View.VISIBLE);
        progress.setVisibility(View.GONE);
        list.setVisibility(View.GONE);

    }

    public static Intent getIntent(Context context) {
        return new Intent(context, MVCActivity.class);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(MVCActivity.this, "You Clicked " + listValues.get(position), Toast.LENGTH_SHORT).show();
    }
}
