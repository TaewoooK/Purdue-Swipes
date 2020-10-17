package com.purdue.helloworld;

public class MealSwipeTime {
    String weekDay;
    String breakfastHours;
    String lunchHours;
    String dinnerHours;
    public MealSwipeTime(String weekDay, String breakfastHours, String lunchHours, String dinnerHours) {
        this.weekDay = weekDay;
        this.breakfastHours = breakfastHours;
        this.lunchHours = lunchHours;
        this.dinnerHours = dinnerHours;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getBreakfastHours() {
        return breakfastHours;
    }

    public void setBreakfastHours(String breakfastHours) {
        this.breakfastHours = breakfastHours;
    }

    public String getLunchHours() {
        return lunchHours;
    }

    public void setLunchHours(String lunchHours) {
        this.lunchHours = lunchHours;
    }

    public String getDinnerHours() {
        return dinnerHours;
    }

    public void setDinnerHours(String dinnerHours) {
        this.dinnerHours = dinnerHours;
    }
}
