package com.purdue.helloworld;

import android.graphics.drawable.Drawable;
import android.media.Image;

public class Restaurant {
    String name;
    String description;
    String location;
    // the long String of all the times that the place is open
    String time;
    //returns the next time when the establishment is open
    int[] nextTime;
    //returns day index of the next Time open value
    String nextDay;
    //if the location takes meal swipes at all
    boolean takesMealSwipes;
    //if the times of the location are only meal swipe times
    boolean takesOnlyMS;
    String titleImageID;


    public Restaurant(String name, String description, String location, boolean takesMS, boolean onlyMS) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.takesMealSwipes = takesMS;
        this.takesOnlyMS = onlyMS;
    }

    public String getName() {
        return name;
    }
    public String getLocationURL(){

        return location;
    }
    public String getMealSwipeTime(){

        return time;
    }
    public int[] getNextOpenTimeRange(){

       return nextTime;
    }
    public boolean takesMS(){
        return takesMealSwipes;
    }
    public String getDescription() {
        return description;
    }
    public String getDrawableID(){
        return titleImageID;
    }
}
