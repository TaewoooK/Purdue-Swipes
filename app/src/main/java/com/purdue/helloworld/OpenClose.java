package com.purdue.helloworld;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OpenClose {

    public static boolean isOpen(String openTime, String closeTime) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
        String dateTime = format.format(cal.getTime());
        int todayHour = Integer.parseInt(dateTime.substring(0, dateTime.indexOf(':')));
        int todayMin = Integer.parseInt(dateTime.substring(dateTime.indexOf(':') + 1), dateTime.indexOf(' '));
        String amPm = dateTime.substring(dateTime.indexOf(' '));

        if (amPm.equals("PM")) {
            todayHour += 12;
        }

        int openTimeInt = Integer.parseInt(openTime);
        int closeTimeInt = Integer.parseInt(closeTime);

        return todayHour >= openTimeInt && todayHour < closeTimeInt;
    }
}
