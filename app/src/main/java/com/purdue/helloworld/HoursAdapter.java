package com.purdue.helloworld;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HoursAdapter  extends RecyclerView.Adapter<HoursAdapter.MyHolder>{

    List<MealSwipeTime> places;
    Utility utility;
    MealSwipe mealSwipe;
    DayOfWeek dayOfWeek;
    Date date;

    public HoursAdapter(List<MealSwipeTime> places) {
        this.places= places;
    }
    @Override
    public HoursAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_hours,parent,false);

        HoursAdapter.MyHolder myHolder = new HoursAdapter.MyHolder(view);
        return myHolder;
    }
    public static String getDayStringOld(Date date, Locale locale) {
        DateFormat formatter = new SimpleDateFormat("EEEE", locale);
        return formatter.format(date);
    }

    public void onBindViewHolder(final HoursAdapter.MyHolder holder, final int position) {

        final MealSwipeTime data = places.get(position);
        holder.weekday.setText(data.getWeekDay());
        if (data.getBreakfastHours().equals("0-0")){
            holder.breakfast.setText(R.string.nomealswipes);
            //holder.breakfastLayout.setVisibility();
        } else {
            holder.breakfast.setText(Utility.toTime(data.getBreakfastHours()));
        }
        if (data.getLunchHours().equals("0-0")){
            holder.lunch.setText(R.string.nomealswipes);
           // holder.lunchLayout.setVisibility();
        } else {
            holder.lunch.setText(Utility.toTime(data.getLunchHours()));
        }
        if (data.getDinnerHours().equals("0-0")){
            holder.dinner.setText(R.string.nomealswipes);
           // holder.dinnerLayout.setVisibility();
        } else {
            holder.dinner.setText(Utility.toTime(data.getDinnerHours()));
        }
      /*  holder.breakfast.setText(data.getBreakfastHours());
        holder.lunch.setText(data.getLunchHours());
        holder.dinner.setText(data.getDinnerHours());
*/


    }
    @Override
    public int getItemCount() {
        return places.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        TextView weekday,breakfast,lunch,dinner;

        public MyHolder(View itemView) {
            super(itemView);
            weekday = (TextView) itemView.findViewById(R.id.day);
            breakfast = (TextView) itemView.findViewById(R.id.breakfast);
            lunch = (TextView) itemView.findViewById(R.id.lunch);
            dinner = (TextView) itemView.findViewById(R.id.dinner);
            breakfast = (TextView) itemView.findViewById(R.id.breakfast);
            lunch = (TextView) itemView.findViewById(R.id.lunch);
            dinner = (TextView) itemView.findViewById(R.id.dinner);

        }
    }




}

