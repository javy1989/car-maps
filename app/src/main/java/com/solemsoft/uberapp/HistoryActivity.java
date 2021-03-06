package com.solemsoft.uberapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.solemsoft.uberapp.historyRecyclerView.HistoryAdapter;
import com.solemsoft.uberapp.historyRecyclerView.HistoryObject;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private String customerOrDriver,userId;
    private RecyclerView mHitoryReciclerView;
    private RecyclerView.Adapter mHistoryAdapter;
    private RecyclerView.LayoutManager mHistoryLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        mHitoryReciclerView = findViewById(R.id.historyReciclerView);
        mHitoryReciclerView.setNestedScrollingEnabled(false);
        mHitoryReciclerView.setHasFixedSize(true);

        mHistoryLayoutManager = new LinearLayoutManager(HistoryActivity.this);
        mHitoryReciclerView.setLayoutManager(mHistoryLayoutManager);
        mHistoryAdapter = new HistoryAdapter(getDataSetHistory(), HistoryActivity.this);
        mHitoryReciclerView.setAdapter(mHistoryAdapter);
        customerOrDriver = getIntent().getExtras().getString("customerOrDriver");
        userId= FirebaseAuth.getInstance().getCurrentUser().getUid();
        getUserHistoryIds();
    }

    private ArrayList resultsHistory = new ArrayList<HistoryObject>();

    private ArrayList<HistoryObject> getDataSetHistory() {
        return resultsHistory;
    }

    private void getUserHistoryIds(){
        DatabaseReference userHistoryDatabase=FirebaseDatabase.getInstance().getReference().child("Users").child(customerOrDriver).child(userId).child("history");
        userHistoryDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for(DataSnapshot history:dataSnapshot.getChildren()){
                        FetchRideInformation(history.getKey());
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void FetchRideInformation(String rideKey) {
        DatabaseReference historyDatabase=FirebaseDatabase.getInstance().getReference().child("history").child(rideKey);
        historyDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                   String rideId=dataSnapshot.getKey();
                    HistoryObject obj = new HistoryObject(rideId);
                    resultsHistory.add(obj);
                    mHistoryAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
