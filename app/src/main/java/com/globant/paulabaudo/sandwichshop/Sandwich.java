package com.globant.paulabaudo.sandwichshop;

/**
 * Created by paula.baudo on 27/01/2015.
 */
public class Sandwich {

    String bread;
    Boolean tomatoes;
    Boolean pickles;
    Boolean lettuce;
    Boolean mayonnaise;
    Boolean mustard;

    public Sandwich(){
        bread = "";
        tomatoes = false;
        pickles = false;
        lettuce = false;
        mayonnaise = false;
        mustard = false;
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
}
