package com.purdue.helloworld;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.purdue.helloworld.R;
import com.purdue.helloworld.Restaurant;
import com.purdue.helloworld.ui.main.PlaceholderFragment;

import java.time.format.TextStyle;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.MyHolder>{

    List<Restaurant> places;
    Utility utility;
    MealSwipe mealSwipe;
    DayOfWeek dayOfWeek;
    Date date;

    public RestaurantAdapter(List<Restaurant> places) {
        this.places= places;
        utility = new Utility();
        mealSwipe = new MealSwipe();
        //dayOfWeek = new DayOfWeek();
        date = new Date();

    }
    @Override
    public RestaurantAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_restaurant,parent,false);

        RestaurantAdapter.MyHolder myHolder = new RestaurantAdapter.MyHolder(view);
        return myHolder;
    }
    public static String getDayStringOld(Date date, Locale locale) {
        DateFormat formatter = new SimpleDateFormat("EEEE", locale);
        return formatter.format(date);
    }

    @SuppressLint("ResourceAsColor")
    public void onBindViewHolder(final RestaurantAdapter.MyHolder holder, final int position) {

        final Restaurant data = places.get(position);
      
    holder.picture.setImageResource(Utility.getDrawableName(data.getTitleImageID()));

       // holder.picture.getResources().getDrawable(data.getDrawableID());
        holder.name.setText(data.getName());
        holder.description.setText(data.getDescription());
        final String day = this.getDayStringOld(date, Locale.ENGLISH);
        int dayInt = 0;
        for (int i = 0; i < utility.parseString(data.getTime()).size(); i++){
            if (day.toUpperCase().equals(utility.parseString(data.getTime()).get(i).getWeekDay())){
                dayInt = i;
            }
        }
        String breakfast = utility.parseString(data.getTime()).get(dayInt).getBreakfastHours();
        String lunch = utility.parseString(data.getTime()).get(dayInt).getLunchHours();
        String dinner = utility.parseString(data.getTime()).get(dayInt).getDinnerHours();
        holder.takesOrNo.setBackgroundColor(R.color.notgreen);
       // holder.nextTimeOpen.setText();

        if (mealSwipe.isMealSwipe(breakfast,lunch,dinner)) {
            holder.takesMealSwipes.setText("Open for Meal Swipes");
            holder.takesOrNo.setBackgroundColor(Color.GREEN);
         //   holder.nextTimeOpen.setText("Open Today: " + mealSwipe.timeOpenNow(breakfast,lunch,dinner));

        } else {
            holder.takesMealSwipes.setText("Closed for Meal Swipes");
            holder.takesOrNo.setBackgroundColor(Color.RED);
            //holder.nextTimeOpen.setText("Closed");
        }
        //System.out.println(data.getDate_class2());
        final Context context = holder.itemView.getContext();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences mySharedPreferences = context.getSharedPreferences("time", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = mySharedPreferences.edit();
                      //  System.out.println(data.getMenu());
                editor.putString("time", data.getTime()).apply();
                SharedPreferences mySharedPreferences2 = context.getSharedPreferences("menu", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor2 = mySharedPreferences2.edit();
                editor2.putString("menu", data.getMenu()).apply();

               // Bundle bundle = new Bundle();
               // bundle.putString("time", data.getTime());
               // bundle.putString("menu", data.getMenu());
                PlaceholderFragment fragment = new PlaceholderFragment();
              //  fragment.setArguments(bundle);
                Intent intent = new Intent(context,RestaurantInfo.class);
                context.startActivity(intent);


            }
        });
        holder.map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utility.openMaps(data.getLocation(),holder.itemView.getContext());
            }
        });
    }
        @Override
        public int getItemCount() {
            return places.size();
        }


    class MyHolder extends RecyclerView.ViewHolder{
        ImageView picture;
        TextView name,description,nextTimeOpen, takesMealSwipes;
        Button takesOrNo;

        ImageButton map;
        public MyHolder(View itemView) {
            super(itemView);
            picture = (ImageView) itemView.findViewById(R.id.picture);
            name = (TextView) itemView.findViewById(R.id.name);
            description = (TextView) itemView.findViewById(R.id.description);
         //   nextTimeOpen = (TextView) itemView.findViewById(R.id.nextTimeOpen);

            takesMealSwipes = (TextView) itemView.findViewById(R.id.takesMealSwipes);
            takesOrNo =  itemView.findViewById(R.id.takesMealSwipes);

            map = itemView.findViewById(R.id.mapNavigate);

        }
    }




}

