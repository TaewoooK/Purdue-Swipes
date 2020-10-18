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
        String amPm = dateTime.substring(dateTime.indexOf(' ') + 1);

        if (amPm.equals("PM")) {
            todayHour += 12;
        }

        if(amPm.equals("AM") && todayHour == 12) {
            todayHour = 0;
        }

        boolean found = false;

        todayHour += (todayMin/60.0);
        //todayHour = 12.5;
        if (!breakfastTime.equals("0-0")) {
            double startTime = Double.parseDouble(breakfastTime.substring(0, breakfastTime.indexOf('-')));
            double endTime = Double.parseDouble(breakfastTime.substring(breakfastTime.indexOf('-') + 1));
            if (todayHour >= startTime && todayHour < endTime)
                found = true;

        } else if (!lunchTime.equals("0-0")) {
            double startTime = Double.parseDouble(lunchTime.substring(0, lunchTime.indexOf('-')));
            double endTime = Double.parseDouble(lunchTime.substring(lunchTime.indexOf('-') + 1));
            if (todayHour >= startTime && todayHour < endTime)
                found = true;

        } else if (!dinnerTime.equals("0-0")) {
            double startTime = Double.parseDouble(dinnerTime.substring(0, dinnerTime.indexOf('-')));
            double endTime = Double.parseDouble(dinnerTime.substring(dinnerTime.indexOf('-') + 1));
            if (todayHour >= startTime && todayHour < endTime)
                found = true;
        }

        return found;
    }
}
