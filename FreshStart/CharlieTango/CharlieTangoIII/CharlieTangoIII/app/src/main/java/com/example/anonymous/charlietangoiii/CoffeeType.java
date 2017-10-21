package com.example.anonymous.charlietangoiii;

/**
 * Created by ANONYMOUS on 10-Oct-17.
 */

public class CoffeeType {

    // the type of coffee (eg. Bru Instant, Nescafe sunrise, etc)
    private String mCoffeeType;

    // net weight of the coffee (eg. 5 grams, 10 grams)
    private int mCoffeeNetWeight;

    // coffee cost
    // this has been taken into account
    // as a means for the user to identify
    // which coffee do they drink
    private int mRuppees;

    // Brand image resource id
    private int mImageResourceId;

    public CoffeeType(String CoffeeType, int CoffeeNetWeight, int Ruppees, int ImageResourceId) {

        mCoffeeNetWeight = CoffeeNetWeight;
        mCoffeeType = CoffeeType;
        mImageResourceId = ImageResourceId;
        mRuppees = Ruppees;

    }

    public String getmCoffeeType() {
        return mCoffeeType;
    }

    public int getmCoffeeNetWeight() {
        return mCoffeeNetWeight;
    }

    public int getmRuppees() {
        return mRuppees;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }
}
