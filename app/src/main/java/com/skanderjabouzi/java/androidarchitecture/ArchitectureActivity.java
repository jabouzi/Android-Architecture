package com.skanderjabouzi.java.androidarchitecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.skanderjabouzi.java.androidarchitecture.mvc.MVCActivity;
import com.skanderjabouzi.java.androidarchitecture.mvp.MVPActivity;
import com.skanderjabouzi.java.androidarchitecture.mvvm.MVVMActivity;
import com.skanderjabouzi.java.androidarchitecture.mvvm1.MVVM1Activity;

public class ArchitectureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_architecture);
    }

    public void onMVC(View view) {
        startActivity(MVCActivity.getIntent(this));
    }

    public void onMVP(View view) {
        startActivity(MVPActivity.getIntent(this));
    }

    public void onMVVM(View view) {
        startActivity(MVVMActivity.getIntent(this));
    }

    public void onMVVMBinding(View view) {
        startActivity(MVVM1Activity.getIntent(this));
    }
}
