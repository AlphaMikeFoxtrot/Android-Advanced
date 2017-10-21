package com.example.anonymous.charlietangoi;

/**
 * Created by ANONYMOUS on 09-Oct-17.
 */

public class Coffee {

    private int mImageResId;
    private String mCoffeeType;
    private String mDescription;
    private int mWeight;

    public Coffee(int mImageResId, String mCoffeeType, String mDescription, int mWeight) {
        this.mImageResId = mImageResId;
        this.mCoffeeType = mCoffeeType;
        this.mDescription = mDescription;
        this.mWeight = mWeight;
    }

    public int getmImageResId() {
        return mImageResId;
    }

    public String getmCoffeeType() {
        return mCoffeeType;
    }

    public String getmDescription() {
        return mDescription;
    }

    public int getmWeight() {
        return mWeight;
    }
}
