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
            //holder.breakfastLayout.setVisibility();
        } else {
            holder.breakfast.setText(data.getBreakfastHours());
        }
        if (data.getLunchHours().equals("0-0")){
           // holder.lunchLayout.setVisibility();
        } else {
            holder.lunch.setText(data.getLunchHours());
        }
        if (data.getDinnerHours().equals("0-0")){
           // holder.dinnerLayout.setVisibility();
        } else {
            holder.dinner.setText(data.getDinnerHours());
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
        LinearLayout breakfastLayout,lunchLayout,dinnerLayout;

        public MyHolder(View itemView) {
            super(itemView);
            weekday = (TextView) itemView.findViewById(R.id.day);
            breakfast = (TextView) itemView.findViewById(R.id.breakfast);
            lunch = (TextView) itemView.findViewById(R.id.lunch);
            dinner = (TextView) itemView.findViewById(R.id.dinner);
            breakfastLayout = (LinearLayout) itemView.findViewById(R.id.breakfastLayout);
            lunchLayout = (LinearLayout) itemView.findViewById(R.id.lunchLayout);
            dinnerLayout = (LinearLayout) itemView.findViewById(R.id.dinnerLayout);

        }
    }




}

