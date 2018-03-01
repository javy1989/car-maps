package com.solemsoft.uberapp.historyRecyclerView;

/**
 * Created by Ricardo.Bravo on 28/02/2018.
 */

public class HistoryObject {
    private String rideId;

    public HistoryObject(String rideId){
        this.rideId=rideId;
    }

    public String getRideId() {
        return rideId;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }
}
