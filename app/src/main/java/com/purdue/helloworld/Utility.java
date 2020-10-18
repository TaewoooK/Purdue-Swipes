package com.purdue.helloworld;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.util.ArrayList;

public class Utility {

    public static void openMaps(String coordinates, Context context) {
        Uri gmmIntentUri = Uri.parse(coordinates);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        context.startActivity(mapIntent);
    }

    public static ArrayList<MealSwipeTime> parseString(String retrievedValue) {
        ArrayList<MealSwipeTime> times = new ArrayList<>();
        //String[] days = {"Monday","Tuesday","Wednesday","Thursday", "Friday", "Saturday", "Sunday"};
        ArrayList<String> days = new ArrayList<>();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");

        String[] split = retrievedValue.split(",");
        String breakfast = "";
        String breakfasthours = "";
        String lunch = "";
        String lunchhours = "";
        String dinner = "";
        String dinnerhours = "";
        int repeat = 0;
        System.out.println(split);
        String test = "Monday-Breakfast-8-10-Lunch-11-2-Dinner-6-8(5),Saturday-Breakfast-8-10-Lunch-11-2-Dinner-0-0";
        for (String s : split) {
            int index = s.indexOf("-");
            //gets day
            String day = s.substring(0, index);
            System.out.println(day);
            s = s.substring(index + 1);
            int index2 = s.indexOf("-");

            while (index2 != -1) {
                //gets breakfast
                if (s.substring(0, index2).equals("Breakfast")) {
                    //gets breakfast
                    breakfast = s.substring(0, index2);
                    //cuts breakfast and -
                    s = s.substring(index2 + 1);
                    //index of - after first time
                    int indextemp = s.indexOf("-");
                    //adding start time
                    //8
                    breakfasthours += s.substring(0, indextemp);
                    breakfasthours += "-";
                    s = s.substring(indextemp + 1);
                    //getting index of dash after second time
                    int indextemp2 = s.indexOf("-");
                    //adding second time
                    breakfasthours += s.substring(0, indextemp2);
                    s = s.substring(indextemp2 + 1);
                    index2 = s.indexOf("-");

                } else if (s.substring(0, index2).equals("Lunch")) {
                    //gets lunch
                    lunch = s.substring(0, index2);
                    //cuts breakfast and -
                    s = s.substring(index2 + 1);
                    //index of - after first time
                    int indextemp = s.indexOf("-");
                    //adding start time
                    lunchhours += s.substring(0, indextemp);
                    lunchhours += "-";
                    s = s.substring(indextemp + 1);
                    //getting index of dash after second time
                    int indextemp2 = s.indexOf("-");
                    //adding second time
                    lunchhours += s.substring(0, indextemp2);
                    s = s.substring(indextemp2 + 1);
                    index2 = s.indexOf("-");
                } else {
                    //gets dinner
                    dinner = s.substring(0, index2);
                    //cuts dinner and -
                    s = s.substring(index2 + 1);
                    //index of - after first time
                    int indextemp = s.indexOf("-");
                    //adding start time
                    //8
                    dinnerhours += s.substring(0, indextemp);
                    dinnerhours += "-";
                    s = s.substring(indextemp + 1);
                    //getting index of dash after second time
                    int indextemp2 = s.indexOf("(");
                    //adding second time
                    dinnerhours += s.substring(0, indextemp2);
                    s = s.substring(indextemp2 + 1);
                    //causes while loop to stop
                    index2 = -1;
                    repeat = Integer.parseInt(s.substring(0, 1));
                    System.out.println("Repeat: " + repeat);
                    if (repeat > 1) {
                        int dayPosition = days.indexOf(day);
                        for (int i = 0; i<repeat;i++){
                            String currentDay = days.get(i+dayPosition);
                            day = currentDay;
                            times.add(new MealSwipeTime(day,breakfasthours,lunchhours,dinnerhours));


                        }
                    } else {
                        times.add(new MealSwipeTime(day,breakfasthours,lunchhours,dinnerhours));
                    }
                    breakfasthours = "";
                    lunchhours = "";
                    dinnerhours = "";

                }


                /*System.out.println(breakfast);
                System.out.println(breakfasthours);
                System.out.println(lunch);
                System.out.println(lunchhours);
                System.out.println(dinner);
                System.out.println(dinnerhours);*/

            }
        }

        return times;
    }
    public static int getDrawableName(String drawable) {
        int draw = 0;
        switch (drawable) {
            case "allamerican": draw=R.drawable.allamerican;
                break;
            case "petesza": draw=R.drawable.petesza;
                break;
            case "onebowl": draw=R.drawable.onebowl;
                break;
            case "caryknightspot": draw=R.drawable.caryknightspot;
                break;
            case "chickfila": draw=R.drawable.chickfila;
                break;
            case "cosi": draw=R.drawable.cosi;
                break;
            case "earhart": draw=R.drawable.earhart;
                break;
            case "earhartotg": draw=R.drawable.otg;
                break;
            case "ford": draw=R.drawable.ford;
                break;
            case "fordotg": draw=R.drawable.otg;
                break;
            case "freshens": draw=R.drawable.freshens;
                break;
            case "harrisongrill": draw=R.drawable.harrisongrill;
                break;
            case "hillenbrand": draw=R.drawable.hillenbrand;
                break;
            case "jerseymikes": draw=R.drawable.jerseymikes;
                break;
            case "knoyotg": draw=R.drawable.otg;
                break;
            case "lawsonotg": draw=R.drawable.otg;
                break;
            case "lilyotg": draw=R.drawable.otg;
                break;
            case "panera": draw=R.drawable.panera;
                break;
            case "qdoba": draw=R.drawable.qdoba;
                break;
            case "sushiboss": draw=R.drawable.sushiboss;
                break;
            case "wiley": draw=R.drawable.wiley;
                break;
            case "windsor": draw=R.drawable.windsor;
                break;
            case "windsorotg": draw=R.drawable.windsorotg;
                break;
        }
        return draw;
    }
}