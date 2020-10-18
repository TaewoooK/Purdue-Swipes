package com.purdue.helloworld;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MealSwipe {

    public static boolean isMealSwipe(String breakfastTime, String lunchTime, String dinnerTime) {

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
        String dateTime = format.format(cal.getTime());
        double todayHour = Integer.parseInt(dateTime.substring(0, dateTime.indexOf(':')));
        double todayMin = Integer.parseInt(dateTime.substring(dateTime.indexOf(':') + 1, dateTime.indexOf(' ')));
        String amPm = dateTime.substring(dateTime.indexOf(' '));

        if (amPm.equals("PM")) {
            todayHour += 12;
        }

        todayHour += (todayMin/60);

        if (!breakfastTime.equals("0-0")) {
            double startTime = Integer.parseInt(breakfastTime.substring(0, breakfastTime.indexOf('-')));
            double endTime = Integer.parseInt(breakfastTime.substring(breakfastTime.indexOf('-') + 1));
            return todayHour >= startTime && todayHour < endTime;
        } else if (!lunchTime.equals("0-0")) {
            double startTime = Integer.parseInt(lunchTime.substring(0, lunchTime.indexOf('-')));
            double endTime = Integer.parseInt(lunchTime.substring(lunchTime.indexOf('-') + 1));
            return todayHour >= startTime && todayHour < endTime;
        }
        else if (!dinnerTime.equals("0-0")) {
            double startTime = Integer.parseInt(dinnerTime.substring(0, dinnerTime.indexOf('-')));
            double endTime = Integer.parseInt(dinnerTime.substring(dinnerTime.indexOf('-') + 1));
            return todayHour >= startTime && todayHour < endTime;
        }

        return false;
    }
}
