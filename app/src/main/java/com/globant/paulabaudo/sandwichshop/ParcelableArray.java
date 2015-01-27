package com.globant.paulabaudo.sandwichshop;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by paula.baudo on 27/01/2015.
 */
public class ParcelableArray extends ArrayList<Sandwich> implements Parcelable{
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
