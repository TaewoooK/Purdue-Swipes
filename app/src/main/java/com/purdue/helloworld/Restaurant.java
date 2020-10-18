package com.purdue.helloworld;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Parcelable;

import java.io.Serializable;

public class Restaurant  {
    String name;
    String description;
    String location;
    // the long String of all the times that the place is open
    String time;

    String menu;
    //returns the next time when the establishment is open
    // int[] nextTime;
    //returns day index of the next Time open value
    //  String nextDay;
    //if the location takes meal swipes at all
    boolean takesMealSwipes;
    //if the times of the location are only meal swipe times
    boolean takesOnlyMS;
    String titleImageID;
    // String menu;

    public Restaurant() {
    }

    public Restaurant(String name, String description, String location, String time, String titleImageID, boolean takesMS, boolean onlyMS, String menu
    ) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.time = time;
        this.titleImageID = titleImageID;
        this.takesMealSwipes = takesMS;
        this.takesOnlyMS = onlyMS;
        this.menu = menu;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isTakesMealSwipes() {
        return takesMealSwipes;
    }

    public void setTakesMealSwipes(boolean takesMealSwipes) {
        this.takesMealSwipes = takesMealSwipes;
    }

    public boolean isTakesOnlyMS() {
        return takesOnlyMS;
    }

    public void setTakesOnlyMS(boolean takesOnlyMS) {
        this.takesOnlyMS = takesOnlyMS;
    }

    public String getTitleImageID() {
        return titleImageID;
    }

    public void setTitleImageID(String titleImageID) {
        this.titleImageID = titleImageID;
    }


    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}

