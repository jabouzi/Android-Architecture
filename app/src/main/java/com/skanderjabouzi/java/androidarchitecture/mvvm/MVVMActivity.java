package com.skanderjabouzi.java.androidarchitecture.mvvm;

import android.arch.lifecycle.ViewModelProviders;
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

public class MVVMActivity extends AppCompatActivity implements ItemClickListener {

    private List<String> listValues = new ArrayList<>();
    private UserAdapter1 adapter;
    private RecyclerView list;
    private CountriesViewModel viewModel;
    private Button retryButton;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("MVVM Activity");

        viewModel = ViewModelProviders.of(this).get(CountriesViewModel.class);

        list = findViewById(R.id.list);
        retryButton = findViewById(R.id.retryButton);
        progress = findViewById(R.id.progress);
        adapter = new UserAdapter1(listValues);
        adapter.setClickListener(this);
        list.setAdapter(adapter);

        observeViewModel();
    }

    private void observeViewModel() {
        viewModel.getCountries().observe(this, countries -> {
            if(countries != null) {
                listValues.clear();
                listValues.addAll(countries);
                list.setVisibility(View.VISIBLE);
                adapter.notifyDataSetChanged();
            } else {
                list.setVisibility(View.GONE);
            }
        });

        viewModel.getCountryError().observe(this, error -> {
            progress.setVisibility(View.GONE);
            if (error) {
                Toast.makeText(this, getString(R.string.error_message), Toast.LENGTH_SHORT).show();
                retryButton.setVisibility(View.VISIBLE);
            } else {
                retryButton.setVisibility(View.GONE);
            }
        });
    }

    public void onRetry(View view) {
        viewModel.onRefresh();
        retryButton.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
        list.setVisibility(View.GONE);
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, MVVMActivity.class);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(MVVMActivity.this, "You Clicked " + listValues.get(position), Toast.LENGTH_SHORT).show();
    }
}
