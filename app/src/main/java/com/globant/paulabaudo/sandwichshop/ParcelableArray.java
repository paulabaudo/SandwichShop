package com.globant.paulabaudo.sandwichshop;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by paula.baudo on 27/01/2015.
 */
public class ParcelableArray implements Parcelable{

    ArrayList<Sandwich> orders;

    public ParcelableArray(){

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Bundle ordersBundle = new Bundle();
        ordersBundle.putParcelableArrayList("orders", orders);
        dest.writeBundle(ordersBundle);
    }

    public ArrayList<Sandwich> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Sandwich> orders) {
        this.orders = orders;
    }

    public static final Parcelable.Creator<ParcelableArray> CREATOR =
            new Parcelable.Creator<ParcelableArray>(){

                @Override
                public ParcelableArray createFromParcel(Parcel source) {
                    ParcelableArray ordersArray = new ParcelableArray();
                    Bundle ordersBundle = source.readBundle(Sandwich.class.getClassLoader());
                    ordersArray.orders = ordersBundle.getParcelableArrayList("orders");
                    return ordersArray;
                }

                @Override
                public ParcelableArray[] newArray(int size) {
                    return new ParcelableArray[size];
                }
            };

}