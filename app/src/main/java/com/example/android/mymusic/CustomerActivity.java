package com.example.android.mymusic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CustomerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }
}
