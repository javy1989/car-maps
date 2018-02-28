package com.solemsoft.uberapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView mHitoryReciclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        mHitoryReciclerView=findViewById(R.id.historyReciclerView);
        mHitoryReciclerView.setNestedScrollingEnabled(true);
        mHitoryReciclerView.setHasFixedSize(true);


    }
}
