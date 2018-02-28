package com.solemsoft.uberapp.historyRecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.solemsoft.uberapp.R;


/**
 * Created by Ricardo.Bravo on 28/02/2018.
 */

public class HistoryViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {


    public TextView rideId;
    public HistoryViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        rideId=itemView.findViewById(R.id.rideId);
    }

    @Override
    public void onClick(View v) {

    }


}
