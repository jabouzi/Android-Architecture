package com.skanderjabouzi.java.androidarchitecture.mvvm1;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.skanderjabouzi.java.androidarchitecture.R;
import com.skanderjabouzi.java.androidarchitecture.databinding.ActivityMvvmBinding;
import com.skanderjabouzi.java.androidarchitecture.model.UserAdapter;

public class MVVM1Activity extends AppCompatActivity {
    private final UserViewModel viewModel = new UserViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMvvmBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        UserAdapter adapter = new UserAdapter();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        binding.setViewModel(this.viewModel);
        viewModel.onRefresh();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, MVVM1Activity.class);
    }
}
