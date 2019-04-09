package com.skanderjabouzi.java.androidarchitecture.mvvmbiding;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
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

import com.skanderjabouzi.java.androidarchitecture.R;
import com.skanderjabouzi.java.androidarchitecture.databinding.ActivityMvvmBinding;
import com.skanderjabouzi.java.androidarchitecture.mvvm1.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class MVVMBindingActivity extends AppCompatActivity {

    private List<String> listValues = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ListView list;
    private Button retryButton;
    private ProgressBar progress;
    private UserViewModel viewModel = new UserViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMvvmBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        setTitle("MVVM Binding Activity");

        CountriesAdapter adapter = new CountriesAdapter();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
//        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MVVMBindingActivity.this, "You Clicked " + listValues.get(position), Toast.LENGTH_SHORT).show();
//            }
//        });
        binding.setViewModel(viewModel);
        viewModel.onRefresh();
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, MVVMBindingActivity.class);
    }
}
