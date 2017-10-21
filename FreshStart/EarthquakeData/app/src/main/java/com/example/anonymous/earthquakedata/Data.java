package com.example.anonymous.earthquakedata;

import static com.example.anonymous.earthquakedata.R.id.date;

/**
 * Created by ANONYMOUS on 03-Oct-17.
 */

public class Data {

    private double mMagnitude;
    private String mLocation;
    private long mTime;
    private String mUrl;

    public Data(double mag, String loc, long time, String url){

        mMagnitude = mag;
        mLocation = loc;
        mTime = time;
        mUrl = url;

    }

    public double getmMagnitude() {
        return mMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }

    public long getmTime() {
        return mTime;
    }

    public String getmUrl() {
        return mUrl;
    }
}
