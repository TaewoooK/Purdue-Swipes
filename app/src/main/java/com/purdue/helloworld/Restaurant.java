package com.purdue.helloworld;

import android.graphics.drawable.Drawable;
import android.media.Image;

import java.io.Serializable;

public class Restaurant implements Serializable {
    String name;
    String description;
    String location;
    // the long String of all the times that the place is open
    String time;
    //returns the next time when the establishment is open
   // int[] nextTime;
    //returns day index of the next Time open value
  //  String nextDay;
    //if the location takes meal swipes at all
    boolean takesMealSwipes;
    //if the times of the location are only meal swipe times
    boolean takesOnlyMS;
    int titleImageID;

    public Restaurant() {
    }

    public Restaurant(String name, String description, String location, String time, int titleImageID, boolean takesMS, boolean onlyMS
    ) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.time = time;
        this.titleImageID = titleImageID;
        this.takesMealSwipes = takesMS;
        this.takesOnlyMS = onlyMS;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
    public boolean takesMS(){
        return takesMealSwipes;
    }
    public String getDescription() {
        return description;
    }
    public int getDrawableID(){
        return titleImageID;
    }
}
