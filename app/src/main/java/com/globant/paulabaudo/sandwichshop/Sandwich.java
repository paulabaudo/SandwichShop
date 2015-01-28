package com.globant.paulabaudo.sandwichshop;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by paula.baudo on 27/01/2015.
 */
public class Sandwich implements Parcelable {

    String bread;
    Boolean tomatoes;
    Boolean pickles;
    Boolean lettuce;
    Boolean mayonnaise;
    Boolean mustard;

    public Sandwich(){
        this.bread = "White";
        this.tomatoes = false;
        this.pickles = false;
        this.lettuce = false;
        this.mayonnaise = false;
        this.mustard = false;
    }

    public Sandwich(String bread, Boolean tomatoes, Boolean pickles, Boolean lettuce, Boolean mayonnaise, Boolean mustard) {
        this.bread = bread;
        this.tomatoes = tomatoes;
        this.pickles = pickles;
        this.lettuce = lettuce;
        this.mayonnaise = mayonnaise;
        this.mustard = mustard;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public Boolean getTomatoes() {
        return tomatoes;
    }

    public void setTomatoes(Boolean tomatoes) {
        this.tomatoes = tomatoes;
    }

    public Boolean getPickles() {
        return pickles;
    }

    public void setPickles(Boolean pickles) {
        this.pickles = pickles;
    }

    public Boolean getLettuce() {
        return lettuce;
    }

    public void setLettuce(Boolean lettuce) {
        this.lettuce = lettuce;
    }

    public Boolean getMayonnaise() {
        return mayonnaise;
    }

    public void setMayonnaise(Boolean mayonnaise) {
        this.mayonnaise = mayonnaise;
    }

    public Boolean getMustard() {
        return mustard;
    }

    public void setMustard(Boolean mustard) {
        this.mustard = mustard;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(bread);
        dest.writeInt(tomatoes?1:0);
        dest.writeInt(pickles?1:0);
        dest.writeInt(lettuce?1:0);
        dest.writeInt(mayonnaise?1:0);
        dest.writeInt(mustard?1:0);
    }

    public static final Creator<Sandwich> CREATOR = new Creator<Sandwich>(){

        @Override
        public Sandwich createFromParcel(Parcel source) {
            return new Sandwich(source);
        }

        @Override
        public Sandwich[] newArray(int size) {
            return new Sandwich[size];
        }
    };

    private Sandwich (Parcel source){
        bread = source.readString();
        tomatoes = (source.readInt()==1);
        pickles = (source.readInt()==1);
        lettuce = (source.readInt()==1);
        mayonnaise = (source.readInt()==1);
        mustard = (source.readInt()==1);
    }
}
